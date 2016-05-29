package giggotz.domain;

import javax.persistence.Id;

public class Article {
	@Id
	private String artista;
	private String contenido;
	
	public Article(String artista,String contenido) {
		this.artista=artista;
		this.contenido=contenido;
	}
	public Article(){
		
	}
	
	public String getArtista() {
		return artista;
	}
	
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
}
