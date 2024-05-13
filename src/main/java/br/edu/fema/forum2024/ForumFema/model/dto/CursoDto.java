package br.edu.fema.forum2024.ForumFema.model.dto;

import br.edu.fema.forum2024.ForumFema.model.Curso;
import org.springframework.data.domain.Page;

public class CursoDto {
	private Long id;
	
	private String nome;
	
    private String categoria;
    
    
    public CursoDto(Curso curso) {
    	super();
    	this.id = curso.getId();
    	this.nome = curso.getNome();
    	this.categoria = curso.getCategoria();
}
    
    public static Page<CursoDto> converter(Page<Curso> cursos){
    	
    	return cursos.map(CursoDto::new);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
    
    
    

}
