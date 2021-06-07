package br.com.zup.academy.ednelson.mercadolivre.produto;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.ednelson.mercadolivre.infra.GerenciadorDeArquivos;
import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;

@RestController
@RequestMapping
public class CadastrarFotosController {

	@Autowired
	private GerenciadorDeArquivos gerenciadorDeArquivos;
	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping("/produto/{id}/fotos")
	private ResponseEntity<Set<String>> upload(
			@PathVariable("id") Long idProduto,
			@Valid NovasFotosRequest request, 
			@AuthenticationPrincipal Usuario usuario) {

		Optional<Produto> possivelProduto = produtoRepository.findById(idProduto);
		
		if(possivelProduto.isPresent() && usuario.getId() == possivelProduto.get().getDono().getId()) {
			Set<String> links = gerenciadorDeArquivos.envia(request.getFotos());
			Produto produto = possivelProduto.get();
			produto.associaImagens(links);
			produtoRepository.save(produto);
			
			return ResponseEntity.ok(links);
		}
		
		return ResponseEntity.badRequest().build();
		
	}
}
