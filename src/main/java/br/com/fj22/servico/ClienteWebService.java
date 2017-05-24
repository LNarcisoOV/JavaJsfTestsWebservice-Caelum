package br.com.fj22.servico;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.fj22.modelo.Negociacao;
import br.com.fj22.reader.LeitorXML;

public class ClienteWebService {
	
	private static final String URL_WEBSERVICE = "http://argentumws.caelum.com.br/negociacoes";
	
	public List<Negociacao> getNegociacoes() throws MalformedURLException{
		
		HttpURLConnection connection = null;
		
		try{
			URL url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection) url.openConnection();
			InputStream content = connection.getInputStream();
			return new LeitorXML().carrega(content);
		}catch(IOException e){
			throw new RuntimeException(e);
		}finally{
			connection.disconnect();
		}
		
		
	}
}
