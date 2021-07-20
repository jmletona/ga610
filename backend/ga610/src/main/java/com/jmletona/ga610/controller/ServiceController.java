package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.ServiceDTO;
import com.jmletona.ga610.item.ItemService;
import com.jmletona.ga610.model.Service;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public ResponseApi<List<ItemService>> getAllServices() {
        boolean success = false;
        String message = "No Service found";
        List<ItemService> itemServiceList = new ArrayList<>();
        List<Service> serviceList = serviceService.findAll();
        if (!serviceList.isEmpty()) {
            success = true;
            message = "Service found";
            itemServiceList = showAllServices(serviceList, itemServiceList);
        }
        return new ResponseApi<>(success, message, itemServiceList);
    }

    public List<ItemService> showAllServices(List<Service> serviceList, List<ItemService> itemServiceList) {
        for (Service service : serviceList) {
            ItemService itemService = new ItemService();
            itemService = showService(service, itemService);
            itemServiceList.add(itemService);
        }
        return itemServiceList;
    }

    public ItemService showService(Service service, ItemService itemService) {
        itemService.setServiceId(service.getServiceId());
        itemService.setServiceName(service.getServiceName());
        itemService.setUrlImage(service.getUrlImage());
        itemService.setCreatedAt(service.getCreatedAt().toString());
        return itemService;
    }

    @PostMapping
    public ResponseApi<ItemService> create(@RequestBody ServiceDTO serviceDTO) {
        boolean success = false;
        String message = "Error";
        Service service = new Service();
        ItemService itemService = new ItemService();
        try {
            service = createService(service, serviceDTO);
            if (service != null) {
                itemService = showService(service, itemService);
                success = true;
                message = "Service was created successfully";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemService);
    }

    public Service createService(Service service, ServiceDTO serviceDTO) {
        service.setServiceName(serviceDTO.getServiceName());
        service.setCreatedAt(Timestamp.from(Instant.now()));
        service.setUrlImage(serviceDTO.getUrlImage());
        service = this.serviceService.create(service);
        return service;
    }

    @PutMapping
    public ResponseApi<ItemService> update(@RequestBody ServiceDTO serviceDTO) {
        boolean success = false;
        String message = "Error updating Service";
        Service service = new Service();
        ItemService itemService = new ItemService();
        try {
            service = updateService(service, serviceDTO);
            if (service != null) {
                itemService = showService(service, itemService);
                success = true;
                message = "Service was updated successfully";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemService);
    }

    public Service updateService(Service service, ServiceDTO serviceDTO) {
        service.setServiceId(serviceDTO.getServiceId());
        service.setServiceName(serviceDTO.getServiceName());
        service.setUrlImage(serviceDTO.getUrlImage());
        return serviceService.update(service);
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemService> findById(@PathVariable("id") Integer serviceId) {
        boolean success = false;
        String message = "No Service found";
        ItemService itemService = new ItemService();
        Service service = serviceService.findById(serviceId);
        if (service != null) {
            itemService = showService(service, itemService);
            success = true;
            message = "Service found";
        }
        return new ResponseApi<>(success, message, itemService);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer serviceId) {
        serviceService.delete(serviceId);
    }
}
