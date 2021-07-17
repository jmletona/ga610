package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.CampusUser;

import java.util.List;

public interface ICampusUserService {
    CampusUser create(CampusUser newCampusUser);

    CampusUser update(CampusUser campusUserToUpdate);

    CampusUser findById(Integer id);

    List<CampusUser> findAll();

    void delete(Integer id);
}
