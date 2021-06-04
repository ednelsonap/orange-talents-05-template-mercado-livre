package br.com.zup.academy.ednelson.mercadolivre.produto;

import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.ednelson.mercadolivre.infra.GerenciadorDeArquivos;
import br.com.zup.academy.ednelson.mercadolivre.security.GerenciadorDeToken;

@RestController
@RequestMapping("/produto")
public class CadastrarFotosController {

	@Autowired
	private GerenciadorDeArquivos gerenciadorDeArquivos;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private GerenciadorDeToken geradorDeToken;

	@PostMapping("/{id}/fotos")
	private ResponseEntity<Set<String>> upload(
			@PathVariable("id") Long idProduto,
			@Valid NovasFotosRequest request, HttpServletRequest req) {

		String token = req.getHeader("Authorization");
		Long idUsuario = geradorDeToken.getIdUsuario(token.substring(7, token.length()));
		Optional<Produto> possivelProduto = produtoRepository.findById(idProduto);
		
		if(possivelProduto.isPresent() && idUsuario == possivelProduto.get().getUsuarioQueCadastrou().getId()) {
			Set<String> links = gerenciadorDeArquivos.envia(request.getFotos());
			Produto produto = possivelProduto.get();
			produto.associaImagens(links);
			produtoRepository.save(produto);
			
			return ResponseEntity.ok(links);
		}
		
		return ResponseEntity.badRequest().build();
		
	}
}
