package com.xworkz.series.tester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.xworkz.series.constants.Genre;
import com.xworkz.series.constants.StreamedIn;
import com.xworkz.series.dao.WebseriesDAO;
import com.xworkz.series.dao.WebseriesDAOImpl;
import com.xworkz.series.dto.WebseriesDTO;

public class WebseriesTester {

	public static void main(String[] args) {
     Collection<WebseriesDTO> coll = new ArrayList<WebseriesDTO>();
		
		WebseriesDTO dto=new WebseriesDTO("Money heist",300,3,StreamedIn.NETFLIX,Genre.SCAM,18);
		
		WebseriesDAO dao = new WebseriesDAOImpl();
		dao.save(dto);
		
		Collection<WebseriesDTO> dt = dao.findAll();
		dt.forEach(s->System.out.println(s));
		
		int count = dao.total();
		System.out.println(count);
		
		int max=dao.findMaxSeason();
		System.out.println(max);
		
		int min=dao.findMinSeason();
		System.out.println(min);
		
		Collection<WebseriesDTO> set = dao.findAllSortByNameDesc();
		set.forEach(m->System.out.println(m));
		
		Optional<WebseriesDTO> one=dao.findOne(g->g.getName().equals("Seetha Vallaba"));
		if(one.isPresent()) {
			WebseriesDTO  optional=one.get();
			System.out.println(optional);
		}
		
		Collection<WebseriesDTO> pre=dao.findAll(m->m.getNoOfEpisodes()>450);
		pre.forEach(k->System.out.println(k));
		
		
		Collection<WebseriesDTO> saveall = dao.saveAll(coll);
		System.out.println(saveall);
	}
	 

	}


