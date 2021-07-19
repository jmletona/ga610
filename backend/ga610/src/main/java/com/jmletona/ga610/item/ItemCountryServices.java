package com.jmletona.ga610.item;

import com.jmletona.ga610.model.Service;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemCountryServices implements IItem{
    List<String> countryList;
    String currentCountry;
    List<Service> services;
}
