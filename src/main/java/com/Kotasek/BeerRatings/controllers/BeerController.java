package com.Kotasek.BeerRatings.controllers;

import com.Kotasek.BeerRatings.dto.BeerDTO;
import com.Kotasek.BeerRatings.filter.RatingFilter;
import com.Kotasek.BeerRatings.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller pro správu piv.
 * Tato třída poskytuje API pro přidávání, získávání a zobrazení piv.
 */
@RestController
@RequestMapping("/api")
public class BeerController {


    @Autowired
    BeerService beerService;

    /**
     * Přidá nové pivo do databáze.
     *
     * @param beerDTO DTO obsahující informace o pivu, které má být přidáno.
     * @return DTO obsahující uložené pivo.
     */
    @PostMapping("beers")
    public BeerDTO saveBeer(@RequestBody BeerDTO beerDTO) {
        return beerService.saveBeer(beerDTO);
    }

    /**
     * Získá seznam všech piv.
     *
     * @return Seznam DTO obsahující všechna piva.
     */
    @GetMapping("beers")
    public List<BeerDTO> getBeers() {
        return beerService.getAllBeers();
    }

    /**
     * Získá detaily o konkrétním pivu na základě jeho ID.
     *
     * @param id ID piva, které má být získáno.
     * @return DTO obsahující informace o pivu.
     */
    @GetMapping("beer{id}")
    public BeerDTO getBeer(@PathVariable Long id) {
        return beerService.getBeer(id);
    }
}
