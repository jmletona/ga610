package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Image;
import com.jmletona.ga610.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService  implements  IImageService{

    @Autowired
    private IImageRepository imageRepository;

    @Override
    public Image create(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image update(Image image) {
        Image imageTMP = findById(image.getIdImage());
        imageTMP.setUrl(image.getUrl());
        return imageRepository.save(imageTMP);
    }

    @Override
    public Image findById(Integer id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        return imageOptional.orElse(null);
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        imageRepository.deleteById(id);
    }
}
