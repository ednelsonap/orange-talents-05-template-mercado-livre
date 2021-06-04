package br.com.zup.academy.ednelson.mercadolivre.infra;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class GerenciadorDeArquivos {

	public Set<String> envia(List<MultipartFile> fotos) {
		
		return fotos.stream()
				.map(foto -> "http://bucket.io/"+ foto.getOriginalFilename())
				.collect(Collectors.toSet());
	}

}
