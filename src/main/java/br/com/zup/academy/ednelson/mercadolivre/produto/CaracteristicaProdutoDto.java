package br.com.zup.academy.ednelson.mercadolivre.produto;

import java.util.HashSet;
import java.util.Set;

public class CaracteristicaProdutoDto {

	private Long id;
	private String nome;
	private String descricao;
	
	public CaracteristicaProdutoDto(CaracteristicaProduto caracteristicaProduto) {
		this.id = caracteristicaProduto.getId();
		this.nome = caracteristicaProduto.getNome();
		this.descricao = caracteristicaProduto.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Set<CaracteristicaProdutoDto> converter(Set<CaracteristicaProduto> caracteristicas) {
		Set<CaracteristicaProdutoDto> caracteristicasDto = new HashSet<>();
		for (CaracteristicaProduto caracteristicaProduto : caracteristicas) {
			CaracteristicaProdutoDto caracteristicaProdutoDto = new CaracteristicaProdutoDto(caracteristicaProduto);
			caracteristicasDto.add(caracteristicaProdutoDto);
		}
		return caracteristicasDto;
	}
}
