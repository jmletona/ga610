package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.CampusUser;
import com.jmletona.ga610.repository.ICampusUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampusUserService implements ICampusUserService {

    @Autowired
    private ICampusUserRepository campusUserRepository;




    public CampusUserService(ICampusUserRepository campusUserRepository) {
        this.campusUserRepository = campusUserRepository;
    }

    @Override
    public CampusUser create(CampusUser newCampusUser) {
        return campusUserRepository.save(newCampusUser);
    }

    @Override
    public CampusUser update(CampusUser campusUserToUpdate) {
        CampusUser camapusUser = findById(campusUserToUpdate.getUserId());
        camapusUser.setFullName(campusUserToUpdate.getFullName());
        camapusUser.setEmail(campusUserToUpdate.getEmail());
        camapusUser.setCreatedAt(campusUserToUpdate.getCreatedAt());
        camapusUser.setUserPassword(campusUserToUpdate.getUserPassword());
        camapusUser.setUserRole(campusUserToUpdate.getUserRole());
        camapusUser.setCampus(campusUserToUpdate.getCampus());
        return campusUserRepository.save(camapusUser);
    }

    @Override
    public CampusUser findById(Integer id) {
        Optional<CampusUser> campusOptional = campusUserRepository.findById(id);
        return campusOptional.orElse(null);
    }

    @Override
    public List<CampusUser> findAll() {
        return campusUserRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        campusUserRepository.deleteById(id);
    }
}
