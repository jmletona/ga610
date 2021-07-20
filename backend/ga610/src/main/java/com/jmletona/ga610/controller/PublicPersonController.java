package com.jmletona.ga610.controller;

import com.jmletona.ga610.item.ItemPublicPerson;
import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.PersonService;
import com.jmletona.ga610.service.ReviewService;
import com.jmletona.ga610.util.FileSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PublicPersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/person/{idPerson}")
    public ResponseApi<ItemPublicPerson> getPersonDetails(@PathVariable(name = "idPerson") Integer idPerson){
        boolean success = false;
        String message = "No person found";
        Person person = personService.findById(idPerson);
        ItemPublicPerson publicPerson = new ItemPublicPerson();

        if (person != null){
            success = true;
            message = "Person found";
            publicPerson.setIdPerson(person.getIdPerson());
            publicPerson.setActive(person.getActive());
            publicPerson.setName(person.getName());
            publicPerson.setLastname(person.getLastname());
            publicPerson.setAddress(person.getAddress());
            publicPerson.setCampus(person.getIdCampus().toString());
            publicPerson.setCompany(person.getCompany());
            publicPerson.setDescription(person.getDescription());
            publicPerson.setVideos(person.getVideoList());
            publicPerson.setSocialNetworks(person.getSocialNetworkList());
            publicPerson.setPhones(person.getPhoneList());
            publicPerson.setCreated(person.getCreated().toString());
            publicPerson.setGallery(FileSearch.getGallery("src/main/resources/persons/"+person.getIdPerson()));
            publicPerson.setReviews(reviewService.findByIdPersonAndStatus(person.getIdPerson(), "APPROVED"));
        }

        return new ResponseApi<>(success, message, !success ? null : publicPerson);
    }
}
