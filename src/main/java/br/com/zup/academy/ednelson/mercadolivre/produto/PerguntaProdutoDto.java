package br.com.zup.academy.ednelson.mercadolivre.produto;

import java.time.format.DateTimeFormatter;

import br.com.zup.academy.ednelson.mercadolivre.usuario.UsuarioDto;

public class PerguntaProdutoDto {

	private Long id;
	private String titulo;
	private String descricao;
	private String instanteDaPergunta;
	private UsuarioDto usuario;
	private ProdutoDto produto;
	
	public PerguntaProdutoDto(PerguntaProduto pergunta) {
		this.id = pergunta.getId();
		this.titulo = pergunta.getTitulo();
		this.descricao = pergunta.getDescricao();
		this.instanteDaPergunta = pergunta.getInstanteDoCadastro()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		this.usuario = new UsuarioDto(pergunta.getUsuario());
		this.produto = new ProdutoDto(pergunta.getProduto());
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getInstanteDaPergunta() {
		return instanteDaPergunta;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public ProdutoDto getProduto() {
		return produto;
	}
	
}
