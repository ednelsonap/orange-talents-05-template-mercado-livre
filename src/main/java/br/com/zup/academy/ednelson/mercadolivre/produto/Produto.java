package br.com.zup.academy.ednelson.mercadolivre.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zup.academy.ednelson.mercadolivre.categoria.Categoria;
import br.com.zup.academy.ednelson.mercadolivre.usuario.Usuario;

@Entity
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotNull
	private BigDecimal preco;
	@NotNull
	@Positive
	private Long quantidadeDisponivel;
	@NotBlank
	@Column(length = 1000)
	private String descricao;
	@NotNull
	@ManyToOne
	private Categoria categoria; 
	@NotNull
	@ManyToOne
	private Usuario usuarioQueCadastrou;
	@OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
	private Set<CaracteristicaProduto> caracteristicas = new HashSet<>();
	private LocalDateTime instanteDoCadastro = LocalDateTime.now();
	@OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
	private Set<FotoProduto> fotosDoProduto = new HashSet<>();
	
	@Deprecated
	public Produto() {
		
	}
	
	public Produto(@NotBlank String nome, @NotNull BigDecimal preco, @NotNull @Positive Long quantidadeDisponivel,
			@NotBlank String descricao, @NotNull Categoria categoria, @NotNull Usuario usuarioQueCadastrou,
			@Size(min = 3) Collection<NovaCaracteristicaRequest> caracteristicas) {
		this.nome = nome;
		this.preco = preco;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.descricao = descricao;
		this.categoria = categoria;
		this.usuarioQueCadastrou = usuarioQueCadastrou;
		this.caracteristicas.addAll(caracteristicas
				.stream().map(caracteristica -> caracteristica.toModel(this))
				.collect(Collectors.toSet()));
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

	public Categoria getCategoria() {
		return categoria;
	}

	public Usuario getUsuarioQueCadastrou() {
		return usuarioQueCadastrou;
	}
	
	public LocalDateTime getInstanteDoCadastro() {
		return instanteDoCadastro;
	}
	
	public Set<CaracteristicaProduto> getCaracteristicas() {
		return caracteristicas;
	}

	public void setFotosDoProduto(Set<FotoProduto> fotosDoProduto) {
		this.fotosDoProduto = fotosDoProduto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public void associaImagens(Set<String> links) {
		Set<FotoProduto> fotos = links.stream().map(link -> new FotoProduto(this, link))
			.collect(Collectors.toSet());
		
		this.fotosDoProduto.addAll(fotos);
	}

}
