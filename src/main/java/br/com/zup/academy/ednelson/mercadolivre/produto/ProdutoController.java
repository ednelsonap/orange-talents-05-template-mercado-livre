package br.com.zup.academy.ednelson.mercadolivre.produto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.ednelson.mercadolivre.categoria.Categoria;
import br.com.zup.academy.ednelson.mercadolivre.categoria.CategoriaRepository;
import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;

@RestController
@RequestMapping
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new ProibeCaracteristicaComNomeIgualValidator());
	}

	@PostMapping("/produto/novo")
	private ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid NovoProdutoRequest request,
			@AuthenticationPrincipal Usuario usuario) {

		Categoria categoria = categoriaRepository.findById(request.getIdCategoria()).get();

		Produto produto = request.toModel(categoria, usuario);
		produtoRepository.save(produto);

		return ResponseEntity.ok(new ProdutoDto(produto));

	}

}
