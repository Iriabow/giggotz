package giggotz.server.rpc.wikipedia;

import giggotz.client.rpc.wikipedia.WikipediaService;
import giggotz.server.resource.wikipedia.WikiResource;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class WikipediaServiceImpl extends RemoteServiceServlet implements
		WikipediaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	WikiResource w = new WikiResource();

	@Override
	public String getExtract(String artist) {
		String formateado = replace(w.getExtract(artist));
		return replace(w.getExtract(artist));
	}

	public String replace(String extract) {
		String res = "";
		Character a;
		for (int i = 0; i < extract.length(); i++) {
			a = extract.charAt(i);
			if (a.equals('\\')) {
				if (extract.charAt(i + 1) == 'u'
						&& extract.charAt(i + 2) == '0'
						&& extract.charAt(i + 3) == '0'
						&& extract.charAt(i + 4) == 'e'
						&& extract.charAt(i + 5) == 'd') {
					res += "í";
					i += 5;
				}
				else if (extract.charAt(i + 1) == 'u'
						&& extract.charAt(i + 2) == '0'
						&& extract.charAt(i + 3) == '0'
						&& extract.charAt(i + 4) == 'e'
						&& extract.charAt(i + 5) == '1') {
					res += "á";
					i += 4;
				}
				else if (extract.charAt(i + 1) == 'u'
						&& extract.charAt(i + 2) == '0'
						&& extract.charAt(i + 3) == '0'
						&& extract.charAt(i + 4) == 'f'
						&& extract.charAt(i + 5) == 'a') {
					res += "ú";
					i += 5;
				}
				else if (extract.charAt(i + 1) == 'u'
						&& extract.charAt(i + 2) == '0'
						&& extract.charAt(i + 3) == '0'
						&& extract.charAt(i + 4) == 'f'
						&& extract.charAt(i + 5) == '1') {
					res += "ñ";
					i += 5;
				}
				else if (extract.charAt(i + 1) == 'u'
						&& extract.charAt(i + 2) == '0'
						&& extract.charAt(i + 3) == '0'
						&& extract.charAt(i + 4) == 'e'
						&& extract.charAt(i + 5) == '9') {
					res += "é";
					i += 5;
				}
				else if (extract.charAt(i + 1) == 'u'
						&& extract.charAt(i + 2) == '0'
						&& extract.charAt(i + 3) == '0'
						&& extract.charAt(i + 4) == 'f'
						&& extract.charAt(i + 5) == '3') {
					res += "ó";
					i += 5;
				}
				
				else if (extract.charAt(i + 1) == 'u'
						&& extract.charAt(i + 2) == '0'
						&& extract.charAt(i + 3) == '0'
						&& extract.charAt(i + 4) == 'c'
						&& extract.charAt(i + 5) == '1') {
					res += "á";
					i += 5;
				}
				
				else if (extract.charAt(i + 1) == 'u'
						&& extract.charAt(i + 2) == '0'
						&& extract.charAt(i + 3) == '0'
						&& extract.charAt(i + 4) == 'a'
						&& extract.charAt(i + 5) == 'b') {
					res += "'";
					i += 5;
				}
				
				else if (extract.charAt(i + 1) == 'u'
						&& extract.charAt(i + 2) == '0'
						&& extract.charAt(i + 3) == '0'
						&& extract.charAt(i + 4) == 'b'
						&& extract.charAt(i + 5) == 'b') {
					res += "'";
					i += 5;
				}
				
				else if (extract.charAt(i + 1) == 'n') {
					res += " ";
					i += 1;
				}
			} else {
				res += a;
			}
		}
		System.out.println(res);

		return res;

	}
}
