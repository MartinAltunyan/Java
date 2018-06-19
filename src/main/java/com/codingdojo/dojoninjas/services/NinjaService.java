package com.codingdojo.dojoninjas.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.repositories.NinjaRepository;

@Service 
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
}
