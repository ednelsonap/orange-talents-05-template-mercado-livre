package br.com.zup.academy.ednelson.mercadolivre.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import br.com.zup.academy.ednelson.mercadolivre.validation.ExistsId;
import br.com.zup.academy.ednelson.mercadolivre.validation.UniqueValue;

public class NovaCategoriaRequest {

	@NotBlank
	@UniqueValue(atributo = "nome", entidade = Categoria.class)
	private String nome;
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	@Positive
	private Long idCategoriaMae;
	
	public NovaCategoriaRequest(@NotBlank String nome, @Positive Long idCategoriaMae) {
		this.nome = nome;
		this.idCategoriaMae = idCategoriaMae;
	}

	public Categoria toModel(CategoriaRepository categoriaRepository) {
		Categoria categoria = new Categoria(nome);
		if(idCategoriaMae != null) {
			categoria.setCategoriaMae(categoriaRepository.findById(idCategoriaMae).get());
		} 
		return categoria;
	}
	
}
