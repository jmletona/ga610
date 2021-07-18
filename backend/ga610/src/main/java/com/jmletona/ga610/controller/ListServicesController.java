package com.jmletona.ga610.controller;

import com.jmletona.ga610.item.ItemCountryServices;
import com.jmletona.ga610.item.ItemListService;
import com.jmletona.ga610.item.ItemServicePersons;
import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.model.Review;
import com.jmletona.ga610.model.Service;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.CampusService;
import com.jmletona.ga610.service.PersonService;
import com.jmletona.ga610.service.ReviewService;
import com.jmletona.ga610.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ListServicesController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private CampusService campusService;

    @Autowired
    private ReviewService reviewService;

    /*@GetMapping("/{country}")
    public String getAllServices(Model model, @PathVariable("country") String country){
        List<String> countries = new ArrayList<>();
        List<Campus> allCampus = campusService.findAll();
        for(Campus campus : allCampus){
            if(!countries.contains(campus.getCountry())){
                countries.add(campus.getCountry());
                System.out.println(campus.getCountry());
            }
        }

        List<Service> allServices = serviceService.findAll();
        model.addAttribute("countries", countries);
        model.addAttribute("services", allServices);
        model.addAttribute("country", country);

        return "list-services";
    }*/

    @GetMapping("/{country}")
    public ResponseApi<ItemCountryServices> getServicesByCountry(@PathVariable(name = "country") String country){
        boolean success = false;
        String message = "No services found";

        ItemCountryServices countryServices = new ItemCountryServices();
        countryServices.setCountryList(campusService.findCountries());
        countryServices.setCurrentCountry(country);
        countryServices.setServices(serviceService.findByCountry(country));

        if(countryServices.getServices().size() > 0){
            success = true;
            message = "Services found";
        }

        return new ResponseApi<>(success, message, countryServices);
    }

    @GetMapping("/{country}/service/{idService}")
    public ResponseApi<ItemServicePersons> getAllPerson(Model model, @PathVariable("country") String country, @PathVariable("idService") Integer idService){
        boolean success = false;
        String message = "No persons found";
        List<ItemListService> personServiceList = new ArrayList<>();

        for (Person p : personService.findByCountryAndService(country, idService)){
            ItemListService personItem = new ItemListService();
            personItem.setIdPerson(p.getIdPerson());
            personItem.setName(p.getName());
            personItem.setLastname(p.getLastname());
            personItem.setCompany(p.getCompany());
            personItem.setRanking(getAvgRanking(p.getIdPerson()));
            personServiceList.add(personItem);
        }

        if (personServiceList.size() > 0){
            success = true;
            message = "Found " + personServiceList.size() + " records";
        }

        ItemServicePersons servicePersons = new ItemServicePersons();
        servicePersons.setService(serviceService.findById(idService));
        servicePersons.setCountry(country);
        servicePersons.setPersons(personServiceList);

        return new ResponseApi<>(success, message, servicePersons);
    }

    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public String getAvgRanking(Integer idPerson){
        List<Review> personReviews = reviewService.findByIdPersonAndStatus(idPerson, "APPROVED");

        Map<String, Integer> values = new LinkedHashMap<>();
        values.put("POOR", 1);
        values.put("FAIR", 2);
        values.put("GOOD", 3);
        values.put("VERY GOOD", 4);
        values.put("EXCELLENT", 5);

        float sum = 0;

        for(Review r : personReviews){
            sum += values.get(r.getRanking());
        }

        return personReviews.size() == 0 ? "0.0" : df2.format(sum / personReviews.size());
    }
}
