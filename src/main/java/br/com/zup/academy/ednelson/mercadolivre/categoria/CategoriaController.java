package br.com.zup.academy.ednelson.mercadolivre.categoria;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	private ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid NovaCategoriaRequest request) {
		Optional<Categoria> categoriaMae = null;
		Categoria categoria;

		if (request.getCategoriaMae() != null) {
			categoriaMae = categoriaRepository.findById(request.getCategoriaMae());
			categoria = request.toModel(categoriaMae);
		}

		categoria = request.toModel(categoriaMae);
		categoriaRepository.save(categoria);
		
		return ResponseEntity.ok(new CategoriaDto(categoria));
	}
}
