package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.javaguides.springboot.model.Contact;
import net.javaguides.springboot.repository.ContactRepository;

@Service
@Transactional
public class ContactService {
	@Autowired
	private ContactRepository repo;
	
	public List<Contact> listAll() {
		return repo.findAll();
	}

	public void save(Contact contact) {
		repo.save(contact);
	}

	public Contact get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}
