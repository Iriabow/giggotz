package giggotz.repository;

import giggotz.domain.Gig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class GigsRepositoryImpl implements GigsRepository{

	Map<String,List<Gig>> GigArtistMap;
	Map<String,List<Gig>> GigCityMap;
	
	
	@Override
	public Collection<Gig> getAll() {
		List<Gig> res=new ArrayList<Gig>();
		for(List<Gig> g : GigArtistMap.values()) {
			res.addAll(g);
		}
		for(List<Gig> g1 : GigCityMap.values()) {
			res.addAll(g1);
		}
		return res;
	}

	@Override
	public Collection<Gig> getGigsCiudad(String ciudad) {
		return GigCityMap.get(ciudad);
	}

	@Override
	public Collection<Gig> getGigsArtista(String artista) {
		return GigArtistMap.get(artista);
	}

	@Override
	public Integer removeGig(String artista, String nombre) {
		
		Integer estado = 0;
		for(Gig g: getAll()) {
			if(g.getArtista().equals(artista) && g.getNombre().equals(nombre)) {
				
				if(GigArtistMap.containsValue(g)) {
					GigArtistMap.remove(g);
				} else if(GigCityMap.containsValue(g)) {
					GigCityMap.remove(g);
				}
				
			}else {
				estado = -1;
			}
		}
		return estado;
	}

}
