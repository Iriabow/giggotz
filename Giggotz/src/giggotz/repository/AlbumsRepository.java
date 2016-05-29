package giggotz.repository;

import giggotz.domain.Album;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumsRepository {

	Map<String, Album> albumsMap;
	
	public AlbumsRepository() {
		albumsMap=new HashMap<String, Album>();
	}
	
	public Collection<Album> getAll() {
		return albumsMap.values();
	}

	
	public Album getAlbum(String artista) {
		return albumsMap.get(artista);
	}


	public void putAlbums(String artist, Album a) {
		albumsMap.put(artist,a);
		
	}

}
