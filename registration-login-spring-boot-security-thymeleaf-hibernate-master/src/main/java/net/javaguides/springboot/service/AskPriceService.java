package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.model.AskPrice;
import net.javaguides.springboot.repository.AskPriceRepository;

@Service
@Transactional
public class AskPriceService {

	@Autowired
	private AskPriceRepository repo;

	public List<AskPrice> listAll() {
		return repo.findAll();
	}

	public void save(AskPrice askPrice) {
		repo.save(askPrice);
	}

	public AskPrice get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}
}
