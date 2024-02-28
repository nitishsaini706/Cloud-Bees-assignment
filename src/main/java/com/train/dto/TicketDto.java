package com.train.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
public class TicketDto {
    private String from;
    private String to;
    private String userId;
    private int pricePaid;
    private String seat;

    public String getSeat() {
        return seat;
    }

    public String getUserId() {
        return userId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getPricePaid() {
        return pricePaid;
    }
}
