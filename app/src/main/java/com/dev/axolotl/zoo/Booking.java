package com.dev.axolotl.zoo;

import java.util.Date;

import lombok.Data;

/**
 * Created by xavierbauquet on 17/04/2016.
 */
@Data
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


}
