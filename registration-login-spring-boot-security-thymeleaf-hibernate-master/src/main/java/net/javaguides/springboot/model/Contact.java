package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name_contact")
	private String nameContact;
	
	@Column(name = "email_contact")
	private String emailContact;
	
	@Column(name = "phone_contact")
	private String phoneContact;
	
	@Column(name = "content_contact")
	private String contentContact;

	public Contact() {
		super();
	}

	public Contact(String nameContact, String emailContact, String phoneContact, String contentContact) {
		super();
		this.nameContact = nameContact;
		this.emailContact = emailContact;
		this.phoneContact = phoneContact;
		this.contentContact = contentContact;
	}

	public Contact(Long id, String nameContact, String emailContact, String contentContact) {
		super();
		this.id = id;
		this.nameContact = nameContact;
		this.emailContact = emailContact;
		this.contentContact = contentContact;
	}

	public Contact(Long id, String nameContact, String emailContact, String phoneContact, String contentContact) {
		super();
		this.id = id;
		this.nameContact = nameContact;
		this.emailContact = emailContact;
		this.phoneContact = phoneContact;
		this.contentContact = contentContact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameContact() {
		return nameContact;
	}

	public void setNameContact(String nameContact) {
		this.nameContact = nameContact;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public String getPhoneContact() {
		return phoneContact;
	}

	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}

	public String getContentContact() {
		return contentContact;
	}

	public void setContentContact(String contentContact) {
		this.contentContact = contentContact;
	}
	
	

}
