package br.edu.fema.forum2024.ForumFema.model.dto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.edu.fema.forum2024.ForumFema.model.Curso;
import br.edu.fema.forum2024.ForumFema.model.Topico;
import br.edu.fema.forum2024.ForumFema.repository.CursosRepository;
import org.hibernate.validator.constraints.Length;

public class TopicosForm {
	
	@NotNull
	@NotEmpty
	@Length(min =5)
	private String titulo;

	@NotNull
	@NotEmpty
	@Length(min =10)
	private String mensagem;
	
	@NotNull
	@NotEmpty
	private String nomeCurso;
	
	
	public Topico converter(CursosRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(this.nomeCurso);
		
		return new Topico(titulo,mensagem, curso);
		
	}

	
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public String getMensagem() {
		return mensagem;
	}




	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}




	public String getNomeCurso() {
		return nomeCurso;
	}




	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}




	
	

}
