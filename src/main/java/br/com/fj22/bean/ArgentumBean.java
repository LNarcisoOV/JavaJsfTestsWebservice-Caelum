package br.com.fj22.bean;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fj22.modelo.Negociacao;
import br.com.fj22.servico.ClienteWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable{
	
	private static final long serialVersionUID = -8012961205285780771L;
	
	private List<Negociacao> negociacoes;
	
	
	public ArgentumBean() throws MalformedURLException{
		ClienteWebService cliente = new ClienteWebService();
		this.negociacoes = cliente.getNegociacoes();
	}

	public List<Negociacao> getNegociacoes(){
		return this.negociacoes;
	}
}
