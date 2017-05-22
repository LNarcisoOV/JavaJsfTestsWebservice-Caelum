package br.com.fj22.modelo;

import java.util.Calendar;

import org.junit.Test;

import junit.framework.Assert;

public class NegociacaoTest {

	@Test 
	public void testaSeDataEhImutavel(){
		Calendar dataTeste = Calendar.getInstance();
		dataTeste.set(Calendar.DAY_OF_MONTH, 15);
		
		Negociacao negociacao = new Negociacao(0d, 0, dataTeste);
		
		negociacao.getData().set(1, Calendar.DAY_OF_MONTH);
		
		Assert.assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula(){
		new Negociacao(22.0d, 0, null);
	}
}
