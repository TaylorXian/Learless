package org.xman.lear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xman.lear.domain.Fellow;
import org.xman.lear.persistence.FellowMapper;

@Service
public class FellowServiceImpl implements FellowService {

	@Autowired
	private FellowMapper fellowMapper;

	public void save(Fellow fellow) {
		fellowMapper.insert(fellow);
	}

	@Override
	public List<Fellow> findAll() {
		return fellowMapper.selectByExample(null);
	}

}
