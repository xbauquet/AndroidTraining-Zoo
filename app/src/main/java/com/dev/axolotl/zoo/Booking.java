package com.dev.axolotl.zoo;

import java.util.Date;

/**
 * Created by xavierbauquet on 17/04/2016.
 */
public class Booking {

    private int id;
    private int nbAdults;
    private int nbChildren;
    private int nbGroups;
    private int nbReduced;
    private int price;
    private Date date;
    private String email;

    private final String UNKNOW_EMAIL = "unknow@unknow.com";

    public Booking(){
        this.date = new Date();
        this.email = UNKNOW_EMAIL;
    }

    public void calculatePrice(){
        this.price = (nbAdults*26) + (nbChildren*7) + (nbReduced*13) + (nbGroups*20);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbAdults() {
        return nbAdults;
    }

    public void setNbAdults(int nbAdults) {
        this.nbAdults = nbAdults;
    }

    public int getNbChildren() {
        return nbChildren;
    }

    public void setNbChildren(int nbChildren) {
        this.nbChildren = nbChildren;
    }

    public int getNbGroups() {
        return nbGroups;
    }

    public void setNbGroups(int nbGroups) {
        this.nbGroups = nbGroups;
    }

    public int getNbReduced() {
        return nbReduced;
    }

    public void setNbReduced(int nbReduced) {
        this.nbReduced = nbReduced;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public java.util.Date getDate() {
        return this.date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }






}
