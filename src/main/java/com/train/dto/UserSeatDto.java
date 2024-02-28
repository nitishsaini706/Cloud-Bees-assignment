package com.train.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UserSeatDto {
    public String userId;
    public String newSection;
    public String newSeat;
}
