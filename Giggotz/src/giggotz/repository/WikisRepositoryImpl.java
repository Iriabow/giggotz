package giggotz.repository;

import giggotz.domain.Article;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WikisRepositoryImpl implements WikisRepository{

	Map<String,Article> ArticleMap;
	
	public WikisRepositoryImpl(){
		ArticleMap = new HashMap<String, Article>();
	}
	
	@Override
	public Collection<Article> getAll() {
		return ArticleMap.values();
	}

	@Override
	public Article addArticle(String artista) {
		// TODO COMO COÑO SE HACE ESTO WEY
		return null;
	}

	@Override
	public void put(Article a) {
		ArticleMap.put(a.getArtista(), a);
		
	}

	@Override
	public Article getArticle(String artista) {
		return ArticleMap.get(artista);
	}

}
