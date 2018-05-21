package fp.back.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Proposal {

	public static enum Type {
		ACHAT
	}

	public static enum Method {
		POSTE, DOMICILE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String price;
	private boolean status;
	private String type;
	private String delivery;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_city", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private City fromcity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_city", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private City tocity;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_shop", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Shop shop;



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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}


	@JsonIgnore
	public Shop getShop() {
		return shop;
	}

	@JsonSetter
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	@JsonSetter
	public void setUser(User user) {
		this.user = user;
	}
	
	@JsonIgnore
	public City getFromcity() {
		return fromcity;
	}

	@JsonSetter
	public void setFromcity(City fromcity) {
		this.fromcity = fromcity;
	}

	@JsonIgnore
	public City getTocity() {
		return tocity;
	}

	@JsonSetter
	public void setTocity(City tocity) {
		this.tocity = tocity;
	}
	
	public Long getFromCityId(){
		return this.fromcity.getId();
	}
	
	public Long getToCityId(){
		return this.tocity.getId();
	}
	
	public Long getIdUser(){
		return this.user.getId();
	}

}
