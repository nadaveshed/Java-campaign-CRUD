package com.example.demo;

import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[\\ w - \\.] + @ ( [\\ w -] + \\.) + [\\ w -] {2,4}")
    @NotBlank
    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

//    @Pattern(regexp = "[+] * [(] {0,1} [0-9] {1,4} [)] {0,1} [- \\ s \\ ./ 0-9] *")
    @NonNull
    @Column(name = "phone", nullable = false, length = 20)
    private String telephone;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    public User() {}

    public User(String email, String telephone, String firstName, String lastName) {
        this.email = email;
        this.telephone = telephone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}