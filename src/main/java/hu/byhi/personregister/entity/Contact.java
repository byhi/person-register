package hu.byhi.personregister.entity;

import jakarta.persistence.*;


@Entity(name = "Contact")
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String phone;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
