package br.com.zup.academy.ednelson.mercadolivre.categoria;

public class CategoriaDto {

	private Long id;
	private String nome;
	private CategoriaMaeDto categoriaMae;
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		if(categoria.getCategoriaMae() != null) {
			this.categoriaMae = new CategoriaMaeDto(categoria.getCategoriaMae());
		}
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public CategoriaMaeDto getCategoriaMae() {
		return categoriaMae;
	}
}
