package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.repository.BookingRepository;

@Service
@Transactional
public class BookingService {


	@Autowired
	private BookingRepository repo;

	public List<Booking> listAll() {
		return repo.findAll();
	}

	public void save(Booking booking) {
		repo.save(booking);
	}

	public Booking get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}
}
