package com.jmletona.ga610.item;

import com.jmletona.ga610.model.CampusUser;
import com.jmletona.ga610.model.Person;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
public class ItemCampus {
    private Integer campusId;
    private String name;
    private String country;
    private String createdAt;
}
