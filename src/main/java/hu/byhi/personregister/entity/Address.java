package hu.byhi.personregister.entity;

import jakarta.persistence.*;


import java.util.List;
import java.util.Set;

@Entity(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String city;
    private String street;
    private Integer houseNumber;

    @OneToMany(mappedBy = "mainAddress")
    List<Person> mainperson;
    @OneToMany(mappedBy = "tempAddress")
    List<Person> tempPerson;



    @OneToMany(mappedBy="address")
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

    public List<Person> getMainperson() {
        return mainperson;
    }

    public void setMainperson(List<Person> mainperson) {
        this.mainperson = mainperson;
    }

    public List<Person> getTempPerson() {
        return tempPerson;
    }

    public void setTempPerson(List<Person> tempPerson) {
        this.tempPerson = tempPerson;
    }
}
