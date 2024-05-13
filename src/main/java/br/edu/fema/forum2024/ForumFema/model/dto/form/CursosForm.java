package br.edu.fema.forum2024.ForumFema.model.dto.form;

import br.edu.fema.forum2024.ForumFema.model.Curso;
import br.edu.fema.forum2024.ForumFema.repository.CursosRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;


public class CursosForm {
	
	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String nome;
	
	@NotEmpty
	@NotNull
	@Length(min = 10)
    private String categoria;
    
    
    public Curso converter(CursosRepository cursoRepository) {
    	
    	return new Curso(nome,categoria);
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
