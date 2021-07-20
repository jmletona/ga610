package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.VideoDTO;
import com.jmletona.ga610.item.ItemVideo;
import com.jmletona.ga610.model.Video;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.PersonService;
import com.jmletona.ga610.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseApi<List<ItemVideo>> getAllVideos(){
        boolean success = false;
        String message = "No Video found";
        List<ItemVideo> itemVideoList = new ArrayList<>();
        List<Video> videoList = videoService.findAll();
        if(!videoList.isEmpty()){
            success = true;
            message = "Video found";
            itemVideoList = showAllVideos(videoList, itemVideoList);
        }
        return new ResponseApi<>(success, message, itemVideoList);
    }

    public List<ItemVideo> showAllVideos(List<Video> videoList, List<ItemVideo> itemVideoList){
        for(Video video : videoList) {
            ItemVideo itemVideo = new ItemVideo();
            itemVideoList.add(showVideo(video, itemVideo));
        }
        return itemVideoList;
    }

    public ItemVideo showVideo(Video video, ItemVideo itemVideo){
        itemVideo.setCreated(video.getCreated().toString());
        itemVideo.setIdPerson(video.getIdPerson().toString());
        itemVideo.setIdVideo(video.getIdVideo());
        itemVideo.setUrl(video.getUrl());
        return itemVideo;
    }

    @PostMapping
    public ResponseApi<ItemVideo> create(@RequestBody VideoDTO videoDTO){
        boolean success = false;
        String message = "Error";
        Video video = new Video();
        ItemVideo itemVideo = new ItemVideo();
        try {
            video = createVideo(video, videoDTO);
            if (video != null){
                itemVideo = showVideo(video, itemVideo);

                success = true;
                message = "Video created successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemVideo);
    }

    public Video createVideo(Video video, VideoDTO videoDTO){
        video.setCreated(Timestamp.from(Instant.now()));
        video.setIdPerson(videoDTO.getIdPerson());
        video.setUrl(videoDTO.getUrl());
        return videoService.create(video);
    }

    @PutMapping
    public ResponseApi<ItemVideo> update(@RequestBody VideoDTO videoDTO){
        boolean success = false;
        String message = "Error updating video";
        Video video = new Video();
        ItemVideo itemVideo = new ItemVideo();
        try {
            video = updateVideo(video, videoDTO);
            if (video != null){
                itemVideo = showVideo(video, itemVideo);
                success = true;
                message = "Video updated successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemVideo);
    }

    public Video updateVideo(Video video, VideoDTO videoDTO){
        video.setIdVideo(videoDTO.getIdVideo());
        video.setUrl(videoDTO.getUrl());
        return videoService.update(video);
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemVideo> findById(@PathVariable("id") Integer idVideo){
        boolean success = false;
        String message = "No video found";
        ItemVideo itemVideo = new ItemVideo();
        Video video = videoService.findById(idVideo);
        if (video != null){
            success = true;
            message = "Video found";
            itemVideo = showVideo(video, itemVideo);
        }
        return new ResponseApi<>(success, message, itemVideo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idVideo){
        videoService.delete(idVideo);
    }
}
