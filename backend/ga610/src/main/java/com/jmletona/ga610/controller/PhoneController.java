package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.PhoneDTO;
import com.jmletona.ga610.item.ItemPhone;
import com.jmletona.ga610.model.Phone;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public ResponseApi<List<ItemPhone>> getAllPhones(){
        boolean success = false;
        String message = "No Phone found";
        List<ItemPhone> itemPhoneList = new ArrayList<>();
        List<Phone> phoneList = phoneService.findAll();
        if(!phoneList.isEmpty()){
            success = true;
            message = "Phone found";
            itemPhoneList = showAllPhones(phoneList, itemPhoneList);
        }
        return new ResponseApi<>(success, message, itemPhoneList);
    }

    public List<ItemPhone> showAllPhones(List<Phone> phoneList, List<ItemPhone> itemPhoneList){
        for(Phone phone : phoneList){
            ItemPhone itemPhone = new ItemPhone();
            itemPhone = showPhone(phone, itemPhone);
            itemPhoneList.add(itemPhone);
        }
        return itemPhoneList;
    }

    public ItemPhone showPhone(Phone phone, ItemPhone itemPhone){
        itemPhone.setIdPhone(phone.getIdPhone());
        itemPhone.setAreaCode(String.valueOf(phone.getAreaCode()));
        itemPhone.setNumber(String.valueOf(phone.getNumber()));
        itemPhone.setType(phone.getType());
        itemPhone.setIdPerson(phone.getIdPerson());
        itemPhone.setUpdated(phone.getUpdated().toString());
        return itemPhone;
    }

    @PostMapping
    public ResponseApi<ItemPhone> create(@RequestBody PhoneDTO phoneDTO){
        boolean success = false;
        String message = "Error";
        Phone phone = new Phone();
        ItemPhone itemPhone = new ItemPhone();
        try {
            phone = createPhone(phone, phoneDTO);
            if (phone != null){
                itemPhone = showPhone(phone, itemPhone);
                success = true;
                message = "Phone created successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemPhone);
    }

    public Phone createPhone(Phone phone, PhoneDTO phoneDTO){
        phone.setAreaCode(phoneDTO.getAreaCode());
        phone.setNumber(phoneDTO.getNumber());
        phone.setType(phoneDTO.getPhoneType());
        phone.setIdPerson(phoneDTO.getIdPerson());
        phone.setUpdated(Timestamp.from(Instant.now()));
        return phoneService.create(phone);
    }

    @PutMapping
    public ResponseApi<ItemPhone> update(@RequestBody PhoneDTO phoneDTO){
        boolean success = false;
        String message = "Error updating phone";
        Phone phone = new Phone();
        ItemPhone itemPhone = new ItemPhone();
        try {
            phone = updatePhone(phone, phoneDTO);
            if (phone != null){
                itemPhone = showPhone(phone, itemPhone);
                success = true;
                message = "Phone updated successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemPhone);
    }

    public Phone updatePhone(Phone phone, PhoneDTO phoneDTO){
        phone.setIdPhone(phoneDTO.getIdPhone());
        phone.setAreaCode(phoneDTO.getAreaCode());
        phone.setNumber(phoneDTO.getNumber());
        phone.setType(phoneDTO.getPhoneType());
        return phoneService.update(phone);
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemPhone> findById(@PathVariable("id") Integer idPhone){
        boolean success = false;
        String message = "No Phone found";
        ItemPhone itemPhone = new ItemPhone();
        Phone phone = phoneService.findById(idPhone);
        if (phone != null){
            success = true;
            message = "Phone found";
            itemPhone = showPhone(phone, itemPhone);
        }
        return new ResponseApi<>(success, message, itemPhone);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idPhone){
        phoneService.delete(idPhone);
    }
}
