package org.xman.xland.web.service;

import java.util.List;

import org.xman.xland.core.domain.Fellow;

public interface FellowService {

	void save(Fellow fellow);

	List<Fellow> findAll();

	Fellow findByName(String name);

}
