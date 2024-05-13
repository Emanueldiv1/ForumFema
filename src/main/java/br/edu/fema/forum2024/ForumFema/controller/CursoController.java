package br.edu.fema.forum2024.ForumFema.controller;

import java.net.URI;
import java.util.Optional;

import br.edu.fema.forum2024.ForumFema.model.dto.*;
import br.edu.fema.forum2024.ForumFema.model.dto.form.AtualizacaoCursoForm;
import br.edu.fema.forum2024.ForumFema.model.dto.form.CursosForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.fema.forum2024.ForumFema.model.Curso;
import br.edu.fema.forum2024.ForumFema.repository.CursosRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/cursos")
public class CursoController {
	@Autowired
	private CursosRepository cursosRepository;


	@GetMapping
	@Cacheable(value = "ListaDeCurso")
	public Page<CursoDto> listarCursos(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10)
									   Pageable paginacao){

		Page<Curso> cursos = null;
		cursos =  cursosRepository.findAll(paginacao);
		return CursoDto.converter(cursos);

	}

	@GetMapping("/{id}")
	public Optional<Curso> procurarCurso(@PathVariable("id") Long id){
		return cursosRepository.findById(id);

	}
	
	/*metodo POST*/
	@PostMapping
	@CacheEvict(value = "ListaDeCurso", allEntries = true )
	public ResponseEntity<CursoDto> cadastrar(@RequestBody @Valid CursosForm form, UriComponentsBuilder uriBuilder){
		Curso curso = form.converter(cursosRepository);
		cursosRepository.save(curso);
		
		URI uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
		return ResponseEntity.created(uri).body(new CursoDto(curso));
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "ListaDeCurso", allEntries = true )
	public ResponseEntity<CursoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCursoForm form) {
		Optional<Curso>  optional = cursosRepository.findById(id);
		if (optional.isPresent()){
			Curso curso = form.atualizarCursos(id, cursosRepository);
			return ResponseEntity.ok(new CursoDto(curso));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "ListaDeCurso", allEntries = true )
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Curso> optional = cursosRepository.findById(id);
		if (optional.isPresent()){
			cursosRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return  ResponseEntity.notFound().build();
	}



}
