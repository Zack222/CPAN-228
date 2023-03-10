package com.cpan252.tekkenreborn.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cpan252.tekkenreborn.model.Fighter;

public interface FighterRepositoryPaginated extends PagingAndSortingRepository<Fighter, Long> {
}