package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICampusRepository extends JpaRepository<Campus, Integer> {
    @Query(value = "SELECT DISTINCT c.country FROM campus c", nativeQuery = true)
    List<String> findCountries();

    List<Campus> findByCountry(String country);
}
