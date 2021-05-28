package br.com.zup.academy.ednelson.mercadolivre.usuario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	private void cadastrar(@RequestBody @Valid NovoUsuarioRequest request) {
		
		Usuario usuario = request.toModel();
		usuarioRepository.save(usuario);

	}
}
