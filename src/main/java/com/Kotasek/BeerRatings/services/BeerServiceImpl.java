package com.Kotasek.BeerRatings.services;

import com.Kotasek.BeerRatings.dto.BeerDTO;
import com.Kotasek.BeerRatings.entities.BeerEntity;
import com.Kotasek.BeerRatings.filter.RatingFilter;
import com.Kotasek.BeerRatings.mappers.BeerMapper;
import com.Kotasek.BeerRatings.repositories.BeerRepository;
import com.Kotasek.BeerRatings.specification.RatingSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Služba implementující logiku pro správu piv.
 * Tato služba umožňuje ukládání, získávání a zpracování piv, včetně
 * načítání dat z externího REST API při startu aplikace.
 */
@Service
public class BeerServiceImpl implements BeerService {


    @Autowired
    BeerRepository beerRepository;

    /**
     * URL externího API pro načítání seznamu piv.
     */
    private String url = "https://random-data-api.com/api/v2/beers?size=100";


    @Autowired
    BeerMapper beerMapper;

    /**
     * Uloží nové pivo do databáze.
     *
     * @param beer DTO obsahující informace o pivu, které má být uloženo.
     * @return DTO obsahující uložené pivo.
     */
    @Override
    public BeerDTO saveBeer(BeerDTO beer) {
        BeerEntity beerEntity = beerMapper.toEntity(beer);
        return beerMapper.toDTO(beerRepository.save(beerEntity));
    }

    /**
     * Načte seznam piv z externího API a uloží je do databáze při startu aplikace.
     * Tato metoda se spustí automaticky po inicializaci aplikace.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void saveBeersFromApi() {
        RestTemplate restTemplate = new RestTemplate();
        BeerEntity[] beersFromApi = restTemplate.getForObject(url, BeerEntity[].class);

        for (BeerEntity beer : beersFromApi) {
            if (!beerRepository.findByUid(beer.getUid()).contains(beer))
                beerRepository.save(beer);
        }
    }

    /**
     * Získá seznam všech piv uložených v databázi.
     *
     * @return Seznam DTO reprezentujících všechna piva v databázi.
     */
    @Override
    public List<BeerDTO> getAllBeers() {
        List<BeerEntity> allBeers = beerRepository.findAll();
        return beerMapper.toDTOs(allBeers);
    }

    /**
     * Získá detaily o konkrétním pivu na základě jeho ID.
     *
     * @param id ID piva, které má být získáno.
     * @return DTO obsahující informace o pivu.
     */
    @Override
    public BeerDTO getBeer(Long id) {
        BeerEntity beerEntity = beerRepository.getReferenceById(id);
        return beerMapper.toDTO(beerEntity);
    }
}