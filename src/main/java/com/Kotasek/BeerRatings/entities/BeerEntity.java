package com.Kotasek.BeerRatings.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class BeerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String alcohol;
    @Column(nullable = false)
    private String style;
    @Column(nullable = false)
    private String hop;
    @Column(nullable = false)
    private String malts;
    @Column(nullable = false)
    private String ibu;
    @Column(nullable = false)
    private String blg;
    @OneToMany(mappedBy="beer")
    private List<RatingEntity> ratings;


}
