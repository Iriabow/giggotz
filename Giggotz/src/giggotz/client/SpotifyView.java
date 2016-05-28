package giggotz.client;

import giggotz.client.rpc.spotify.SpotifyAsync;
import giggotz.shared.spotify.Item;
import giggotz.shared.spotify.SpotifyAlbums;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SpotifyView extends Composite {

	// final Button buscar = new Button("buscar");
	// final TextBox caja = new TextBox();
	HorizontalPanel mainPanel = new HorizontalPanel();
	// final Label statusLabel = new Label();

	final SpotifyAsync Spotify = GWT
			.create(giggotz.client.rpc.spotify.Spotify.class);

	// public void onModuleLoad()

	public SpotifyView(Map<String, Object> params) {

		initWidget(mainPanel);
		// caja.setText("Artista");

		// mainPanel.add(caja);
		// mainPanel.add(buscar);
		// mainPanel.add(statusLabel);

		// RootPanel.get("form").add(mainPanel);
		final String artista = params.get("artista").toString();
		// buscar.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// statusLabel.setText("buscando...");
		//
		// final String artista = caja.getText();
		//
		// RootPanel.get("spotify").clear();

		Spotify.getSpotifyTracks(artista, new AsyncCallback<SpotifyAlbums>() {

			@Override
			public void onSuccess(SpotifyAlbums result) {

				showAlbums(artista, result);
				// statusLabel.setText("");
			}

			@Override
			public void onFailure(Throwable caught) {
				mainPanel.add(new Label("Error en el método GetSpotifyTracks()"
						+ caught.getMessage()));

			}
		});
	}

	// });

	// }

	private void showAlbums(String artista, SpotifyAlbums result) {
		//
		// String output = "<fieldset>";
		//
		// output += "<legend> Albums de " + artista
		// + " ¡Clica en uno para ir a su pagina de spotify! </legend>";

		VerticalPanel mainArtists = new VerticalPanel();
		Label label = new Label(
				"¡Clica en los albumnes para ir a su página de Spotify!");
		mainArtists.add(label);
		if (result != null) {

			for (Item i : result.getAlbums().getItems()) {
				final Item item = i;
				Label artistLabel = new Label(i.getName());
				artistLabel.sinkEvents(Event.ONCLICK);
				artistLabel.addHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						Window.open(
								"https://open.spotify.com/album/"
										+ item.getSplitUri(), "_blank", "");
					}

				}, ClickEvent.getType());
				mainArtists.add(artistLabel);
				mainPanel.add(mainArtists);
				// output += getRefPrueba(i);
			}
		} else {

			mainArtists.add(new Label(
					"No se han conseguido albumnes del artista."));
		}

		// output += "<span> No results </span>";

		// output += "</fieldset>";
		// HTML albums = new HTML(output);

		// mainPanel.add(albums);
	}

	// private String getRef(Item album) {
	// return "<span><a href=" + album.getExternalUrls().getSpotify() + "'>"
	// + album.getName() + "</a></span><br>";
	// }

	private String getRefPrueba(Item i) {
		return "<span><a href= 'https://open.spotify.com/album/"
				+ i.getSplitUri() + "' target='_blank'>" + i.getName()
				+ "</a></span><br>";
	}

	// private String getSpotify(ExternalUrls spotify) {
	// return spotify.getSpotify();
	// }
}
