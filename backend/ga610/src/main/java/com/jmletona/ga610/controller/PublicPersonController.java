package com.jmletona.ga610.controller;

import com.jmletona.ga610.item.ItemPublicPerson;
import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.PersonService;
import com.jmletona.ga610.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
            System.out.println("VIDEOS");
            publicPerson.setVideos(person.getVideoList());
            System.out.println("SOCIAL NETWORKS");
            publicPerson.setSocialNetworks(person.getSocialNetworkList());
            publicPerson.setCreated(person.getCreated().toString());
            publicPerson.setGallery(getGallery(person.getIdPerson()));
            publicPerson.setReviews(reviewService.findByIdPersonAndStatus(person.getIdPerson(), "APPROVED"));
        }

        return new ResponseApi<>(success, message, !success ? null : publicPerson);
    }

    private List<String> getGallery(Integer idPerson){
        String sourcePath = "src/main/resources/persons/"+idPerson;
        List<File> files = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();
        File f = new File(sourcePath);
        if (f.exists()) {
            if (f.isDirectory()){
                //fileNames = new ArrayList<>(Arrays.asList(Objects.requireNonNull(f.list()))); //Just the file names
                files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(f.listFiles())));
            }
        }

        for (File file : files){
            fileNames.add(file.getPath());
        }

        return fileNames;
    }
}
