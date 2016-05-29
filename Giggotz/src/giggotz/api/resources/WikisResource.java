package giggotz.api.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;

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
	@Produces("application/json")
	public Response addArticle(@Context UriInfo uriInfo,Article a){
		if(a.getArtista() == null || "".equals(a.getArtista())){
			throw new BadRequestException("The name of the playlist must not be null");
		}
		repository.put(a);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(a.getArtista());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(a);			
		return resp.build();
	}
	
}
