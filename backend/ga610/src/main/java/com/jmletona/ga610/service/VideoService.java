package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Video;
import com.jmletona.ga610.repository.IVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService implements IVideoService{
    @Autowired
    private IVideoRepository videoRepository;

    @Override
    public Video create(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video update(Video video) {
        Video videoTMP = findById(video.getIdVideo());
        videoTMP.setUrl(video.getUrl());
        return videoRepository.save(videoTMP);
    }

    @Override
    public Video findById(Integer id) {
        Optional<Video> videoOptional = videoRepository.findById(id);
        return videoOptional.orElse(null);
    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        videoRepository.deleteById(id);
    }
}
