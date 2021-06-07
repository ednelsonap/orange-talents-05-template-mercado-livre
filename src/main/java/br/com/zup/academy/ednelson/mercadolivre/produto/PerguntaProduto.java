package br.com.zup.academy.ednelson.mercadolivre.produto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;

@Entity
public class PerguntaProduto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	private LocalDateTime instanteDoCadastro = LocalDateTime.now();
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Produto produto;
	
	/*
	 * construtor criado somente para utilização do hibernate
	 */
	@Deprecated
	public PerguntaProduto() {
	
	}
	
	public PerguntaProduto(@NotBlank String titulo, @NotBlank String descricao,
			Usuario usuario, Produto produto) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuario = usuario;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getInstanteDoCadastro() {
		return instanteDoCadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Produto getProduto() {
		return produto;
	}
	
}
