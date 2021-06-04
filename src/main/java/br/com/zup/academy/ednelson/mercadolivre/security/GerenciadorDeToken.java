package br.com.zup.academy.ednelson.mercadolivre.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class GerenciadorDeToken {

	@Value("${mercadolivre.jwt.expiration}")
	private String expiration;
	
	@Value("${mercadolivre.jwt.secret}")
	private String secret;
	
	public String gerar(Authentication authenticate) {
		Usuario autenticado = (Usuario) authenticate.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API do Mercado Livre")
				.setSubject(autenticado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();				
	}
	
	public boolean isValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
}
