package com.Kotasek.BeerRatings.mappers;


import com.Kotasek.BeerRatings.dto.UserDTO;
import com.Kotasek.BeerRatings.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(UserEntity entity);
    UserEntity toEntity(UserDTO dto);

}
