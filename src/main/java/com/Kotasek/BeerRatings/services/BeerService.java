package com.Kotasek.BeerRatings.services;

import com.Kotasek.BeerRatings.dto.BeerDTO;
import com.Kotasek.BeerRatings.filter.RatingFilter;

import java.util.List;

public interface BeerService {

    public BeerDTO saveBeer(BeerDTO beer);
    public void saveBeersFromApi();



    List<BeerDTO> getAllBeers();

    public BeerDTO getBeer(Long id);
}
