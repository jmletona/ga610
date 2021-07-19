package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.Person;
import com.jmletona.ga610.repository.ICampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampusService implements ICampusService {


    private ICampusRepository campusRepository;
    @Autowired
    public CampusService(ICampusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }

    @Override
    public Campus create(Campus newCampus) {
        return campusRepository.save(newCampus);
    }

    @Override
    public Campus update(Campus campusToUpdate) {
        Campus campus = findById(campusToUpdate.getCampusId());
        campus.setName(campusToUpdate.getName());
        campus.setCountry(campusToUpdate.getCountry());
        campus.setCreatedAt(campusToUpdate.getCreatedAt());

        return campusRepository.save(campus);
    }

    @Override
    public Campus findById(Integer id) {
        Optional<Campus> campusOptional = campusRepository.findById(id);
        return campusOptional.orElse(null);
    }

    @Override
    public List<String> findCountries(){
        return campusRepository.findCountries();
    }

    @Override
    public List<Campus> findAll() {
        return campusRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        campusRepository.deleteById(id);
    }


    public List<Campus> findByCountry(String country){
        return campusRepository.findByCountry(country);
    }
}
