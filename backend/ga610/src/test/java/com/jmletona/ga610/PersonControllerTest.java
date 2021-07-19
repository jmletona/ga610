package com.jmletona.ga610;

import com.jmletona.ga610.controller.PersonController;
import com.jmletona.ga610.item.ItemPerson;
import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.repository.IPersonRepository;
import com.jmletona.ga610.responses.ResponseApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class PersonControllerTest {
    private PersonController personController;
    @Autowired
    private IPersonRepository personRepository;

    @BeforeEach
    public void setup(){
        personController = new PersonController();
    }

    /*@Test
    @GetMapping("/tests/1")
    public void shouldReturnNull(){
        ResponseApi<ItemPerson> response = personController.findById(0);
        Assertions.assertFalse(response.getSuccess());
    }*/

    /*@Test
    public void testing(){
        Assertions.assertFalse(!personRepository.findById(0).isPresent());
    }*/
}
