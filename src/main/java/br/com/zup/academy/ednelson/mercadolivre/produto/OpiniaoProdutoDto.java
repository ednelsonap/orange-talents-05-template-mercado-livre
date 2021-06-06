package br.com.zup.academy.ednelson.mercadolivre.produto;

import br.com.zup.academy.ednelson.mercadolivre.usuario.UsuarioDto;

public class OpiniaoProdutoDto {

	private Long id;
	private Integer nota;
	private String titulo;
	private String descricao;
	private UsuarioDto usuario;
	private ProdutoDto produto;
	
	public OpiniaoProdutoDto(OpiniaoProduto opiniaoProduto) {
		this.id = opiniaoProduto.getId();
		this.nota = opiniaoProduto.getNota();
		this.titulo = opiniaoProduto.getTitulo();
		this.descricao = opiniaoProduto.getDescricao();
		this.usuario = new UsuarioDto(opiniaoProduto.getUsuario());
		this.produto = new ProdutoDto(opiniaoProduto.getProduto());
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

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public ProdutoDto getProduto() {
		return produto;
	}
	
}
