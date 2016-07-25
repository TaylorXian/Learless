package org.xman.lear.service;

import java.util.List;

import org.xman.lear.domain.Article;

public interface ArticleService {

	List<Article> findAll();

	List<Article> findAllDesc();

	Article findById(Integer id);

	void save(Article article);

}
