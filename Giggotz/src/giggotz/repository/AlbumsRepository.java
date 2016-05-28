package giggotz.repository;

import giggotz.domain.Album;

import java.util.Collection;

public interface AlbumsRepository {

	public Collection<Album> getAll();
	public Album getAlbum(String artista);
	
}
