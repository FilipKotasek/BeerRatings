package com.Kotasek.BeerRatings.repositories;

import com.Kotasek.BeerRatings.entities.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RatingRepository extends JpaRepository<RatingEntity,Long>, JpaSpecificationExecutor<RatingEntity> {
}
