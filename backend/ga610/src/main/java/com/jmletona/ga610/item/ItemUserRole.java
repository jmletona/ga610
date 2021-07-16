package com.jmletona.ga610.item;

import com.jmletona.ga610.model.CampusUser;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class ItemUserRole {

    private Integer roleId;
    private String roleType;
    private List<CampusUser> users;
}
