package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.PhoneDTO;
import com.jmletona.ga610.item.ItemPhone;
import com.jmletona.ga610.model.Phone;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

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
        for(Phone phone : phoneList)
            itemPhoneList.add(showPhone(phone));
        return itemPhoneList;
    }

    public ItemPhone showPhone(Phone phone){
        ItemPhone itemPhone = new ItemPhone();
        itemPhone.setIdPhone(phone.getIdPhone());
        itemPhone.setAreaCode(String.valueOf(phone.getAreaCode()));
        itemPhone.setNumber(String.valueOf(phone.getNumber()));
        itemPhone.setType(phone.getType());
        return itemPhone;
    }

    @PostMapping
    public ResponseApi<ItemPhone> create(@RequestBody PhoneDTO phoneDTO){
        boolean success = false;
        String message = "Error";
        ItemPhone itemPhone = new ItemPhone();
        try {
            Phone phone = createPhone(phoneDTO);
            if (phone != null){
                itemPhone = showPhone(phone);
                success = true;
                message = "Phone created successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemPhone);
    }

    public Phone createPhone(PhoneDTO phoneDTO){
        Phone phone = new Phone();
        phone.setAreaCode(phoneDTO.getAreaCode());
        phone.setNumber(phoneDTO.getNumber());
        phone.setType(phoneDTO.getType());
        return phoneService.create(phone);
    }

    @PutMapping
    public ResponseApi<ItemPhone> update(@RequestBody PhoneDTO phoneDTO){
        boolean success = false;
        String message = "Error updating phone";
        ItemPhone itemPhone = new ItemPhone();
        try {
            Phone phone = updatePhone(phoneDTO);
            if (phone != null){
                itemPhone = showPhone(phone);
                success = true;
                message = "Phone updated successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemPhone);
    }

    public Phone updatePhone(PhoneDTO phoneDTO){
        Phone phone = new Phone();
        phone.setAreaCode(phoneDTO.getAreaCode());
        phone.setNumber(phoneDTO.getNumber());
        phone.setType(phoneDTO.getType());
        return phoneService.update(phone);
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemPhone> findById(@PathVariable("id") Integer idPhone){
        boolean success = false;
        String message = "No Person found";
        ItemPhone itemPhone = new ItemPhone();
        Phone phone = phoneService.findById(idPhone);
        if (phone != null){
            success = true;
            message = "Phone found";
            itemPhone = showPhone(phone);
        }
        return new ResponseApi<>(success, message, itemPhone);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idPhone){
        phoneService.delete(idPhone);
    }
}
