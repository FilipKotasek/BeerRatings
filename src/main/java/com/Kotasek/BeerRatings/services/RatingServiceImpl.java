package com.Kotasek.BeerRatings.services;

import com.Kotasek.BeerRatings.dto.RatingDTO;
import com.Kotasek.BeerRatings.entities.RatingEntity;
import com.Kotasek.BeerRatings.filter.RatingFilter;
import com.Kotasek.BeerRatings.mappers.RatingMapper;
import com.Kotasek.BeerRatings.repositories.BeerRepository;
import com.Kotasek.BeerRatings.repositories.RatingRepository;
import com.Kotasek.BeerRatings.repositories.UserRepository;
import com.Kotasek.BeerRatings.specification.RatingSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Služba implementující logiku pro správu hodnocení piv.
 * Tato třída poskytuje funkce pro přidávání, úpravu, mazání a získávání hodnocení,
 * stejně jako filtrování hodnocení na základě zadaných kritérií.
 */
@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    RatingMapper ratingMapper;


    @Autowired
    RatingRepository ratingRepository;


    @Autowired
    BeerRepository beerRepository;


    @Autowired
    UserRepository userRepository;

    /**
     * Přidá nové hodnocení piva do databáze.
     *
     * @param ratingDTO DTO obsahující informace o novém hodnocení.
     * @return DTO obsahující uložené hodnocení.
     */
    @Override
    public RatingDTO addRating(RatingDTO ratingDTO) {
        RatingEntity rating = ratingMapper.toEntity(ratingDTO);
        rating.setBeer(beerRepository.getReferenceById(ratingDTO.getBeerId()));
        rating.setUser(userRepository.getReferenceById(ratingDTO.getUserId()));
        rating.setCreated_at(LocalDate.now());
        return ratingMapper.toDTO(ratingRepository.save(rating));
    }

    /**
     * Upravit existující hodnocení piva v databázi.
     *
     * @param id ID hodnocení, které má být upraveno.
     * @param newData DTO obsahující nové údaje pro hodnocení.
     * @return DTO obsahující upravené hodnocení.
     */
    @Override
    public RatingDTO editRating(long id, RatingDTO newData) {
        RatingEntity ratingToEdit = ratingMapper.toEntity(newData);
        ratingToEdit.setId(id);
        ratingToEdit.setBeer(beerRepository.getReferenceById(newData.getBeerId()));
        ratingToEdit.setUser(userRepository.getReferenceById(newData.getUserId()));
        ratingToEdit.setCreated_at(LocalDate.now());
        return ratingMapper.toDTO(ratingRepository.save(ratingToEdit));
    }

    /**
     * Získá seznam všech hodnocení na základě zadaných filtrů.
     *
     * @param filter Objekt obsahující kritéria pro filtrování hodnocení.
     * @return Seznam DTO reprezentujících hodnocení, která splňují kritéria filtru.
     */
    @Override
    public List<RatingDTO> getAllRatings(RatingFilter filter) {
        RatingSpecification ratingSpecification = new RatingSpecification(filter);
        List<RatingEntity> ratings = ratingRepository.findAll(ratingSpecification);
        return ratingMapper.toDTOs(ratings);
    }

    /**
     * Smaže hodnocení z databáze na základě jeho ID.
     *
     * @param id ID hodnocení, které má být smazáno.
     * @return DTO obsahující informace o smazaném hodnocení.
     */
    @Override
    public RatingDTO deleteRating(Long id) {
        RatingEntity ratingToDelete = ratingRepository.getReferenceById(id);
        RatingDTO deletedRating = ratingMapper.toDTO(ratingToDelete);
        ratingRepository.delete(ratingToDelete);
        return deletedRating;
    }

    /**
     * Získá detaily o konkrétním hodnocení na základě jeho ID.
     *
     * @param id ID hodnocení, které má být získáno.
     * @return DTO obsahující informace o hodnocení.
     */
    @Override
    public RatingDTO getRating(Long id) {
        RatingEntity entity = ratingRepository.getReferenceById(id);
        return ratingMapper.toDTO(entity);
    }
}
