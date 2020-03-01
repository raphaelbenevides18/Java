package br.com.rlb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rlb.entity.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
    public Filme findByTitulo(String titulo);
	
	public Filme findByCategoria(String categoria);
	
	public Filme findByDiretor(String diretor);

}
