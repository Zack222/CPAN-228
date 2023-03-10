package com.cpan252.tekkenreborn.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.Fighter.Anime;

public interface FighterRepository extends CrudRepository<Fighter, Long> {
    List<Fighter> findByAnimeFrom(Anime anime);

    List<Fighter> findByNameStartsWithAndCreatedAtBetween(String name, LocalDate startDate, LocalDate endDate);
}