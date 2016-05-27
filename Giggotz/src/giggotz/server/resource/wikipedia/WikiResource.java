package giggotz.server.resource.wikipedia;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class WikiResource {

	private String uri = "https://es.wikipedia.org/w/api.php?action=query&prop=extracts&exintro&explaintext&titles=";
	private String uri1 = "https://es.wikipedia.org/w/api.php?action=query&prop=links&titles=";

	public String getExtract(String artist) {

		ClientResource cr = null;
		ClientResource crIntermedia = null;
		
		String all = null;
		
		String[] referencias = null;
		String[] limpieza = null;
		String[] limpieza1 = null;
		String[] llavesIzq = null;
		String[] llavesIzq1 = null;
		String[] llavesIzq2 = null;
		
		String temp = null;
		String temp1 = null;
		
		String res = null;
		// Integer partes = null;

		try {

			cr = new ClientResource(uri + artist + "&format=json");
			all = cr.get(String.class);
//			System.out.println("Imprimiendo cr para ver que contiene \n" + all);
			if (all.contains("puede referirse a")) {
				crIntermedia = new ClientResource(uri1 + artist + "&format=json");
				all = crIntermedia.get(String.class);
//				System.out.println("Sacamos las diferentes referencias \n" + all);
				referencias = all.split("title");
				// partes = llavesIzq.length;
				// System.out.println("Comprobamos que el split ha funcionado " + referencias[0]);
				// System.out.println("Comprobamos que las particiones se hacen correctamente " + partes);

				for (String a : referencias) {

					if (a.contains("banda") || a.contains("artista")
							|| a.contains("musica")) {
						limpieza = a.split(":");
						all = limpieza[1];
						//System.out.println("Comprobando que la primera limpieza va bien \n" + all);
						limpieza1 = all.split("}");
						temp = limpieza1[0];
						String title = temp.substring(1, temp.length()-1);
						//así quitamos los / (%22)
//						System.out.println("Comprobamos que los / han desaparecido " + title);
						
						cr = new ClientResource(uri + title + "&format=json");
						all = cr.get(String.class);
						System.out.println(all);
					} else {
						System.out.println("Artista no encontrado, intente especificar.");
					}
					// System.out.println(a);
				}

				// System.out.println(partes);

			} else {
			}
				llavesIzq = all.split("extract");
				temp = llavesIzq[1];
//				temp.replaceAll(":", "");
//				temp.substring(5, temp.length());
				//probamos otro modo porque corta el texto así
				llavesIzq1 = temp.split(":");
				temp1 = llavesIzq1[1];
				llavesIzq2 = temp1.split("}");
				res = llavesIzq2[0];
				// TODO QUITAR LOS RETORNOS DE CARRO
				//TIENES QUE HACERLO CON UN IF POR SI ACASO NO VAYA A SER QUE ROMPAS EL CODIGO
			
		} catch (ResourceException re) {
			System.err.println("Error intentando obtener la clase principal: "
					+ cr.getResponse().getStatus());
		}

		return res;
	}
}
