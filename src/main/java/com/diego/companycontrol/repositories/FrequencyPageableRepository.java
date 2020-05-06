package com.diego.companycontrol.repositories;

import com.diego.companycontrol.data.entities.Frequency;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequencyPageableRepository extends PagingAndSortingRepository<Frequency, Long> {
}
