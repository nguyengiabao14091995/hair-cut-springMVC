package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_home")
public class BookingHome {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_booking_home")
	private String nameBookingHome;

	@Column(name = "phone_booking_home")
	private String phone_home;
	
	@Column(name = "address_booking_home")
	private String address_booking_home;

	@Column(name = "date_booking_home")
	private String date_home;

	@Column(name = "time_booking_home")
	private String time_home;

	@Column(name = "service_booking_home")
	private String service_home;

	@Column(name = "check_booking_home")
	private String check_home;

	public BookingHome() {
		super();
	}

	public BookingHome(String nameBookingHome, String phone_home, String address_booking_home, String date_home,
			String time_home, String service_home) {
		super();
		this.nameBookingHome = nameBookingHome;
		this.phone_home = phone_home;
		this.address_booking_home = address_booking_home;
		this.date_home = date_home;
		this.time_home = time_home;
		this.service_home = service_home;
	}

	public BookingHome(String nameBookingHome, String phone_home, String address_booking_home, String date_home,
			String time_home, String service_home, String check_home) {
		super();
		this.nameBookingHome = nameBookingHome;
		this.phone_home = phone_home;
		this.address_booking_home = address_booking_home;
		this.date_home = date_home;
		this.time_home = time_home;
		this.service_home = service_home;
		this.check_home = check_home;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameBookingHome() {
		return nameBookingHome;
	}

	public void setNameBookingHome(String nameBookingHome) {
		this.nameBookingHome = nameBookingHome;
	}

	public String getPhone_home() {
		return phone_home;
	}

	public void setPhone_home(String phone_home) {
		this.phone_home = phone_home;
	}

	public String getAddress_booking_home() {
		return address_booking_home;
	}

	public void setAddress_booking_home(String address_booking_home) {
		this.address_booking_home = address_booking_home;
	}

	public String getDate_home() {
		return date_home;
	}

	public void setDate_home(String date_home) {
		this.date_home = date_home;
	}

	public String getTime_home() {
		return time_home;
	}

	public void setTime_home(String time_home) {
		this.time_home = time_home;
	}

	public String getService_home() {
		return service_home;
	}

	public void setService_home(String service_home) {
		this.service_home = service_home;
	}

	public String getCheck_home() {
		return check_home;
	}

	public void setCheck_home(String check_home) {
		this.check_home = check_home;
	}

	
}
