package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class FlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String airline;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull
    private String fromAirport;
    @NotNull
    private String toAirprot;
    @NotNull
    private String price;
    public FlightInfo(){
    }

    public FlightInfo(String airline, Date date, String fromAirport, String toAirprot,  String price){
        this.airline = airline;
        this.date = date;
        this.fromAirport = fromAirport;
        this.toAirprot = toAirprot;
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirprot() {
        return toAirprot;
    }

    public void setToAirprot(String toAirprot) {
        this.toAirprot = toAirprot;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
