package br.edu.fema.forum2024.ForumFema.repository;

import br.edu.fema.forum2024.ForumFema.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
