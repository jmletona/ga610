package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceRepository extends JpaRepository<Service,Integer> {

    @Query(value = "SELECT DISTINCT s.* FROM service s\n" +
            "INNER JOIN person_service ps ON ps.id_service = s.id_service\n" +
            "INNER JOIN person p ON p.id_person = ps.id_person\n" +
            "WHERE p.id_person IN (SELECT p.id_person FROM person p\n" +
            "\t\t\t\t\tINNER JOIN campus c ON c.id_campus = p.id_campus\n" +
            "\t\t\t\t\tWHERE c.country = ?1)", nativeQuery = true)
    List<Service> findByCountry(String country);

}
