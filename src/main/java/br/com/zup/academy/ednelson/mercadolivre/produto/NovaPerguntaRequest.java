package br.com.zup.academy.ednelson.mercadolivre.produto;

import javax.validation.constraints.NotBlank;

import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;

public class NovaPerguntaRequest {

	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	
	public NovaPerguntaRequest(@NotBlank String titulo, @NotBlank String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public PerguntaProduto toModel(Usuario usuario, Produto produto) {
		return new PerguntaProduto(titulo, descricao, usuario, produto);	
	}
	
}
