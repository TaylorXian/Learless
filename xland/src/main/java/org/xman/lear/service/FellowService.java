package org.xman.lear.service;

import java.util.List;

import org.xman.lear.domain.Fellow;

public interface FellowService {

	void save(Fellow fellow);

	List<Fellow> findAll();

	Fellow findByName(String name);

}
