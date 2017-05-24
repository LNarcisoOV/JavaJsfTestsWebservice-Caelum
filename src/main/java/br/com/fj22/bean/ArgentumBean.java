package br.com.fj22.bean;

import java.net.MalformedURLException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fj22.modelo.Negociacao;
import br.com.fj22.servico.ClienteWebService;

@ManagedBean
public class ArgentumBean {
	
	private List<Negociacao> negociacoes;
	
	
	public ArgentumBean() throws MalformedURLException{
		ClienteWebService cliente = new ClienteWebService();
		this.negociacoes = cliente.getNegociacoes();
	}

	public List<Negociacao> getNegociacoes(){
		return this.negociacoes;
	}
}
