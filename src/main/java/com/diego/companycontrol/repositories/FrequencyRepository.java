package com.diego.companycontrol.repositories;

import com.diego.companycontrol.data.entities.Frequency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrequencyRepository extends JpaRepository<Frequency, Long> {
}
