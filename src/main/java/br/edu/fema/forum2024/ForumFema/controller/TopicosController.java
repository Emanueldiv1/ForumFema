package br.edu.fema.forum2024.ForumFema.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import br.edu.fema.forum2024.ForumFema.model.dto.form.AtualizacaoTopicoForm;
import br.edu.fema.forum2024.ForumFema.model.dto.DetalhesDoTopicoDto;
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

import br.edu.fema.forum2024.ForumFema.model.StatusTopico;
import br.edu.fema.forum2024.ForumFema.model.Topico;
import br.edu.fema.forum2024.ForumFema.model.dto.TopicoDto;
import br.edu.fema.forum2024.ForumFema.model.dto.form.TopicosForm;
import br.edu.fema.forum2024.ForumFema.repository.CursosRepository;
import br.edu.fema.forum2024.ForumFema.repository.TopicosRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	
	@Autowired
    private TopicosRepository topicosRepository;
	
	@Autowired
    private CursosRepository cursosRepository;
	 
	
	@GetMapping
    @Cacheable(value = "ListaDeTopicos")
    public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso,
                                 @RequestParam(required = false) StatusTopico status,
                                 @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10)
                                 Pageable paginacao) {


        Page<Topico> topicos = null;
        if (nomeCurso != null){
            topicos = topicosRepository.findByCursoNome(nomeCurso, paginacao);
        }
        else if ( status != null) {
            topicos = topicosRepository.findByStatus(status, paginacao);
        }
        else{
            topicos = topicosRepository.findAll(paginacao);
        }
        return TopicoDto.converter(topicos);


    }
	
	
	@PostMapping
	@Transactional
    @CacheEvict(value = "ListaDeTopicos", allEntries = true )
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicosForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursosRepository);
		topicosRepository.save(topico);
		
		URI uri = uriBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
     @GetMapping("/{id}")
     public ResponseEntity<DetalhesDoTopicoDto> detalhar (@PathVariable Long id){

         Optional<Topico> topico = topicosRepository.findById(id);
         if (topico.isPresent()) {
             return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
         }

         return ResponseEntity.notFound().build();
     }
        
    /* @RequestMapping("/statusTopicos")
     public Page<TopicoDto> listas(StatusTopico status) {
            if (status == null) {
                Page<Topico> topicos = topicosRepository.findAll();
                return TopicoDto.converter(topicos);
            } else {
                Page<Topico> topicos = topicosRepository.findByStatus(status);
                return TopicoDto.converter(topicos);
            }

    }
    */

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "ListaDeTopicos", allEntries = true )
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        Optional<Topico>  optional = topicosRepository.findById(id);
        if (optional.isPresent()){
            Topico topico = form.atualizar(id, topicosRepository);
            return ResponseEntity.ok(new TopicoDto((topico)));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "ListaDeTopicos", allEntries = true )
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Topico>  optional = topicosRepository.findById(id);
        if (optional.isPresent()){
            topicosRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }


	

}
