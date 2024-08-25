package com.Kotasek.BeerRatings.dto;

import com.Kotasek.BeerRatings.entities.BeerEntity;
import com.Kotasek.BeerRatings.entities.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class RatingDTO {


    @NotNull
    private Long id;

    private String description;

    @NotNull
    private int stars;

    @NotNull
    private LocalDate created_at;

    @NotNull
    private Long beerId;
    @NotNull
    private Long userId;

    private BeerDTO beer;

    private UserDTO user;



}
