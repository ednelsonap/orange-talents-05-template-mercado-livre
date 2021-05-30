package br.com.zup.academy.ednelson.mercadolivre.security;

import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginRequest {

	@NotBlank
	private String email;
	@NotBlank
	private String senha;
	
	public LoginRequest(@NotBlank String email, @NotBlank String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}

	public UsernamePasswordAuthenticationToken toModel() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
}
