package com.Kotasek.BeerRatings.mappers;


import com.Kotasek.BeerRatings.dto.BeerDTO;
import com.Kotasek.BeerRatings.entities.BeerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeerMapper{

    BeerEntity toEntity(BeerDTO beerDTO);
    BeerDTO toDTO(BeerEntity beerEntity);

    List<BeerDTO> toDTOs(List<BeerEntity> beerEntity);


}
