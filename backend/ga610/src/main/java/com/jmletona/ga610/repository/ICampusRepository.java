package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICampusRepository extends JpaRepository<Campus, Integer> {

    public List<Campus> findByCountry(String country);
}
