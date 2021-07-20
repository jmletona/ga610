package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.*;
import com.jmletona.ga610.item.ItemPerson;
import com.jmletona.ga610.item.ItemPersonCrud;
import com.jmletona.ga610.model.*;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.*;
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

    @Autowired
    private CampusService campusService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private SocialNetworkService socialNetworkService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private PersonServiceService personServiceService;

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
        itemPerson.setIdCampus(person.getIdCampus().toString());
        itemPerson.setVideos(person.getVideoList());
        itemPerson.setPhones(person.getPhoneList());
        itemPerson.setSocialNetworks(person.getSocialNetworkList());
        if (person.getCreated() != null) itemPerson.setCreated(person.getCreated().toString());
        itemPerson.setGallery(person.getImageList());
        return itemPerson;
    }

    @GetMapping("/new")
    public ResponseApi<ItemPersonCrud> setupCreate(){
        ItemPersonCrud personCrud = new ItemPersonCrud();
        personCrud.setCampusList(campusService.findAll());
        personCrud.setPhoneTypes(phoneService.findPhoneTypes());
        personCrud.setSocialNetworkTypes(socialNetworkService.findSocialNetworkTypes());
        personCrud.setServiceList(serviceService.findAll());

        return new ResponseApi<>(true, "Data retrieved", personCrud);
    }

    @PostMapping("/new")
    public ResponseApi<ItemPerson> create(@RequestBody PersonCrudDTO personCrudDTO){
        boolean success = false;
        String message = "Error";
        Person person = new Person();
        ItemPerson itemPerson = new ItemPerson();
        try{
            person=createPerson(person, personCrudDTO.getPerson());
            if(person!=null){
                for (VideoDTO v : personCrudDTO.getVideos()){
                    Video video = new Video();
                    video.setUrl(v.getUrl());
                    video.setIdPerson(person.getIdPerson());
                    videoService.create(video);
                }

                for (PhoneDTO p : personCrudDTO.getPhones()){
                    Phone phone = new Phone();
                    phone.setAreaCode(p.getAreaCode());
                    phone.setNumber(p.getNumber());
                    phone.setType(p.getPhoneType());
                    phone.setIdPerson(person.getIdPerson());
                    phoneService.create(phone);
                }

                for (SocialNetworkDTO sn : personCrudDTO.getSocialNetworks()){
                    SocialNetwork socialNetwork = new SocialNetwork();
                    socialNetwork.setIdPerson(person.getIdPerson());
                    socialNetwork.setUrl(sn.getUrl());
                    socialNetwork.setType(sn.getType());
                    socialNetworkService.create(socialNetwork);
                }

                for (ServiceDTO s : personCrudDTO.getServices()){
                    com.jmletona.ga610.model.PersonService personServiceModel = new com.jmletona.ga610.model.PersonService();
                    personServiceModel.setIdService(s.getServiceId());
                    personServiceModel.setIdPerson(person.getIdPerson());
                    personServiceService.create(personServiceModel);
                }

                for (ImageDTO i : personCrudDTO.getGallery()){
                    Image image = new Image();
                    image.setUrl(i.getUrlImage());
                    image.setIdPerson(person.getIdPerson());
                    imageService.create(image);
                }

                itemPerson = showPerson(personService.findById(person.getIdPerson()), itemPerson);
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
        person.setIdCampus(personDTO.getIdCampus());
        person = this.personService.create(person);
        return person;
    }

    @GetMapping("/update/{idPerson}")
    public ResponseApi<ItemPersonCrud> setupUpdate(@PathVariable(name = "idPerson") Integer idPerson){
        boolean success = false;
        String message = "Person not found";

        ItemPersonCrud personCrud = new ItemPersonCrud();
        Person person = personService.findById(idPerson);

        if (person != null){
            success = true;
            message = "Person found";
            personCrud.setPerson(showPerson(person, new ItemPerson()));
        }

        personCrud.setCampusList(campusService.findAll());
        personCrud.setPhoneTypes(phoneService.findPhoneTypes());
        personCrud.setSocialNetworkTypes(socialNetworkService.findSocialNetworkTypes());
        personCrud.setServiceList(serviceService.findAll());

        return new ResponseApi<>(success, message, personCrud);
    }

    @PutMapping("/update/{idPerson}")
    public ResponseApi<ItemPerson> update(@RequestBody PersonCrudDTO personCrudDTO) {
        boolean success = false;
        String message = "Error updating Person";
        Person person = new Person();
        ItemPerson itemPerson = new ItemPerson();
        try{
            person = updatePerson(person, personCrudDTO.getPerson());
            if(person!=null){
                itemPerson = showPerson(person, itemPerson);
                success = true;
                message = "Person was updated successfully";

                for (VideoDTO v : personCrudDTO.getVideos()){
                    Video video = new Video();
                    video.setIdVideo(v.getIdVideo());
                    video.setUrl(v.getUrl());
                    video.setIdPerson(person.getIdPerson());
                    videoService.update(video);
                }

                for (PhoneDTO p : personCrudDTO.getPhones()){
                    Phone phone = new Phone();
                    phone.setIdPhone(p.getIdPhone());
                    phone.setAreaCode(p.getAreaCode());
                    phone.setNumber(p.getNumber());
                    phone.setType(p.getPhoneType());
                    phone.setIdPerson(person.getIdPerson());
                    phoneService.update(phone);
                }

                for (SocialNetworkDTO sn : personCrudDTO.getSocialNetworks()){
                    SocialNetwork socialNetwork = new SocialNetwork();
                    socialNetwork.setIdSocialNetwork(sn.getIdSocialNetwork());
                    socialNetwork.setIdPerson(person.getIdPerson());
                    socialNetwork.setUrl(sn.getUrl());
                    socialNetwork.setType(sn.getType());
                    socialNetworkService.update(socialNetwork);
                }

                for (ImageDTO i : personCrudDTO.getGallery()){
                    Image image = new Image();
                    image.setIdImage(i.getIdImage());
                    image.setUrl(i.getUrlImage());
                    image.setIdPerson(person.getIdPerson());
                    imageService.update(image);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemPerson);
    }

    public Person updatePerson(Person person, PersonDTO personDTO){
        person.setIdPerson(personDTO.getIdPerson());
        person.setActive(personDTO.getActive());
        person.setCompany(personDTO.getCompany());
        person.setDescription(personDTO.getDescription());
        person.setName(personDTO.getName());
        person.setLastname(personDTO.getLastname());
        person.setAddress(personDTO.getAddress());
        person.setIdCampus(personDTO.getIdCampus());
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
}

