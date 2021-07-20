package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Image;

import java.util.List;

public interface IImageService {

    Image create(Image image);

    Image update(Image image);

    Image findById(Integer id);

    List<Image> findAll();

    void delete(Integer id);

}
