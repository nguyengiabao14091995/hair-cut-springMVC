package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_booking")
	private String nameBooking;

	@Column(name = "phone_booking")
	private String phone;

	@Column(name = "date_booking")
	private String date;

	@Column(name = "time_booking")
	private String time;

	@Column(name = "service_booking")
	private String service;

	@Column(name = "check_booking")
	private String check;

	public Booking() {
		super();
	}

	public Booking(String nameBooking, String phone, String date, String time, String service) {
		super();
		this.nameBooking = nameBooking;
		this.phone = phone;
		this.date = date;
		this.time = time;
		this.service = service;
	}

	public Booking(String nameBooking, String phone, String date, String time, String service, String check) {
		super();
		this.nameBooking = nameBooking;
		this.phone = phone;
		this.date = date;
		this.time = time;
		this.service = service;
		this.check = check;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameBooking() {
		return nameBooking;
	}

	public void setNameBooking(String nameBooking) {
		this.nameBooking = nameBooking;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

}
