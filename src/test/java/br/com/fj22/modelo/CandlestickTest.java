package br.com.fj22.modelo;

import java.util.Calendar;

import org.junit.Test;

import junit.framework.Assert;

public class CandlestickTest {

	@Test
	public void testaSeMinimoEhMaiorQueMaximo(){
		Candlestick candle = new Candlestick(1.0d, 0.0d, 2.0d, 1.0d, 1.0d, Calendar.getInstance());
		Assert.assertEquals(true, candle.minimoMaiorQueMaximo());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarCandlestickComDataNula(){
		new Candlestick(1.0d, 0.0d, 2.0d, 1.0d, 1.0d, null);
	}
}
