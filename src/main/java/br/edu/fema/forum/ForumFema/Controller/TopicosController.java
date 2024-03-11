package br.edu.fema.forum.ForumFema.Controller;

import br.edu.fema.forum.ForumFema.model.Curso;
import br.edu.fema.forum.ForumFema.model.DTO.TopicosDTO;
import br.edu.fema.forum.ForumFema.model.StatusTopico;
import br.edu.fema.forum.ForumFema.model.Topico;
import br.edu.fema.forum.ForumFema.repository.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicosRepository topicosRepository;


    @GetMapping()
    public List<TopicosDTO> lista(String nomeCurso, StatusTopico status) {
        List<Topico> topicos;
        if (nomeCurso != null) {
            topicos = topicosRepository.findByCursoNome(nomeCurso);
        } else if (status != null) {
            topicos = topicosRepository.findByStatus(status);
        } else {
            topicos = topicosRepository.findAll();
        }
        return TopicosDTO.converter(topicos);
    }
}
