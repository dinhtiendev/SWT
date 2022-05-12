/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorManagemetSystem;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Doctor {
    private String id;
    private String name;
    private Date dateOfBird;
    private String specialization;
    private int availability;
    private String email;
    private String mobile;

    public Doctor() {
    }

    public Doctor(String id, String name, Date dateOfBird, String specialization, int availability, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.dateOfBird = dateOfBird;
        this.specialization = specialization;
        this.availability = availability;
        this.email = email;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateOfBird() {
        return dateOfBird;
    }

    public void setDateOfBird(Date dateOfBird) {
        this.dateOfBird = dateOfBird;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void display() {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", id, name, dateOfBird, specialization, availability, email, mobile);
    }
}
