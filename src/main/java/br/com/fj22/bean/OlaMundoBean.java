package br.com.fj22.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {
	private String mensagem = "Quem � voc�?";
	private String nome;

	public String getMensagem() {
		return mensagem;
	}
	
	public void nomeFoiDigitado(){
		System.out.println("\nChamou o bot�o, nome digitado: " + this.nome);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
