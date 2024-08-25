package com.Kotasek.BeerRatings.repositories;

import com.Kotasek.BeerRatings.entities.BeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerRepository extends JpaRepository<BeerEntity,Long> {

List<BeerEntity> findByUid(String uid);

}
