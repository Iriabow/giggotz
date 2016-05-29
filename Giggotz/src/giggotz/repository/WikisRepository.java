package giggotz.repository;

import giggotz.domain.Article;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WikisRepository{

	Map<String,Article> articleMap;
	
	public WikisRepository(){
		articleMap = new HashMap<String, Article>();
	}
	

	public Collection<Article> getAll() {
		return articleMap.values();
	}

	
	public void put(Article a) {
		articleMap.put(a.getArtista(), a);
		
	}

	
	public Article getArticle(String artista) {
		return articleMap.get(artista);
	}

}
