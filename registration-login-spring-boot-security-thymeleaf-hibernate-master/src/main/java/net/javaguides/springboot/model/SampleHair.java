package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sample_hair")
public class SampleHair {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private float price;

	@Column(name = "image")
	private String image;
	
	@Column(name = "image2")
	private String image2;
	
	@Column(name = "image3")
	private String image3;
	
	@Column(name = "image4")
	private String image4;
	
	@Column(name = "image5")
	private String image5;
	
	@Column(name = "image6")
	private String image6;
	
	@Column(name = "image7")
	private String image7;
	
	@Column(name = "image8")
	private String image8;
	
	@Column(name = "image9")
	private String image9;
	
	@Column(name = "count_view")
	private int countView;

	public SampleHair(String name, String description, float price, String image) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	public SampleHair() {
		super();
	}

	


	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public String getImage6() {
		return image6;
	}

	public void setImage6(String image6) {
		this.image6 = image6;
	}

	public String getImage7() {
		return image7;
	}

	public void setImage7(String image7) {
		this.image7 = image7;
	}

	public String getImage8() {
		return image8;
	}

	public void setImage8(String image8) {
		this.image8 = image8;
	}

	public String getImage9() {
		return image9;
	}

	public void setImage9(String image9) {
		this.image9 = image9;
	}

	public SampleHair(String name, String description, float price, String image, String image2, String image3,
			String image4, String image5, String image6, String image7, String image8, String image9) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.image6 = image6;
		this.image7 = image7;
		this.image8 = image8;
		this.image9 = image9;
	}

	public int getCountView() {
		return countView;
	}

	public void setCountView(int countView) {
		this.countView = countView; 
	}

	public SampleHair(String name, String description, float price, String image, int countView) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.countView = countView;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
