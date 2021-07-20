package com.jmletona.ga610.item;

import com.jmletona.ga610.model.CampusUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class ItemUserRole {

    private Integer roleId;
    private String roleType;

}
