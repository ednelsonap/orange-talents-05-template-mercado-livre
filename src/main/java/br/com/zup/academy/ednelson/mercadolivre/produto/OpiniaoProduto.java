package br.com.zup.academy.ednelson.mercadolivre.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;

@Entity
public class OpiniaoProduto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Min(1) @Max(5)
	private Integer nota;
	@NotBlank
	private String titulo;
	@NotBlank
	@Column(length = 500)
	private String descricao;
	@NotNull
	@ManyToOne
	private Usuario usuario;
	@NotNull
	@ManyToOne
	private Produto produto;
	
	/*
	 * construtor criado somente para uso do hibernate
	 */
	@Deprecated
	public OpiniaoProduto() {
		
	}
	
	public OpiniaoProduto(@NotNull @Min(1) @Max(5) Integer nota, @NotBlank String titulo, @NotBlank String descricao,
			@NotNull Usuario usuario, @NotNull Produto produto) {
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuario = usuario;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public Integer getNota() {
		return nota;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Produto getProduto() {
		return produto;
	}
	
}
