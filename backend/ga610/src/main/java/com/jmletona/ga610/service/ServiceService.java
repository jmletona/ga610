package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.CampusUser;
import com.jmletona.ga610.model.Service;
import com.jmletona.ga610.repository.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {


    private IServiceRepository serviceRepository;

    @Autowired
    public ServiceService(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service create(Service newService) {
        return serviceRepository.save(newService);
    }

    @Override
    public Service update(Service serviceToUpdate) {
        Service service = findById(serviceToUpdate.getServiceId());
        service.setServiceName(serviceToUpdate.getServiceName());
        service.setCreatedAt(serviceToUpdate.getCreatedAt());

        return serviceRepository.save(service);
    }

    @Override
    public Service findById(Integer id) {
        Optional<Service> campusOptional = serviceRepository.findById(id);
        return campusOptional.orElse(null);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        serviceRepository.deleteById(id);
    }
}
