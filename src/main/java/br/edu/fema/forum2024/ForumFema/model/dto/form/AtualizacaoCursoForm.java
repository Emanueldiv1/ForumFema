package br.edu.fema.forum2024.ForumFema.model.dto.form;

import br.edu.fema.forum2024.ForumFema.model.Curso;
import br.edu.fema.forum2024.ForumFema.repository.CursosRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoCursoForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso atualizarCursos(Long id, CursosRepository cursosRepository){
        Curso curso = cursosRepository.getReferenceById(id);
        curso.setNome(this.nome);
        return curso;
    }
}
