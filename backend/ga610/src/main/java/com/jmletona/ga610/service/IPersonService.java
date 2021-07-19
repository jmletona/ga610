package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Person;

import java.util.List;

public interface IPersonService {

    Person create(Person person);

    Person update(Person person);

    Person findById(Integer id);

    List<Person> findByCountryAndService(String country, Integer idService);

    List<Person> findAll();

    void delete(Integer id);

}
