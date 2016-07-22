package org.xman.xland.web.service;

import java.util.List;

import org.xman.xland.core.domain.Article;

public interface ArticleService {

	List<Article> findAll();

	List<Article> findAllDesc();

	Article findById(Integer id);

	void save(Article article);

}
