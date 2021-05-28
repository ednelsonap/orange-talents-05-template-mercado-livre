package br.com.zup.academy.ednelson.mercadolivre.usuario;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.zup.academy.ednelson.mercadolivre.security.SenhaLimpa;

@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private LocalDateTime instanteDoCadastro;
	
	public Usuario(String login, SenhaLimpa senhaLimpa) {
			this.login = login;
			this.senha = senhaLimpa.hash();
			this.instanteDoCadastro = LocalDateTime.now();
	}

	@Deprecated
	public Usuario() {
		
	}
	
}
