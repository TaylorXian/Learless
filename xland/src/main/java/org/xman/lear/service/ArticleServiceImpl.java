package org.xman.lear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xman.lear.domain.Article;
import org.xman.lear.domain.ArticleExample;
import org.xman.lear.persistence.ArticleMapper;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<Article> findAll() {
		return articleMapper.selectByExample(null);
	}

	@Override
	public List<Article> findAllDesc() {
		ArticleExample example = new ArticleExample();
		example.setOrderByClause("julianday(ctime) desc");
		return articleMapper.selectByExample(example);
	}

	@Override
	public Article findById(Integer id) {
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(Article article) {
		articleMapper.insert(article);
	}
	
}
