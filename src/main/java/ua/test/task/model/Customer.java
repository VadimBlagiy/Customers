package ua.test.task.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers_table")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "full_name")
    @Pattern(regexp="(^([a-zA-Z]{2,50}\\s[a-zA-Z]{2,50}\\s[a-zA-Z]{2,50})$)")
    private String fullName;

    @Pattern(regexp="(^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$)")
    @Column(name = "email")
    private String email;

    @Pattern(regexp="(^[+][0-9]{6,14}$)?")
    @Column(name = "phone")
    private String phone;

    @Column(name = "is_deleted", nullable = true)
    private Boolean isDeleted = false;

    @Column(name = "created")
    public  LocalDateTime creatCustomer =  LocalDateTime.now();

    public Customer() {
    }

    public Customer(Long id, String fullName, String email, String phone, Boolean isDeleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.isDeleted = isDeleted;

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}