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


}