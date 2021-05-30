package br.com.zup.academy.ednelson.mercadolivre.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import br.com.zup.academy.ednelson.mercadolivre.security.SenhaLimpa;
import br.com.zup.academy.ednelson.mercadolivre.validation.UniqueValue;

public class NovoUsuarioRequest {

	@NotBlank
	@Email
	@UniqueValue(atributo = "email", entidade = Usuario.class)
	private String email;
	@NotBlank
	@Min(6)
	private String senha;
	
	public NovoUsuarioRequest(@NotBlank @Email String email, @NotBlank @Min(6) String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Usuario toModel() {
		return new Usuario(email, new SenhaLimpa(senha));
	}
	
}
