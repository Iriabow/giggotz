package giggotz.domain;

public class Album {

	private String artista;
	private String nombre;
	
	public Album(String artista, String nombre) {
		this.artista = artista;
		this.nombre = nombre;
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
