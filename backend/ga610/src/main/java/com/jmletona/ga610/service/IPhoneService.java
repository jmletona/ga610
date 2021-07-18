package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Phone;

import java.util.List;

public interface IPhoneService {

    Phone create(Phone phone);

    Phone update(Phone phone);

    Phone findById(Integer id);

    List<Phone> findAll();

    void delete(Integer id);
}
