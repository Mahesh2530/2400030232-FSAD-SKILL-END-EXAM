package com.klef.fsad.exam.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @Column(name = "hotel_id", nullable = false, unique = true)
    private String hotelId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "status")
    private String status = "ACTIVE";

    @Column(name = "location")
    private String location;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "contact_number")
    private String contactNumber;

    // Constructors
    public Hotel() {
    }

    public Hotel(String hotelId, String name, LocalDate date, String status, 
                 String location, Double rating, String contactNumber) {
        this.hotelId = hotelId;
        this.name = name;
        this.date = date;
        this.status = status;
        this.location = location;
        this.rating = rating;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + hotelId + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", rating=" + rating +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
