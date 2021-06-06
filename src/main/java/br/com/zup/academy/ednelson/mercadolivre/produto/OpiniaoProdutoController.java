package br.com.zup.academy.ednelson.mercadolivre.produto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;

@RestController
@RequestMapping("/produto")
public class OpiniaoProdutoController {
	
	@Autowired
	private EntityManager manager;

	@PostMapping("/{id}/opiniao")
	@Transactional
	public ResponseEntity<OpiniaoProdutoDto> cadastrar(@PathVariable("id") Long idProduto,
			@AuthenticationPrincipal Usuario usuario,
			@RequestBody @Valid NovaOpiniaoRequest request) {
		
		Produto produto = manager.find(Produto.class, idProduto);
		
		if(produto == null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "o produto não existe");
		}
		
		OpiniaoProduto opiniaoProduto = request.toModel(usuario, produto);
		manager.persist(opiniaoProduto);
		
		return ResponseEntity.ok(new OpiniaoProdutoDto(opiniaoProduto));
	}
}
