package fp.back.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany()
    private List<DeliveryType> deliveryTypes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_city", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City fromcity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_city", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City tocity;


    @ManyToMany(fetch = FetchType.LAZY)
    private List<Shop> shops = new ArrayList<>();

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

    public List<DeliveryType> getDeliveryTypes() {
        return deliveryTypes;
    }

    public void setDeliveryTypes(List<DeliveryType> deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }

    public List<Shop> getShops() {
        return shops;
    }

    @JsonSetter
    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public User getUser() {
        return user;
    }

    @JsonSetter
    public void setUser(User user) {
        this.user = user;
    }

    public City getFromcity() {
        return fromcity;
    }

    @JsonSetter
    public void setFromcity(City fromcity) {
        this.fromcity = fromcity;
    }

    public City getTocity() {
        return tocity;
    }

    @JsonSetter
    public void setTocity(City tocity) {
        this.tocity = tocity;
    }

    public Long getFromCityId() {
        return this.fromcity.getId();
    }

    public Long getToCityId() {
        return this.tocity.getId();
    }

    public Long getIdUser() {
        return this.user.getId();
    }

}
