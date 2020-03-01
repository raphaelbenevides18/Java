package br.com.rlb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "filmes")
public class Filme implements Serializable {

	private static final long serialVersionUID = 3150944312674004903L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilme;
	@Column(length = 70, unique = true)
	@NotEmpty(message = "Nao aceita titulo vazio")
	@NotNull(message = "Nao aceita titulo null")
	private String titulo;
	@Column(length = 70)
	@NotEmpty(message = "Nao aceita categoria vazio")
	@NotNull(message = "Nao aceita  categoria null")
	private String categoria;
	@Column(length = 90)
	private String diretor;
	@Column(length = 250)
	private String imagem;
	@Column(length = 250)
	private String trailer;

	public Filme() {

	}

	public Filme(Long idFilme,
			@NotEmpty(message = "Nao aceita titulo vazio") @NotNull(message = "Nao aceita titulo null") String titulo,
			@NotEmpty(message = "Nao aceita categoria vazio") @NotNull(message = "Nao aceita  categoria null") String categoria,
			String diretor, String imagem, String trailer) {
		super();
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.categoria = categoria;
		this.diretor = diretor;
		this.imagem = imagem;
		this.trailer = trailer;
	}

	public Filme(
			@NotEmpty(message = "Nao aceita titulo vazio") @NotNull(message = "Nao aceita titulo null") String titulo,
			@NotEmpty(message = "Nao aceita categoria vazio") @NotNull(message = "Nao aceita  categoria null") String categoria,
			String diretor, String imagem, String trailer) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.diretor = diretor;
		this.imagem = imagem;
		this.trailer = trailer;
	}

	@Override
	public String toString() {
		return "Filme [idFilme=" + idFilme + ", titulo=" + titulo + ", categoria=" + categoria + ", diretor=" + diretor
				+ ", imagem=" + imagem + ", trailer=" + trailer + "]";
	}

	public Long getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

}
