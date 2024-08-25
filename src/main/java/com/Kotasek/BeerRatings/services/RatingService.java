package com.Kotasek.BeerRatings.services;

import com.Kotasek.BeerRatings.dto.RatingDTO;
import com.Kotasek.BeerRatings.filter.RatingFilter;

import java.util.List;

public interface RatingService {

    public RatingDTO addRating(RatingDTO ratingDTO);

    public RatingDTO editRating(long id, RatingDTO newData);

    public List<RatingDTO> getAllRatings(RatingFilter filter);

    public RatingDTO deleteRating(Long id);

    public  RatingDTO getRating(Long id);
}
