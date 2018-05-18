package fp.back.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import fp.back.model.AuditModel;

@Entity
public class Proposal extends AuditModel {

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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "proposal_shops", joinColumns = @JoinColumn(name = "proposal_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id"))
	List<Shop> shops;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_city", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private City fromcity;

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_city", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private City tocity;

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

	public City getFromcity() {
		return fromcity;
	}

	public void setFromcity(City fromcity) {
		this.fromcity = fromcity;
	}

	public City getTocity() {
		return tocity;
	}

	public void setTocity(City tocity) {
		this.tocity = tocity;
	}

}
