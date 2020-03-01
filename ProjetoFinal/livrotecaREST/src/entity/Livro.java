package entity;

import java.io.Serializable;

public class Livro implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private Integer idLivro;
	private String titulo;
	private String autor;
	private String categoria;
	private String descricao;
	private Integer numPaginas;
	private String imagem;
	
	public Livro() {
		
	}

	public Livro(Integer idLivro, String titulo, String autor, String categoria, String descricao, Integer numPaginas,
			String imagem) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.descricao = descricao;
		this.numPaginas = numPaginas;
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria
				+ ", descricao=" + descricao + ", numPaginas=" + numPaginas + ", imagem=" + imagem + "]";
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
}
