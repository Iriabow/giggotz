package giggotz.domain;

public class Gig {

	private String artista;
	private String nombre;
	private String ciudad; 
	private Double precio;
	
	public Gig(String artista, String nombre, String ciudad) {
		this.artista = artista;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}
	
	public String getArtista() {
		return artista;
	}
	
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
