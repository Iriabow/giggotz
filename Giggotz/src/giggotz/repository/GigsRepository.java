package giggotz.repository;

import giggotz.domain.Gig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GigsRepository{

	Map<String,List<Gig>> GigArtistMap;
	Map<String,List<Gig>> GigCityMap;
	
	public GigsRepository() {
		GigArtistMap = new HashMap<String,List<Gig>>();
		GigCityMap = new HashMap<String, List<Gig>>();
	}
	
	public Collection<Gig> getAll() {
		List<Gig> res=new ArrayList<Gig>();
		for(List<Gig> g : GigArtistMap.values()) {
			res.addAll(g);
		}
		return res;
	}


	public Collection<Gig> getGigsCiudad(String ciudad) {
		return GigCityMap.get(ciudad);
	}

	public Collection<Gig> getGigsArtista(String artista) {
		return GigArtistMap.get(artista);
	}

	public Integer removeGig(String nombre){
		Integer estado = -1;
				for(List<Gig> l : GigArtistMap.values()) {
					for(Gig g: l) {
						if(g.getNombre().equals(nombre)) {
							l.remove(g);
							estado = 0;
							break;
						}
					}
				}
				
				for(List<Gig> l1 : GigArtistMap.values()) {
					for(Gig g1: l1) {
						if(g1.getNombre().equals(nombre)) {
							l1.remove(g1);
							estado = 0;
							break;
						}
					}
				}
		
		return estado;
	}
	
	public void putGig(Gig g) {
		if(GigArtistMap.containsKey(g.getArtista())) {
			GigArtistMap.get(g.getArtista()).add(g);
		} else {
			List<Gig> conciertos = new ArrayList<Gig>();
			conciertos.add(g);
			GigArtistMap.put(g.getArtista(), conciertos);
		}
		
		if(GigCityMap.containsKey(g.getCiudad())) {
			GigCityMap.get(g.getCiudad()).add(g);
		} else {
			List<Gig> conciertos1 = new ArrayList<Gig>();
			conciertos1.add(g);
			GigCityMap.put(g.getCiudad(), conciertos1);
		}
	}
}
