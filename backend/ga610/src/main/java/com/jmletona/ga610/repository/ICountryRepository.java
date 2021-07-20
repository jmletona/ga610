package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country,Integer> {
}
