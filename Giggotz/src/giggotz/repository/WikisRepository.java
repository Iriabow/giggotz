package giggotz.repository;

import giggotz.domain.Article;

import java.util.Collection;

public interface WikisRepository {

	public Collection<Article> getAll();
	public Article addArticle(String artista);
	public void put(Article a);
	public Article getArticle(String artista);
	
}
