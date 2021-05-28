package br.com.zup.academy.ednelson.mercadolivre.security;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;



public class SenhaLimpa {

	private String senha;

	public SenhaLimpa(@NotBlank @Min(6) String senha) {
		Assert.hasLength(senha, "senha não pode estar em branco");
		Assert.isTrue(senha.length() >= 6, "senha precisa ter no mínimo 6 caracteres");
		this.senha = senha;
	}
	
	public String hash() {
		return new BCryptPasswordEncoder().encode(senha);
	}
}