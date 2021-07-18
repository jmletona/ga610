package com.jmletona.ga610.controller;

import com.jmletona.ga610.item.ItemListService;
import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.model.Review;
import com.jmletona.ga610.model.Service;
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

import java.text.DecimalFormat;
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

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{country}")
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
    }
    @GetMapping("/{country}/service/{idService}")
    public String getAllPerson(Model model, @PathVariable("country") String country, @PathVariable("idService") Integer idService){
        List<Person> allPersons = personService.findAll();
        List<ItemListService> personServiceList = new ArrayList<>();
        for (Person person : allPersons){
            if(person.getServices().contains(serviceService.findById(idService)) && campusService.findById(person.getIdCampus()).getCountry().equals(country)){
                ItemListService personUpgrade = new ItemListService();
                personUpgrade.setIdPerson(person.getIdPerson());
                personUpgrade.setCompany(person.getCompany());
                personUpgrade.setLastname(person.getLastname());
                personUpgrade.setName(person.getName());
                personUpgrade.setRanking(getRanking(person.getIdPerson()));
                personServiceList.add(personUpgrade);
            }
        }
        model.addAttribute("lista", personServiceList);
        model.addAttribute("service", serviceService.findById(idService));
        model.addAttribute("country", country);
        return "list-person";
    }
    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public String getRanking(Integer idPerson){

        double ranking = 0;
        Integer counter = 0;
        List<Review> allReviews= reviewService.findAll();
        for(Review review: allReviews){
            if(review.getIdPerson().equals(idPerson) && review.getStatus().equals("APPROVED")){
                counter++;
                System.out.println("ranking" + review.getRanking() + " status"+ review.getStatus());
                switch (review.getRanking()){
                    case "POOR":
                        ranking +=1;
                        break;
                    case "FAIR":
                        ranking +=2;
                        break;
                    case "GOOD":
                        ranking +=3;
                        break;
                    case "VERY GOOD":
                        ranking +=4;
                        break;
                    case "EXCELLENT":
                        ranking +=5;
                        break;
                    default:
                        break;
                }
            }
        }
        if(counter!=0){
            ranking = ranking / counter;
        }
        return df2.format(ranking);
    }
}
