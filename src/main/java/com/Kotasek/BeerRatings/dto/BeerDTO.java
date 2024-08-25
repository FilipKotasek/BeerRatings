package com.Kotasek.BeerRatings.dto;

import com.Kotasek.BeerRatings.entities.RatingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeerDTO {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String brand;

    private String alcohol;

    private String style;

    private String hop;

    private String malts;

    private String ibu;

    private String blg;


}
