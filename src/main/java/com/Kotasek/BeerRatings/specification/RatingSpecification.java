package com.Kotasek.BeerRatings.specification;

import com.Kotasek.BeerRatings.entities.BeerEntity;
import com.Kotasek.BeerRatings.entities.BeerEntity_;
import com.Kotasek.BeerRatings.entities.RatingEntity;
import com.Kotasek.BeerRatings.entities.RatingEntity_;
import com.Kotasek.BeerRatings.filter.RatingFilter;
import jakarta.persistence.criteria.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * Specifikace pro filtraci hodnocení piv.
 * Tato třída implementuje rozhraní {@link Specification} pro entitu {@link RatingEntity}.
 * Poskytuje predikáty, které slouží k filtrování hodnocení na základě zadaných kritérií.
 */
@RequiredArgsConstructor
public class RatingSpecification implements Specification<RatingEntity> {

    /**
     * Filtr pro hodnocení, který obsahuje kritéria pro filtrování.
     */
    private final RatingFilter filter;

    /**
     * Vytváří predikát pro filtrování hodnocení podle zadaného filtru.
     *
     * @param root Kořenový element pro dotaz, který představuje entitu {@link RatingEntity}.
     * @param query Dotaz, který je vytvořen na základě predikátu.
     * @param criteriaBuilder Builder pro vytváření predikátů a dotazů.
     * @return Predikát, který definuje podmínky pro filtrování hodnocení.
     */
    @Override
    public Predicate toPredicate(Root<RatingEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        // Filtr podle data od.
        if (filter.getFromDate() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(RatingEntity_.CREATED_AT), filter.getFromDate()));
        }

        // Filtr podle data do.
        if (filter.getToDate() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(RatingEntity_.CREATED_AT), filter.getToDate()));
        }

        // Filtr podle ID piva.
        if (filter.getBeerId() != null) {
            Join<BeerEntity, RatingEntity> beerJoin = root.join(RatingEntity_.BEER);
            predicates.add(criteriaBuilder.equal(beerJoin.get(BeerEntity_.ID), filter.getBeerId()));
        }

        // Vytváří a vrací kombinovaný predikát z všech jednotlivých predikátů.
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
