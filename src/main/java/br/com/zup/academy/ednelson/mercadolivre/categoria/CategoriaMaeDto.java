package br.com.zup.academy.ednelson.mercadolivre.categoria;

public class CategoriaMaeDto {

	private Long id;
	private String nome;

	public CategoriaMaeDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
}
