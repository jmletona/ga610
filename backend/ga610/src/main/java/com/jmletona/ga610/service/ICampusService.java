package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.Person;

import java.util.List;

public interface ICampusService {

    Campus create(Campus newCampus);

    Campus update(Campus campusToUpdate);

    Campus findById(Integer id);

    List<Campus> findAll();

    void delete(Integer id);

}
