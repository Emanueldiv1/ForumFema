package br.edu.fema.forum2024.ForumFema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.forum2024.ForumFema.model.Curso;

public interface CursosRepository extends JpaRepository<Curso,Long> {

	Curso findByNome(String nomeCurso);
}
