package br.com.fj22.reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import br.com.fj22.modelo.Negociacao;
import junit.framework.Assert;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
							"<negociacao>" +
							"<preco>43.5</preco>" +
							"<quantidade>1000</quantidade>" +
							"<data>" +
							"<time>1322233344455</time>"+
							"</data>"+
							"</negociacao>" +
							"</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco());
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());
	}
	
	@Test
	public void carregaXmlComDuasNegociacoesEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
							"<negociacao>" +
							"<preco>43.5</preco>" +
							"<quantidade>1000</quantidade>" +
							"<data>" +
							"<time>1322233344455</time>"+
							"</data>"+
							"</negociacao>" +
							"<negociacao>" +
							"<preco>11.1</preco>" +
							"<quantidade>111</quantidade>" +
							"<data>" +
							"<time>1322233344455</time>"+
							"</data>"+
							"</negociacao>" +
							"</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals(2, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco());
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());
		
		Assert.assertEquals(11.1, negociacoes.get(1).getPreco());
		Assert.assertEquals(111, negociacoes.get(1).getQuantidade());
	}
	
	@Test
	public void carregaXmlComZeroNegociacoesEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
							"</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals(0, negociacoes.size());
	}
	
	@Test
	public void carregaXmlComPrecoFaltandoEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
							"<negociacao>" +
							"<quantidade>1000</quantidade>" +
							"<data>" +
							"<time>1322233344455</time>"+
							"</data>"+
							"</negociacao>" +
							"</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(0.0, negociacoes.get(0).getPreco());
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());
	}
	
	@Test
	public void carregaXmlComQuantidadeFaltandoEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
							"<negociacao>" +
							"<preco>43.5</preco>" +
							"<data>" +
							"<time>1322233344455</time>"+
							"</data>"+
							"</negociacao>" +
							"</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco());
		Assert.assertEquals(0, negociacoes.get(0).getQuantidade());
	}
	
}
