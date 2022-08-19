package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_hair")
public class ServiceHair {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name_service")
	private String nameServiceHair;

	@Column(name = "description_service")
	private String descriptionService;
	
	@Column(name = "price_service")
	private double priceService;
	
	@Column(name = "picture_service")
	private String pictureService; 

	@Column(name = "count_service")
	private int  countService;

	public ServiceHair() {
		super();
	}

	public ServiceHair(String nameServiceHair, String descriptionService, int countService) {
		super();
		this.nameServiceHair = nameServiceHair;
		this.descriptionService = descriptionService;
		this.countService = countService;
	}

	public ServiceHair(String nameServiceHair, String descriptionService) {
		super();
		this.nameServiceHair = nameServiceHair;
		this.descriptionService = descriptionService;
	}

	public ServiceHair(String nameServiceHair) {
		super();
		this.nameServiceHair = nameServiceHair;
	}
	
	

	public String getPictureService() {
		return pictureService;
	}

	public void setPictureService(String pictureService) {
		this.pictureService = pictureService;
	}

	public ServiceHair(String nameServiceHair, String descriptionService, double priceService, String pictureService,
			int countService) {
		super();
		this.nameServiceHair = nameServiceHair;
		this.descriptionService = descriptionService;
		this.priceService = priceService;
		this.pictureService = pictureService;
		this.countService = countService;
	}

	public double getPriceService() {
		return priceService;
	}

	public void setPriceService(double priceService) {
		this.priceService = priceService;
	}

	public ServiceHair(String nameServiceHair, String descriptionService, double priceService) {
		super();
		this.nameServiceHair = nameServiceHair;
		this.descriptionService = descriptionService;
		this.priceService = priceService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameServiceHair() {
		return nameServiceHair;
	}

	public void setNameServiceHair(String nameServiceHair) {
		this.nameServiceHair = nameServiceHair;
	}

	public String getDescriptionService() {
		return descriptionService;
	}

	public void setDescriptionService(String descriptionService) {
		this.descriptionService = descriptionService;
	}

	public int getCountService() {
		return countService;
	}

	public void setCountService(int countService) {
		this.countService = countService;
	}

	
}
