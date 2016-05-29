package giggotz.domain;

import javax.persistence.Id;

public class Album {
	@Id
	private String artista;
	private String nombre;

	public Album() {
	}
	
	public String getArtista() {
		return artista;
	}
	
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
