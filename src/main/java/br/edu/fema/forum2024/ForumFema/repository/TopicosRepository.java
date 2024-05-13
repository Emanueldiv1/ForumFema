package br.edu.fema.forum2024.ForumFema.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.forum2024.ForumFema.model.StatusTopico;
import br.edu.fema.forum2024.ForumFema.model.Topico;


public interface TopicosRepository extends JpaRepository<Topico,Long> {
	
	
	Page<Topico> findByCursoNome(String nomeCurso, Pageable paninacao);

    Page<Topico> findByStatus(StatusTopico status, Pageable paginacao);


	

}
