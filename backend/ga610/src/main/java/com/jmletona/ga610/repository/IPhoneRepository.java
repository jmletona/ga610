package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
    @Query(value = "SELECT DISTINCT SUBSTRING_INDEX(SUBSTRING_INDEX(SUBSTRING(COLUMN_TYPE, 7, LENGTH(COLUMN_TYPE) - 8), \"','\", 1 + units.i + tens.i * 10) , \"','\", -1) AS phone_type\n" +
            "FROM INFORMATION_SCHEMA.COLUMNS\n" +
            "CROSS JOIN (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) units\n" +
            "CROSS JOIN (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) tens\n" +
            "WHERE TABLE_NAME = 'phone' \n" +
            "AND COLUMN_NAME = 'phone_type'", nativeQuery = true)
    List<String> findPhoneTypes();
}
