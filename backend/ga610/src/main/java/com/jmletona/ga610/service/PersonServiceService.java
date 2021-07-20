package com.jmletona.ga610.service;

import com.jmletona.ga610.model.PersonService;
import com.jmletona.ga610.model.PersonServiceId;
import com.jmletona.ga610.repository.IPersonServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceService implements IPersonServiceService{
    @Autowired
    private IPersonServiceRepository personServiceRepository;

    @Override
    public PersonService create(PersonService personService){
        return personServiceRepository.save(personService);
    }

    @Override
    public void delete(PersonServiceId id) {
        personServiceRepository.deleteById(id);
    }
}
