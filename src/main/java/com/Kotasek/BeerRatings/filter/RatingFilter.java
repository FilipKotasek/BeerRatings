package com.Kotasek.BeerRatings.filter;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RatingFilter {

    private Long beerId;
    private Long UserId;
    private LocalDate fromDate;
    private LocalDate toDate;

}
