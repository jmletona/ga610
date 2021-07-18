package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService{

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        Person personTMP = findById(person.getIdPerson());
        personTMP.setActive(person.getActive());
        personTMP.setCompany(person.getCompany());
        personTMP.setDescription(person.getCompany());
        personTMP.setName(person.getName());
        personTMP.setLastname(person.getLastname());
        personTMP.setAddress(person.getAddress());
        return personRepository.save(personTMP);
    }

    @Override
    public Person findById(Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.orElse(null);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        personRepository.deleteById(id);
    }
}
