package com.Kotasek.BeerRatings.repositories;

import com.Kotasek.BeerRatings.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
