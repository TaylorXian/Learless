package org.xman.xland.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xman.xland.core.domain.Fellow;
import org.xman.xland.core.domain.FellowExample;
import org.xman.xland.core.persistence.FellowMapper;

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

	@Override
	public Fellow findByName(String name) {
		return fellowMapper.findByName(name);
	}

}
