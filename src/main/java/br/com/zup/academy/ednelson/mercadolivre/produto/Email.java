package br.com.zup.academy.ednelson.mercadolivre.produto;

public class Email {

	private String sender;
	private String recipient;
	private String subject;
	private String body;
	
	public Email(String sender, String recipient, String subject, String body) {
		this.sender = sender;
		this.recipient = recipient;
		this.subject = subject;
		this.body = body;
	}

	@Override
	public String toString() {
		return "Email [sender=" + sender + ", recipient=" + recipient + ", subject=" + subject + ", body=" + body + "]";
	}
	
}
