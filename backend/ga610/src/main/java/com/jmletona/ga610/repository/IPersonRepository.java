package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

    @Query("select p from Person p ")
    public List<Person> findAllPeopleByService(Integer serviceId);
}
