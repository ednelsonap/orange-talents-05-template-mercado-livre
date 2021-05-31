package br.com.zup.academy.ednelson.mercadolivre.usuario;

public class UsuarioDto {
	
	private Long id;
	private String email;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getUsername();
	}

	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
}
