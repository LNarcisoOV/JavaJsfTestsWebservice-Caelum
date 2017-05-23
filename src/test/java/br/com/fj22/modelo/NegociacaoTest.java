package br.com.fj22.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import junit.framework.Assert;

public class NegociacaoTest {

	@Test
	public void testaSeDataEhImutavel() {
		Calendar dataTeste = Calendar.getInstance();
		dataTeste.set(Calendar.DAY_OF_MONTH, 15);

		Negociacao negociacao = new Negociacao(0d, 0, dataTeste);

		negociacao.getData().set(1, Calendar.DAY_OF_MONTH);

		Assert.assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(22.0d, 0, null);
	}

	@Test
	public void mesmoMilissegundoEDoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}

	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
		// usando GregorianCalendar(ano, mes, dia, hora, minuto)
		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void comDiasIguaisEMesesDiferentes() {
		// usando GregorianCalendar(ano, mes, dia, hora, minuto)
		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 9, 20, 15, 30);
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertFalse(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void comDiasEMesesIguaisEAnosDiferentes() {
		// usando GregorianCalendar(ano, mes, dia, hora, minuto)
		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2012, 10, 20, 15, 30);
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertFalse(negociacao.isMesmoDia(tarde));
	}
}
