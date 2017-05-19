package br.com.fj22.modelo;

import java.util.Calendar;

public class Negociacao {

	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		super();
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @return the data
	 */
	public Calendar getData() {
		return data;
	}

	public double getVolume() {
		return preco * quantidade;
	}

}
