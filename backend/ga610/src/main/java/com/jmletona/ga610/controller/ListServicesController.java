package com.jmletona.ga610.controller;

import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.repository.IPersonRepository;
import com.jmletona.ga610.service.CampusService;
import com.jmletona.ga610.service.PersonService;
import com.jmletona.ga610.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ListServicesController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private CampusService campusService;


    /*public List<Person> getAllPerson(@PathVariable("country") String country, @PathVariable("idService") Integer idService){
        System.out.println(country + " " + idService);
        List<Person> allPersons = personService.findAll();
        List<Person> personServiceList = new ArrayList<>();
        System.out.println(allPersons.size());
        for (Person person : allPersons){
            if(person.getServices().contains(serviceService.findById(idService)) && campusService.findById(person.getIdCampus()).getCountry().equals(country)){
                personServiceList.add(person);
            }
        }
        return personServiceList;
    }*/
    @GetMapping("/services/{country}/{idService}")
    public String getAllPerson(Model model, @PathVariable("country") String country, @PathVariable("idService") Integer idService){
        System.out.println(country + " " + idService);
        List<Person> allPersons = personService.findAll();
        List<Person> personServiceList = new ArrayList<>();
        System.out.println(allPersons.size());
        for (Person person : allPersons){
            if(person.getServices().contains(serviceService.findById(idService)) && campusService.findById(person.getIdCampus()).getCountry().equals(country)){
                personServiceList.add(person);
            }
        }
        System.out.println(personServiceList);
        model.addAttribute("lista", personServiceList);
        return "list-person";
    }

}
