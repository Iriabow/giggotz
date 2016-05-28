package giggotz.api.resources;

import giggotz.domain.Album;
import giggotz.repository.AlbumsRepository;
import giggotz.repository.AlbumsRepositoryImpl;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.spi.NotFoundException;



@Path("/artistAlbums")
public class AlbumsResource {

	private static AlbumsResource _instance = null;
	AlbumsRepository repository;
	
	private AlbumsResource() {
		repository = new AlbumsRepositoryImpl();
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
		a.setArtista("a");
		a.setNombre("b");
		Album b = new Album();
		b.setArtista("c");
		b.setNombre("d");
		Album c = new Album();
		c.setArtista("e");
		c.setNombre("f");
	}
	
	@GET
	@Produces("aplication/json")
	public Collection<Album> getAll() {
		return repository.getAll();
	}
	
	@GET
	@Path("/{artistName}")
	@Produces("aplication/json")
	public Album getAlbum(@PathParam ("artistName") String artista) {
		Album alb = repository.getAlbum(artista);
		
		if(alb == null) {
			throw new NotFoundException("El álbum "+ alb +" no ha sido encontrado");	
		}
		return alb;
	}
	
}
