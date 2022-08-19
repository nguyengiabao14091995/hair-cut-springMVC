package net.javaguides.springboot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ask_prices")
public class AskPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name_ask")
	private String nameAsk;

	@Column(name = "phone_ask")
	private String phoneAsk;

	@Column(name = "email_ask")
	private String emailAsk;

	@Column(name = "message_ask")
	private String messageAsk;

	@Column(name = "image_ask")
	private String imageAsk;

	@Column(name = "check_ask")
	private String checkAsk;

	public AskPrice() {
		super();
	}

	public AskPrice(String nameAsk, String phoneAsk, String emailAsk, String messageAsk, String imageAsk) {
		super();
		this.nameAsk = nameAsk;
		this.phoneAsk = phoneAsk;
		this.emailAsk = emailAsk;
		this.messageAsk = messageAsk;
		this.imageAsk = imageAsk;
	}

	public AskPrice(String nameAsk, String phoneAsk, String emailAsk, String messageAsk) {
		super();
		this.nameAsk = nameAsk;
		this.phoneAsk = phoneAsk;
		this.emailAsk = emailAsk;
		this.messageAsk = messageAsk;
	}

	public AskPrice(String nameAsk, String phoneAsk, String messageAsk) {
		super();
		this.nameAsk = nameAsk;
		this.phoneAsk = phoneAsk;
		this.messageAsk = messageAsk;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameAsk() {
		return nameAsk;
	}

	public void setNameAsk(String nameAsk) {
		this.nameAsk = nameAsk;
	}

	public String getPhoneAsk() {
		return phoneAsk;
	}

	public void setPhoneAsk(String phoneAsk) {
		this.phoneAsk = phoneAsk;
	}

	public String getEmailAsk() {
		return emailAsk;
	}

	public void setEmailAsk(String emailAsk) {
		this.emailAsk = emailAsk;
	}

	public String getMessageAsk() {
		return messageAsk;
	}

	public void setMessageAsk(String messageAsk) {
		this.messageAsk = messageAsk;
	}

	public String getImageAsk() {
		return imageAsk;
	}

	public void setImageAsk(String imageAsk) {
		this.imageAsk = imageAsk;
	}

	public String getCheckAsk() {
		return checkAsk;
	}

	public void setCheckAsk(String checkAsk) {
		this.checkAsk = checkAsk ;
	}

}
