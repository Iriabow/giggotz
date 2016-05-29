package giggotz.api.resources;

import giggotz.domain.Gig;
import giggotz.repository.GigsRepository;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.spi.NotFoundException;

@Path("/gigs")
public class GigsResource {
	
	private static GigsResource _instance = null;
	GigsRepository repository;
	
	private GigsResource() {
		repository = new GigsRepository();
		initialize();
	}

	public static GigsResource getInstance() {
		if(_instance == null) {
			_instance = new GigsResource();
		}
		
		return _instance;
	}
	
	private void initialize() {
		Gig a = new Gig();
		a.setArtista("aArtista");
		a.setCiudad("aCiudad");
		a.setNombre("aNombre");
		a.setPrecio(1.0);
		Gig b = new Gig();
		b.setArtista("bArtista");
		b.setCiudad("bCiudad");
		b.setNombre("bNombre");
		b.setPrecio(1.0);
		Gig c = new Gig();
		c.setArtista("cArtista");
		c.setCiudad("cCiudad");
		c.setNombre("cNombre");
		c.setPrecio(1.0);
		Gig d = new Gig();
		d.setArtista("dArtista");
		d.setCiudad("dCiudad");
		d.setNombre("dNombre");
		d.setPrecio(1.0);
		
		repository.putGig(a);
		repository.putGig(b);
		repository.putGig(c);
		repository.putGig(d);
	}
	
	@GET
	@Produces("application/json") 
	public Collection<Gig> getAll() {
		return repository.getAll();
	}
	
	@GET
	@Path("/city/{cityName}")
	@Produces("application/json")
	public Collection<Gig> getCiudad(@PathParam("cityName") String ciudad){
		Collection<Gig> list = new ArrayList<Gig>();
		list = repository.getGigsCiudad(ciudad);
			
			if (list == null) {
				throw new NotFoundException("Los conciertos de la ciudad "+ciudad+" no han sido encontrados.");			
			}
		return list;
	}
	
	@GET
	@Path("/artist/{artistName}")
	@Produces("application/json")
	public Collection<Gig> getArtist(@PathParam("artistName") String artista){
		Collection<Gig> list = new ArrayList<Gig>();
		list = repository.getGigsArtista(artista);
			
			if (list == null) {
				throw new NotFoundException("Los conciertos del artista "+artista+" no han sido encontrados.");			
			}	
		return list;
	}
	
	@DELETE
	@Path("/delete/{gigName}")
	public void borraConcierto(@PathParam("gigName") String name) {
		Integer estado = repository.removeGig(name);
		if(estado == -1) {
			throw new NotFoundException("El concierto "+name+" no ha sido encontrado.");
		}		
	}
	
}
