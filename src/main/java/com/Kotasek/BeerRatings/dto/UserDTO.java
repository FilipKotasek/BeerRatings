package com.Kotasek.BeerRatings.dto;

import com.Kotasek.BeerRatings.entities.RatingEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;

}
