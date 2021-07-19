package com.jmletona.ga610.item;

import com.jmletona.ga610.model.Service;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemServicePersons implements IItem{
    private Service service;
    private String country;
    private List<ItemListService> persons;
}
