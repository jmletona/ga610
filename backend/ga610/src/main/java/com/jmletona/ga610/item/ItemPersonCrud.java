package com.jmletona.ga610.item;

import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.model.Service;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemPersonCrud implements IItem{
    private ItemPerson person;
    private List<Campus> campusList;
    private List<String> phoneTypes;
    private List<String> socialNetworkTypes;
    private List<Service> serviceList;
}
