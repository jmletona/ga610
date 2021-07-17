package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
}
