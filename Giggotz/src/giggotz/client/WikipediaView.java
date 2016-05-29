package giggotz.client;

import giggotz.client.rpc.wikipedia.WikipediaService;
import giggotz.client.rpc.wikipedia.WikipediaServiceAsync;

import java.util.Map;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;


public class WikipediaView extends Composite {

	private final WikipediaServiceAsync extracto = GWT
			.create(WikipediaService.class);
	private final HorizontalPanel main = new HorizontalPanel();

	public WikipediaView(Map<String, Object> params) {

		initWidget(main);

		//final Button buscar = new Button("Buscar"); //boton que busca informaci�n por artista
		final String artista = params.get("artista").toString(); 
		final Label texto = new Label();
		final Label error = new Label();
		
		//main.add(buscar);

		//buscar.addClickHandler(new ClickHandler() {
			//public void onClick(ClickEvent event) {

				extracto.getExtract(artista,
						new AsyncCallback<String>() {

							public void onSuccess(String result) {
//								texto.setValue(result);
								texto.setText(result);
								main.add(texto);
							}

							public void onFailure(Throwable caught) {
								System.out.println(artista);
								error.setText("Artista no encontrado.");
								main.add(error);
							}

						});
			}
		//});
	}
//}
