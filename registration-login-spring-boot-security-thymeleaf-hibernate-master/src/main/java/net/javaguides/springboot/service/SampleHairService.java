package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.model.SampleHair;
import net.javaguides.springboot.repository.SampleHairRepository;

@Service
@Transactional
public class SampleHairService {

	@Autowired
	private SampleHairRepository repo;
	
	public List<SampleHair> findByTop() {
		return repo.findByTop();
	}

	public List<SampleHair> listAll() {
		return repo.findAll();
	}

	public void save(SampleHair sampleHair) {
		repo.save(sampleHair);
	}

	public SampleHair get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}
