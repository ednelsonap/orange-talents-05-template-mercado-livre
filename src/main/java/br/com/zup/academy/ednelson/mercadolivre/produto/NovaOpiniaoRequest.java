package br.com.zup.academy.ednelson.mercadolivre.produto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;

public class NovaOpiniaoRequest {
	
	@Min(1)
	@Max(5)
	@NotNull
	private Integer nota;
	@NotBlank
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String descricao;

	public NovaOpiniaoRequest(@Min(1) @Max(5) @NotNull Integer nota, @NotBlank String titulo,
			@NotBlank @Size(max = 500) String descricao) {
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public OpiniaoProduto toModel(Usuario usuario, Produto produto) {
		return new OpiniaoProduto(nota, titulo, descricao, usuario, produto);
	}
	
}
