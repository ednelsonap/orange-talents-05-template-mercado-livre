package br.com.zup.academy.ednelson.mercadolivre.produto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import br.com.zup.academy.ednelson.mercadolivre.categoria.CategoriaDto;
import br.com.zup.academy.ednelson.mercadolivre.usuario.UsuarioDto;

public class ProdutoDto {

	private Long id;
	private String nome;
	private BigDecimal preco;
	private Long quantidadeDisponivel;
	private String descricao;
	private CategoriaDto categoria;
	private UsuarioDto dono;
	private Set<CaracteristicaProdutoDto> caracteristicas;
	private String instanteDoCadastro;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.quantidadeDisponivel = produto.getQuantidadeDisponivel();
		this.descricao = produto.getDescricao();
		this.categoria = new CategoriaDto(produto.getCategoria());
		this.dono = new UsuarioDto(produto.getDono());
		this.caracteristicas = CaracteristicaProdutoDto.converter(produto.getCaracteristicas());
		this.instanteDoCadastro = produto.getInstanteDoCadastro()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Long getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public String getDescricao() {
		return descricao;
	}

	public CategoriaDto getCategoria() {
		return categoria;
	}

	public UsuarioDto getDono() {
		return dono;
	}
	
	public String getInstanteDoCadastro() {
		return instanteDoCadastro;
	}

	public Set<CaracteristicaProdutoDto> getCaracteristicas() {
		return caracteristicas;
	}
}
