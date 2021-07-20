package com.jmletona.ga610.service;

import com.jmletona.ga610.model.PersonService;
import com.jmletona.ga610.model.PersonServiceId;

public interface IPersonServiceService {
    PersonService create(PersonService personService);

    void delete(PersonServiceId id);
}
