package com.jmletona.ga610.controller;


import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.model.Service;
import com.jmletona.ga610.service.CampusService;
import com.jmletona.ga610.service.PersonService;
import com.jmletona.ga610.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/country/1")
public class HomeController {
    @Autowired
    private CampusService campusService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public List<String> home(Model model, @PathVariable("country") String country){
        List<Campus> allCampus = campusService.findAll();
        List<String> countries = new ArrayList<>();
        for(Campus campus: allCampus){
            if(!countries.contains(campus.getCountry())){
                countries.add(campus.getCountry());
            }
        }
        //model.addAttribute("countries", countries);
        //model.addAttribute("services", services);
        List<Person> allPersons = personService.findAll();
        List<Service> services = new ArrayList<>();

        for(Person person: allPersons){

        }
         //todo servicio que tenga una persona en un campus de country
        return countries;
    }
}
