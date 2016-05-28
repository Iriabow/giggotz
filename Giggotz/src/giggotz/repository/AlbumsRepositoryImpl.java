package giggotz.repository;

import giggotz.domain.Album;

import java.util.Collection;
import java.util.Map;

public class AlbumsRepositoryImpl implements AlbumsRepository{

	Map<String, Album> AlbumsMap;
	
	@Override
	public Collection<Album> getAll() {
		return AlbumsMap.values();
	}

	@Override
	public Album getAlbum(String artista) {
		return AlbumsMap.get(artista);
	}

}
