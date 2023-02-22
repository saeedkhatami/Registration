package com.uni.register.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String address;
    private LocalDate dob;
    private Majors major;

    private Integer age;

    public Teacher() {
    }

    public Teacher(Long id,
                   String firstName,
                   String lastName,
                   String email,
                   Long phoneNumber,
                   String address,
                   LocalDate dob,
                   Majors major) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
        this.major = major;
    }

    public Teacher(String firstName,
                   String lastName,
                   String email,
                   Long phoneNumber,
                   String address,
                   LocalDate dob,
                   Majors major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
        this.major = major;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Majors getMajor() {
        return major;
    }

    public void setMajor(Majors major) {
        this.major = major;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", major=" + major +
                ", age=" + age +
                '}';
    }
}
