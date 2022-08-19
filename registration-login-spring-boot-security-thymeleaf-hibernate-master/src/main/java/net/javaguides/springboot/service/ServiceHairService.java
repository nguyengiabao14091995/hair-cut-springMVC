package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.model.ServiceHair;
import net.javaguides.springboot.repository.ServiceHairRepository;
@Service
@Transactional
public class ServiceHairService {

	@Autowired
	private ServiceHairRepository repo;

	public List<ServiceHair> listAll() {
		return repo.findAll();
	}
	
	public List<ServiceHair> findByTop() {
		return repo.findByTop();
	}

	public void save(ServiceHair serviceHair) {
		repo.save(serviceHair);
	}

	public ServiceHair get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}
