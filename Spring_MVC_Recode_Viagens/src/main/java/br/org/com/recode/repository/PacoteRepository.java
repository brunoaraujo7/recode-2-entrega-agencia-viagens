package br.org.com.recode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.com.recode.model.Pacote;

public interface PacoteRepository extends JpaRepository<Pacote, Long> {

}
