package br.com.zup.academy.ednelson.mercadolivre.categoria;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import br.com.zup.academy.ednelson.mercadolivre.validation.ExistsId;
import br.com.zup.academy.ednelson.mercadolivre.validation.UniqueValue;

public class NovaCategoriaRequest {

	@NotBlank
	@UniqueValue(atributo = "nome", entidade = Categoria.class)
	private String nome;
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Long categoriaMae;
	
	public NovaCategoriaRequest(@NotBlank String nome, Long categoriaMae) {
		this.nome = nome;
		this.categoriaMae = categoriaMae;
	}

	public Categoria toModel(Optional<Categoria> categoriaMae) {
		if(categoriaMae != null && categoriaMae.isPresent()) {
			return new Categoria(nome, categoriaMae.get());
		} 
		return new Categoria(nome, null);
	}

	public Long getCategoriaMae() {
		return categoriaMae;
	}
}
