package br.com.zup.academy.ednelson.mercadolivre.usuario;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private LocalDateTime instanteDoCadastro = LocalDateTime.now();
	
	public Usuario(String login, String senhaLimpa) {
		
		byte[] digest;
		
		try {
			digest = MessageDigest.getInstance("sha-256").digest(senhaLimpa.getBytes());
			this.login = login;
			this.senha = Base64.encodeBase64String(digest);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}

	@Deprecated
	public Usuario() {
		
	}
	
}
