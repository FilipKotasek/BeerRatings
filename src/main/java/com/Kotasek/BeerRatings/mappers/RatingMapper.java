package com.Kotasek.BeerRatings.mappers;

import com.Kotasek.BeerRatings.dto.RatingDTO;
import com.Kotasek.BeerRatings.entities.RatingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    @Mapping(target = "userId",source = "user.id")
    @Mapping(target ="beerId",source = "beer.id")
    RatingDTO toDTO(RatingEntity entity);


    @Mapping(target = "beer",ignore = true)
    @Mapping(target = "user",ignore = true)
    RatingEntity toEntity(RatingDTO dto);

    List<RatingDTO> toDTOs(List<RatingEntity> ratingEntity);
}
