package com.jmletona.ga610.controller;


import com.jmletona.ga610.dto.CampusDTO;
import com.jmletona.ga610.dto.ServiceDTO;
import com.jmletona.ga610.item.ItemCampus;
import com.jmletona.ga610.item.ItemService;
import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.Service;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/campus")
public class CampusController {

    @Autowired
    private CampusService serviceCampus;

    @GetMapping
    public ResponseApi<List<ItemCampus>> getAllServices() {
        boolean success = false;
        String message = "No Campus found";
        List<ItemCampus> itemCampusList = new ArrayList<>();
        List<Campus> campusList = serviceCampus.findAll();
        if (!campusList.isEmpty()) {
            success = true;
            message = "Campus found";
            itemCampusList = showAllCampuses(campusList, itemCampusList);
        }
        return new ResponseApi<>(success, message, itemCampusList);
    }

    public List<ItemCampus> showAllCampuses(List<Campus> campusList, List<ItemCampus> itemCampusList) {
        for (Campus campus : campusList) {
            ItemCampus itemCampus = new ItemCampus();
            itemCampus = showCampus(campus, itemCampus);
            itemCampusList.add(itemCampus);
        }
        return itemCampusList;
    }

    public ItemCampus showCampus(Campus campus, ItemCampus itemCampus) {
        itemCampus.setCampusId(campus.getCampusId());
        itemCampus.setName(campus.getName());
        itemCampus.setCountry(campus.getCountry());
        itemCampus.setCreatedAt(campus.getCreatedAt());
        itemCampus.setPeople(campus.getPeople());
        itemCampus.setUsers(campus.getUsers());
        return itemCampus;
    }

    @PostMapping
    public ResponseApi<ItemCampus> create(@RequestBody CampusDTO campusDTO) {
        boolean success = false;
        String message = "Error";
        Campus campus = new Campus();
        ItemCampus itemCampus = new ItemCampus();
        try {
            campus = createCampus(campus, campusDTO);
            if (campus != null) {
                itemCampus = showCampus(campus, itemCampus);
                success = true;
                message = "Campus was created successfully";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemCampus);
    }

    public Campus createCampus(Campus campus, CampusDTO campusDTO) {

        campus.setCampusId(campusDTO.getCampusId());
        campus.setName(campusDTO.getName());
        campus.setCountry(campusDTO.getCountry());
        campus.setCreatedAt(campusDTO.getCreatedAt());
        campus = this.serviceCampus.create(campus);
        return campus;
    }

    @PutMapping
    public ResponseApi<ItemCampus> update(@RequestBody CampusDTO campusDTO) {
        boolean success = false;
        String message = "Error updating Service";
        Campus campus = new Campus();
        ItemCampus itemCampus = new ItemCampus();
        try {
            campus = updateCampus(campus, campusDTO);
            if (campus != null) {
                itemCampus = showCampus(campus, itemCampus);
                success = true;
                message = "Campus was updated successfully";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemCampus);
    }

    public Campus updateCampus(Campus campus, CampusDTO campusDTO) {
        campus.setName(campusDTO.getName());
        campus.setCountry(campusDTO.getCountry());
        campus.setCreatedAt(campusDTO.getCreatedAt());


        campus = this.serviceCampus.update(campus);
        return campus;
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemCampus> findById(@PathVariable("id") Integer campusId) {
        boolean success = false;
        String message = "No Campus found";
        ItemCampus itemCampus = new ItemCampus();
        Campus campus = serviceCampus.findById(campusId);
        if (campus != null) {
            itemCampus = showCampus(campus, itemCampus);
            success = true;
            message = "Campus found";
        }
        return new ResponseApi<>(success, message, itemCampus);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer campusId) {
        serviceCampus.delete(campusId);
    }
}
