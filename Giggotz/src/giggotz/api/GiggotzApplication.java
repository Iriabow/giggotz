package giggotz.api;

import giggotz.api.resources.AlbumsResource;
import giggotz.api.resources.GigsResource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class GiggotzApplication extends Application{
	private Set<Object> singletons= new HashSet<Object>();
	private Set<Class<?>> classes= new HashSet<Class<?>>();
	// Loads all resources that are implemented in the application so that they can be found by RESTEasy.
	public GiggotzApplication() {
	singletons.add(AlbumsResource.getInstance());
	singletons.add(WikisResource.getInstance());
	singletons.add(GigsResource.getInstance());
	}
	public Set<Class<?>> getClasses() {
	return classes;
	}
	public Set<Object> getSingletons() {
	return singletons;
	}
}
