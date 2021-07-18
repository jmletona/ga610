package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.PersonDTO;
import com.jmletona.ga610.item.ItemPerson;
import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseApi<List<ItemPerson>> getAllPersons(){
        boolean success = false;
        String message = "No Person found";
        List<ItemPerson> itemPersonList = new ArrayList<>();
        List<Person> personList = personService.findAll();
        if(!personList.isEmpty()){
            success = true;
            message = "Person found";
            itemPersonList = showAllPersons(personList, itemPersonList);
        }
        return new ResponseApi<>(success, message, itemPersonList);
    }
    public List<ItemPerson> showAllPersons(List<Person> personList, List<ItemPerson> itemPersonList){
        for(Person person: personList){
            ItemPerson itemPerson = new ItemPerson();
            itemPerson = showPerson(person, itemPerson);
            itemPersonList.add(itemPerson);
        }
        return itemPersonList;
    }
    public ItemPerson showPerson(Person person, ItemPerson itemPerson){
        itemPerson.setIdPerson(person.getIdPerson());
        itemPerson.setActive(person.getActive());
        itemPerson.setCompany(person.getCompany());
        itemPerson.setDescription(person.getDescription());
        itemPerson.setName(person.getName());
        itemPerson.setLastname(person.getLastname());
        itemPerson.setAddress(person.getAddress());
        return itemPerson;
    }

    @PostMapping
    public ResponseApi<ItemPerson> create(@RequestBody PersonDTO personDTO){
        boolean success = false;
        String message = "Error";
        Person person = new Person();
        ItemPerson itemPerson = new ItemPerson();
        try{
            person=createPerson(person, personDTO);
            if(person!=null){
                itemPerson = showPerson(person, itemPerson);
                success = true;
                message = "Person was created successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemPerson);
    }
    public Person createPerson(Person person, PersonDTO personDTO){
        person.setActive(true);
        person.setCompany(personDTO.getCompany());
        person.setDescription(personDTO.getDescription());
        person.setName(personDTO.getName());
        person.setLastname(personDTO.getLastname());
        person.setAddress(personDTO.getAddress());
        //agregar el campus
        person = this.personService.create(person);
        return person;
    }
    @PutMapping
    public ResponseApi<ItemPerson>  update(@RequestBody PersonDTO personDTO) {
        boolean success = false;
        String message = "Error updating Person";
        Person person = new Person();
        ItemPerson itemPerson = new ItemPerson();
        try{
            person = updatePerson(person, personDTO);
            if(person!=null){
                itemPerson = showPerson(person, itemPerson);
                success = true;
                message = "Person was updated successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemPerson);
    }
    public Person updatePerson(Person person, PersonDTO personDTO){
        person.setActive(personDTO.getActive());
        person.setCompany(personDTO.getCompany());
        person.setDescription(personDTO.getDescription());
        person.setName(personDTO.getName());
        person.setLastname(personDTO.getLastname());
        person.setAddress(personDTO.getAddress());
        //agregar campus
        person = this.personService.update(person);
        return person;
    }
    @GetMapping("/{id}")
    public ResponseApi<ItemPerson> findById(@PathVariable("id") Integer idPerson){
        boolean success = false;
        String message = "No Person found";
        ItemPerson itemPerson = new ItemPerson();
        Person person = personService.findById(idPerson);
        if(person!=null){
            itemPerson = showPerson(person, itemPerson);
            success = true;
            message = "Person found";
        }
        return new ResponseApi<>(success, message, itemPerson);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idPerson){
        personService.delete(idPerson);
    }

    @GetMapping("/{serviceId}")
    public List<Person> getPersonsForService(@PathVariable("serviceId") Integer serviceId){

    }
}

