package br.com.zup.academy.ednelson.mercadolivre.produto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class NovasFotosRequest {

	@Size(min = 1)
	@NotNull
	private List<MultipartFile> fotos = new ArrayList<MultipartFile>();

	public void setFotos(List<MultipartFile> fotos) {
		this.fotos = fotos;
	}

	public List<MultipartFile> getFotos() {
		return fotos;
	}
}
