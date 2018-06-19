package com.codingdojo.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoninjas.models.Dojo;
import com.codingdojo.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	public List<Dojo> findAllDojos(){
		return dojoRepository.findAll();
	}
	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
	}
	public Dojo findDojo(Long dojoId) {
		Optional<Dojo> optionalDojo=dojoRepository.findById(dojoId);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
}
