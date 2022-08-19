package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.model.BookingHome;
import net.javaguides.springboot.repository.BookingHomeRepository;

@Service
@Transactional
public class BookingHomeService {

	@Autowired
	private BookingHomeRepository repo;

	public List<BookingHome> listAll() {
		return repo.findAll();
	}

	public void save(BookingHome bookingHome) {
		repo.save(bookingHome);
	}

	public BookingHome get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}
}
