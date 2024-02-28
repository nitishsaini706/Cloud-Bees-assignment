package com.train.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {

    private String from;
    private String to;
    private User user;
    private int pricePaid;
    private String section;
    private String seat;


    public void setSection(String s) {
    }

    public void setSeat(String newSeat) {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTo(String to) {
        this.to = to;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    public String getSection() {
        return section;
    }

    public void setPricePaid(int pricePaid) {
        this.pricePaid=pricePaid;
    }

    public String getSeat() {
        return seat;
    }
}