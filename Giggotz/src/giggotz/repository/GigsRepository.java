package giggotz.repository;

import giggotz.domain.Gig;

import java.util.Collection;

public interface GigsRepository {

	public Collection<Gig> getAll();
	public Collection<Gig> getGigsCiudad(String ciudad);
	public Collection<Gig> getGigsArtista(String artista);
	public Integer removeGig(String artista, String nombre);
	
}
