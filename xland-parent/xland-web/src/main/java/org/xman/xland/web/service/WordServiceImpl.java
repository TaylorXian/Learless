package org.xman.xland.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.xman.xland.core.domain.Word;
import org.xman.xland.core.persistence.WordMapper;

@Service
public class WordServiceImpl implements WordService {

	private WordMapper wordMapper;

	@Override
	public List<Word> findAll() {
		return wordMapper.selectByExample(null);
	}

	@Override
	public Word findById(Integer id) {
		return wordMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(Word word) {
		wordMapper.insert(word);
	}

}
