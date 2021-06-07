package br.com.zup.academy.ednelson.mercadolivre.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GerenciadorDeEmail {

	@Autowired
	private EnviadorDeEmailFake enviadorDeEmailFake;

	public void enviaEmailNovaPergunta(PerguntaProduto pergunta) {
		
		Email email = new Email(pergunta.getUsuario().getUsername(), 
				pergunta.getProduto().getDono().getUsername(), 
				pergunta.getTitulo(), 
				pergunta.getDescricao());
		
		enviadorDeEmailFake.enviar(email);	
	}

}
