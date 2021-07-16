package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.Service;

import java.util.List;

public interface IServiceService {
    Service create(Service newService);

    Service update(Service serviceToUpdate);

    Service findById(Integer id);

    List<Service> findAll();

    void delete(Integer id);
}
