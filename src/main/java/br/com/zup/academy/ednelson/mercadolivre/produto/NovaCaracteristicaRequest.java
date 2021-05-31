package br.com.zup.academy.ednelson.mercadolivre.produto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCaracteristicaRequest {

	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	
	public NovaCaracteristicaRequest(@NotBlank String nome, @NotBlank String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public CaracteristicaProduto toModel(@NotNull @Valid Produto produto) {
		return new CaracteristicaProduto(nome, descricao, produto);
	}

	public String getNome() {
		return nome;
	}
}
