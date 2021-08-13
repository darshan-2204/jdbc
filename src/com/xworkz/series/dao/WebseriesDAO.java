package com.xworkz.series.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.series.dto.WebseriesDTO;

public interface WebseriesDAO {
	
	int save(WebseriesDTO dto);

	Collection<WebseriesDTO> findAll();

	int total();

	int findMaxSeason();

	int findMinSeason();

	Collection<WebseriesDTO> findAllSortByNameDesc();

	Optional<WebseriesDTO> findOne(Predicate<WebseriesDTO> predicate);
	
	Collection<WebseriesDTO> findAll(Predicate<WebseriesDTO> predicate);
	
	Collection<WebseriesDTO> saveAll(Collection<WebseriesDTO> collection);

}
