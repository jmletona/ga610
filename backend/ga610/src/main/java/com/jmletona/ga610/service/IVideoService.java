package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Video;

import java.util.List;

public interface IVideoService {

    Video create(Video video);

    Video update(Video video);

    Video findById(Integer id);

    List<Video> findAll();

    void delete(Integer id);
}
