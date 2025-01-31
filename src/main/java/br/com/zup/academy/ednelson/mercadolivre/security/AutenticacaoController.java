package br.com.zup.academy.ednelson.mercadolivre.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private GerenciadorDeToken geradorDeToken;
	
	@PostMapping
	private ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginRequest request) {
		
		UsernamePasswordAuthenticationToken dadosLogin = request.toModel();
		
		try {
			Authentication authenticate = authenticationManager.authenticate(dadosLogin);
			String token = geradorDeToken.gerar(authenticate);
			
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
}
