package spotifytest;

import java.util.List;

import giggotz.shared.spotify.ImagenSpotify;
import giggotz.shared.spotify.Item;
import giggotz.shared.spotify.SpotifyAlbums;

import org.restlet.resource.ClientResource;

public class SpotifyTest {

	public static void main(String[] args) {
		imageTest("macaco");
	}

	static void imageTest(String artista) {
		System.out.println("LOS LINKS DE LSO ALBUNES DE MACACO SON:");

		for (Item i : getSpotifyTracks(artista).getAlbums().getItems()) {
			// iteraItems(i);
			cogeTercerAlbum(i);
		}

	}

	private static void iteraItems(Item i) {
		for (ImagenSpotify a : i.getImages()) {
			System.out
					.println("Las imagenes del disco de macaco" + i.getName());
			System.out.println(a.getUrl());
		}

	}

	private static void cogeTercerAlbum(Item i) {
		List<ImagenSpotify> images = i.getImages();
		String url = images.get(2).getUrl();
		System.out.println(url);

	}

	public static SpotifyAlbums getSpotifyTracks(String artist) {
		ClientResource cr = new ClientResource(
				"https://api.spotify.com/v1/search?q=" + artist + "&type=album");

		SpotifyAlbums track = cr.get(SpotifyAlbums.class);

		return track;
	}

}
