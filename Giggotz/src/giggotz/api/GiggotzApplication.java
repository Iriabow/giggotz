package giggotz.api;

import giggotz.api.resources.AlbumsResource;
import giggotz.api.resources.GigsResource;
import giggotz.api.resources.WikisResource;

import java.util.HashSet;
import java.util.Set;

import com.google.appengine.tools.admin.Application;

public class GiggotzApplication extends Application{
	private Set<Object> singletons= new HashSet<Object>();
	private Set<Class<?>> classes= new HashSet<Class<?>>();
	// Loads all resources that are implemented in the application so that they can be found by RESTEasy.
	public GiggotzApplication() {
	singletons.add(new AlbumsResource());
	singletons.add(new WikisResource());
	singletons.add(new GigsResource());
	}
	public Set<Class<?>> getClasses() {
	return classes;
	}
	public Set<Object> getSingletons() {
	return singletons;
	}
}
