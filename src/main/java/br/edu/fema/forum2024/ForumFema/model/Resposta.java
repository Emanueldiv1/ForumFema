package br.edu.fema.forum2024.ForumFema.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
public class Resposta {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private Long id;
	    private String mensagem;
	    
	    @ManyToOne
	    private Topico topico;
	    private LocalDateTime dataCriacao = LocalDateTime.now();
	    
	    
	    @ManyToOne
	    private Usuario autor;
	    private Boolean solucao = false;
	    
	    
	    public Resposta() {
	    }

	    public Resposta(String mensagem, Topico topico, LocalDateTime dataCriacao, Usuario autor, Boolean solucao) {
	        this.mensagem = mensagem;
	        this.topico = topico;
	        this.dataCriacao = dataCriacao;
	        this.autor = autor;
	        this.solucao = solucao;
	    }
	    
	    
	    
		@Override
		public int hashCode() {
			return Objects.hash(id);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Resposta other = (Resposta) obj;
			return Objects.equals(id, other.id);
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

		public Topico getTopico() {
			return topico;
		}

		public void setTopico(Topico topico) {
			this.topico = topico;
		}

		public LocalDateTime getDataCriacao() {
			return dataCriacao;
		}

		public void setDataCriacao(LocalDateTime dataCriacao) {
			this.dataCriacao = dataCriacao;
		}

		public Usuario getAutor() {
			return autor;
		}

		public void setAutor(Usuario autor) {
			this.autor = autor;
		}

		public Boolean getSolucao() {
			return solucao;
		}

		public void setSolucao(Boolean solucao) {
			this.solucao = solucao;
		}

		
		
		
		
		
		
		
	    
	    
		

	    
}
