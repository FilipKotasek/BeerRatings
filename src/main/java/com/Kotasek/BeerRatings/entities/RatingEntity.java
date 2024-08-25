package com.Kotasek.BeerRatings.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    @Max(5)
    @Min(0)
    private int stars;

    @Column
    private LocalDate created_at;

    @ManyToOne
    private BeerEntity beer;
    @ManyToOne
    private UserEntity user;


}
