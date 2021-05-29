package br.com.zup.academy.ednelson.mercadolivre.categoria;

public class CategoriaDto {

	private Long id;
	private String nome;
	private String categoriaMae;
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.categoriaMae = categoria.getCategoriaMae().getNome();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCategoriaMae() {
		return categoriaMae;
	}
}
