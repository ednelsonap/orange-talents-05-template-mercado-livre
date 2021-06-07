package br.com.zup.academy.ednelson.mercadolivre.produto;

import org.springframework.stereotype.Component;

@Component
public class EnviadorDeEmailFake {

	public void enviar(Email email) {
		System.out.println("");
		System.out.println("Email enviado com sucesso!");
		System.out.println(email.toString());
		System.out.println("");
	}

}
