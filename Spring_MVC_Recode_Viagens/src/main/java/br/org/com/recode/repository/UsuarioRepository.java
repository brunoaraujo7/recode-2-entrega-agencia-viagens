package br.org.com.recode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.com.recode.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);

}
