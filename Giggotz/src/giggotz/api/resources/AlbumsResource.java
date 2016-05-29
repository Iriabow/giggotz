package giggotz.api.resources;

import giggotz.domain.Album;
import giggotz.repository.AlbumsRepository;
import giggotz.repository.AlbumsRepository;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.spi.NotFoundException;



@Path("/albums")
public class AlbumsResource {

	private static AlbumsResource _instance = null;
	AlbumsRepository repository;
	
	private AlbumsResource() {
		repository = new AlbumsRepository();
		initialize();
	}
	
	public static AlbumsResource getInstance() {
		if(_instance==null)
			_instance=new AlbumsResource();
	return _instance;
	}
	
	private void initialize() {
		//TODO Aquí van los datos del repositorio, hay que rellenarlo
		Album a = new Album();
		a.setArtista("Godofredo");
		a.setNombre("Friendo Huevos Fritos");
		Album b = new Album();
		b.setArtista("Godofredo II");
		b.setNombre("Seguimos con los Huevos");
		Album c = new Album();
		c.setArtista("Guanmanch");
		c.setNombre("Por un Mundo más Percutido");
		repository.putAlbums(a.getArtista(), a);
		repository.putAlbums(b.getArtista(), b);
		repository.putAlbums(c.getArtista(), c);
	}
	
	@GET
	@Produces("application/json")
	public Collection<Album> getAll() {
		return repository.getAll();
	}
	
	@GET
	@Path("/{artistName}")
	@Produces("application/json")
	public Album getAlbum(@PathParam ("artistName") String artista) {
		Album alb = repository.getAlbum(artista);
		
		if(alb == null) {
			throw new NotFoundException("404 El álbum del artista"+artista+",no ha sido encontrado");	
		}
		return alb;
	}
	
}
