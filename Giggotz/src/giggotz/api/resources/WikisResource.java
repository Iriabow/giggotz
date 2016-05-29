package giggotz.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import giggotz.domain.Album;
import giggotz.domain.Article;
import giggotz.repository.AlbumsRepository;
import giggotz.repository.WikisRepository;

@Path("/wikis")
public class WikisResource {

	private static WikisResource _instance = null;
	WikisRepository repository;
	
	private WikisResource() {
		repository = new WikisRepository();
		initialize();
	}
	
	public static WikisResource getInstance() {
		if(_instance==null)
			_instance=new WikisResource();
	return _instance;
	}
	
	private void initialize() {
		Article a=new Article();
		a.setArtista("Godofredo");
		a.setContenido("Este señor tocaba en la década de 2230 con los Energumenos Astrales.");
		Article b=new Article();
		b.setArtista("Godofredo II");
		b.setContenido("Hijo de Godofredo, desde muy pequeño estubo en el mundo de la música");
		Article c=new Article();
		c.setArtista("Guan Manch");
		c.setContenido("Es conocido por ser el mejor percusionista del mundo");
		repository.put(a);
		repository.put(b);
		repository.put(c);
		
		
	}
	
	@POST
	@Consumes("application/json")
	public Article addPlaylist( Article article) {
		repository.put(article);
		
		return article;
	}
	@GET
	@Produces("application/json")
	public Collection<Article> getAll() {
		return repository.getAll();
	}
	
	@GET
	@Path("/{artistName}")
	@Produces("application/json")
	public Article getArticulo(@PathParam ("artistName") String artista) {
		Article articulo = repository.getArticle(artista);
		
		if(articulo == null) {
			throw new NotFoundException("404 El articulo "+artista+",no ha sido encontrado");	
		}
		return articulo;
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateAplication(Article article) {
	
		if (repository.getArticle(article.getArtista())==null) {
			throw new NotFoundException("The article was not found");			
		}
		
		
		
		repository.put(article);
		
		return Response.noContent().build();
	}
	
	
}
