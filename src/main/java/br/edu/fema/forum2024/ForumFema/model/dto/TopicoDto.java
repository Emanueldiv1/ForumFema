package br.edu.fema.forum2024.ForumFema.model.dto;

import java.time.LocalDateTime;
import br.edu.fema.forum2024.ForumFema.model.Topico;
import org.springframework.data.domain.Page;

public class TopicoDto {
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	
	public TopicoDto(Topico topico) {
		super();
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
}
	
	public static Page<TopicoDto> converter(Page<Topico> topicos){

		return topicos.map(TopicoDto::new);
		//return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
		
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	
	

}
