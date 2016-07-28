package org.xman.xland.web.service;

import java.util.List;

import org.xman.xland.core.domain.Word;

public interface WordService {

	List<Word> findAll();

	Word findById(Integer id);

	void save(Word word);

}
