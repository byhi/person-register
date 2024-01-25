package hu.byhi.personregister.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String city;
    private String street;
    private Integer houseNumber;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "ADDRESS_CONTACT",
            joinColumns = {@JoinColumn(name = "ADDRESS_FK")},
            inverseJoinColumns = {@JoinColumn(name = "CONTACT_FK")}
    )
    Set<Contact> contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

}
