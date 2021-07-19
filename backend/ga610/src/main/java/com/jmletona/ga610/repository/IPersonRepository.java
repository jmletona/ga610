package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT p.* FROM person p\n" +
            "INNER JOIN campus c ON c.id_campus = p.id_campus\n" +
            "INNER JOIN person_service ps ON ps.id_person = p.id_person\n" +
            "INNER JOIN service s ON s.id_service = ps.id_service\n" +
            "WHERE c.country = ?1\n" +
            "AND s.id_service = ?2", nativeQuery = true)
    List<Person> findByCountryAndService(String country, Integer idService);

}
