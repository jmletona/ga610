package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Phone;
import com.jmletona.ga610.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService implements IPhoneService{
    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public Phone create(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone update(Phone phone) {
        Phone phoneTMP = findById(phone.getIdPhone());
        phoneTMP.setAreaCode(phone.getAreaCode());
        phoneTMP.setNumber(phone.getNumber());
        phoneTMP.setType(phone.getType());
        return phoneRepository.save(phoneTMP);
    }

    @Override
    public Phone findById(Integer id) {
        Optional<Phone> phoneOptional = phoneRepository.findById(id);
        return phoneOptional.orElse(null);
    }

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        phoneRepository.deleteById(id);
    }
}
