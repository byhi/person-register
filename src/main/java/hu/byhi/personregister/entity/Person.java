package hu.byhi.personregister.entity;

import jakarta.persistence.*;

@Entity(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String fullName;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_main_address", referencedColumnName = "id")
    Address mainAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_temp_address", referencedColumnName = "id")
    Address tempAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Address getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(Address mainAddress) {
        this.mainAddress = mainAddress;
    }

    public Address getTempAddress() {
        return tempAddress;
    }

    public void setTempAddress(Address tempAddress) {
        this.tempAddress = tempAddress;
    }
}