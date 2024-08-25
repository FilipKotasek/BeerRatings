package com.Kotasek.BeerRatings.controllers;

import com.Kotasek.BeerRatings.dto.RatingDTO;
import com.Kotasek.BeerRatings.filter.RatingFilter;
import com.Kotasek.BeerRatings.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller pro správu hodnocení piv.
 * Tento controller poskytuje API pro přidávání, úpravu, mazání a získávání hodnocení.
 */
@RestController
@RequestMapping("api")
public class RatingController {

     @Autowired
    RatingService ratingService;

    /**
     * Přidá nové hodnocení piva do databáze.
     *
     * @param ratingDTO DTO obsahující informace o hodnocení, které má být přidáno.
     * @return DTO obsahující uložené hodnocení.
     */
    @PostMapping("rating")
    public RatingDTO addRating(@RequestBody RatingDTO ratingDTO) {
        return ratingService.addRating(ratingDTO);
    }

    /**
     * Získá seznam všech hodnocení podle zadaných filtrů.
     *
     * @param filter Objekt obsahující kritéria pro filtrování hodnocení.
     * @return Seznam DTO obsahující všechna hodnocení, která splňují kritéria filtru.
     */
    @GetMapping("ratings")
    public List<RatingDTO> getAllRatings(RatingFilter filter) {
        return ratingService.getAllRatings(filter);
    }

    /**
     * Upraví existující hodnocení na základě jeho ID.
     *
     * @param ratingId ID hodnocení, které má být upraveno.
     * @param ratingDTO DTO obsahující nové údaje pro hodnocení.
     * @return DTO obsahující upravené hodnocení.
     */
    @PutMapping("rating/{ratingId}")
    public RatingDTO editRating(@PathVariable Long ratingId, @RequestBody RatingDTO ratingDTO) {
        return ratingService.editRating(ratingId, ratingDTO);
    }

    /**
     * Smaže hodnocení z databáze na základě jeho ID.
     *
     * @param id ID hodnocení, které má být smazáno.
     * @return DTO obsahující informace o smazaném hodnocení.
     */
    @DeleteMapping("delete/{id}")
    public RatingDTO deleteRating(@PathVariable Long id) {
        return ratingService.deleteRating(id);
    }

    /**
     * Získá detaily o konkrétním hodnocení na základě jeho ID.
     *
     * @param id ID hodnocení, které má být získáno.
     * @return DTO obsahující informace o hodnocení.
     */
    @GetMapping("rating/{id}")
    public RatingDTO getRating(@PathVariable Long id) {
        return ratingService.getRating(id);
    }
}
