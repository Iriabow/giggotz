
import giggotz.server.resource.wikipedia.WikiResource;

public class prueba {

	public static void main(String[] args) {
		
		WikiResource c = new WikiResource();
//		System.out.println(c.getExtract("Iron Maiden")); esta es la prueba normal
//		System.out.println(c.getExtract("Queen")); daba conflicto así que se cambio el split para solucionarlo
		System.out.println(c.getExtract("macaco"));
		
		

	}

}
