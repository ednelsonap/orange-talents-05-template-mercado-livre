package br.com.zup.academy.ednelson.mercadolivre.produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zup.academy.ednelson.mercadolivre.categoria.Categoria;
import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;
import br.com.zup.academy.ednelson.mercadolivre.validation.ExistsId;

public class NovoProdutoRequest {

	@NotBlank
	private String nome;
	@NotNull
	@DecimalMin(value = "0.01")
	private BigDecimal preco;
	@NotNull
	@Positive
	private Long quantidadeDisponivel;
	@Size(min = 3)
	private List<NovaCaracteristicaRequest> caracteristicas = new ArrayList<>();
	@NotBlank
	@Size(max = 1000)
	private String descricao;
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;
	
	public NovoProdutoRequest(@NotBlank String nome, @NotNull @DecimalMin("0.01") BigDecimal preco,
			@NotNull @Positive Long quantidadeDisponivel, @Size(min = 3) List<NovaCaracteristicaRequest> caracteristicas,
			@NotBlank @Size(max = 1000) String descricao, @NotNull Long idCategoria) {
		this.nome = nome;
		this.preco = preco;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.caracteristicas.addAll(caracteristicas);
		this.descricao = descricao;
		this.idCategoria = idCategoria;
	}
	
	public Produto toModel(Categoria categoria, Usuario usuario) {
		return new Produto(nome, preco, quantidadeDisponivel, descricao, categoria, usuario, caracteristicas);
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public List<NovaCaracteristicaRequest> getCaracteristicas() {
		return caracteristicas;
	}
	
	public Set<String> buscarCaracteristicasIguais() {
		HashSet<String> nomesDasCaracteristicas = new HashSet<>();
		HashSet<String> nomesIguais = new HashSet<>();
		for(NovaCaracteristicaRequest caracteristica : caracteristicas) {
			String nome = caracteristica.getNome();
			if(!nomesDasCaracteristicas.add(nome)) {
				nomesIguais.add(nome);
			}
		}
		return nomesIguais;
	}
}
