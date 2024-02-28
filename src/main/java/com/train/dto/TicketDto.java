package com.train.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TicketDto {
    private String from;
    private String to;
    private String userId;
    private int pricePaid;
    private String seat;
}
