package com.jmletona.ga610.controller;


import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.Country;
import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.model.Service;
import com.jmletona.ga610.repository.ICountryRepository;
import com.jmletona.ga610.repository.IServiceRepository;
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
@RequestMapping("/country")
public class HomeController {

    @Autowired
    private IServiceRepository service;

    @Autowired
    private ICountryRepository countryService;

    @GetMapping("/get/{country}")
    public List<Service> home(@PathVariable("country") Integer country){
        return service.onFetchServices(country);
    }

    @GetMapping("/all")
    public List<Country> getAllCountries(){
        return countryService.findAll();
    }
}
