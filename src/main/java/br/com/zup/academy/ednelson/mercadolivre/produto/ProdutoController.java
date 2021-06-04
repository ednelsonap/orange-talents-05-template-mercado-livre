package br.com.zup.academy.ednelson.mercadolivre.produto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.ednelson.mercadolivre.categoria.Categoria;
import br.com.zup.academy.ednelson.mercadolivre.categoria.CategoriaRepository;
import br.com.zup.academy.ednelson.mercadolivre.security.GerenciadorDeToken;
import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;
import br.com.zup.academy.ednelson.mercadolivre.usuario.UsuarioRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private GerenciadorDeToken geradorDeToken;

	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new ProibeCaracteristicaComNomeIgualValidator());
	}

	@PostMapping("/novo")
	private ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid NovoProdutoRequest request,
			HttpServletRequest req) {

		Categoria categoria = categoriaRepository.findById(request.getIdCategoria()).get();

		String token = req.getHeader("Authorization");

		Long idUsuario = geradorDeToken.getIdUsuario(token.substring(7, token.length()));
		Usuario usuario = usuarioRepository.findById(idUsuario).get();

		Produto produto = request.toModel(categoria, usuario);
		produtoRepository.save(produto);

		return ResponseEntity.ok(new ProdutoDto(produto));

	}

}
