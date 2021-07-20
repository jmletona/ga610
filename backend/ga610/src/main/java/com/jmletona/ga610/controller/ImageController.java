package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.ImageDTO;
import com.jmletona.ga610.item.ItemImage;
import com.jmletona.ga610.model.Image;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.ImageService;
import com.jmletona.ga610.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/img")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseApi<List<ItemImage>> getAllImages(){
        boolean success = false;
        String message = "No Image found";
        List<ItemImage> itemImageList = new ArrayList<>();
        List<Image> imageList = imageService.findAll();
        if(!imageList.isEmpty()){
            success = true;
            message = "Video found";
            itemImageList = showAllVideos(imageList, itemImageList);
        }
        return new ResponseApi<>(success, message, itemImageList);
    }

    public List<ItemImage> showAllVideos(List<Image> imageList, List<ItemImage> itemImageList){
        for(Image image : imageList) {
            ItemImage itemImage = new ItemImage();
            itemImageList.add(showImage(image, itemImage));
        }
        return itemImageList;
    }
    public ItemImage showImage(Image image, ItemImage itemImage){
        itemImage.setUpdated(image.getUpdated().toString());
        itemImage.setIdPerson(image.getIdPerson().toString());
        itemImage.setIdImage(image.getIdImage());
        itemImage.setUrlImage(image.getUrl());
        return itemImage;
    }
    @PostMapping
    public ResponseApi<ItemImage> create(@RequestBody ImageDTO imageDTO){

        boolean success = false;
        String message = "Error";
        Image image = new Image();
        ItemImage itemImage = new ItemImage();
        try {
            image = createImage(image, imageDTO);
            if (image != null){
                itemImage = showImage(image, itemImage);

                success = true;
                message = "Image created successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemImage);
    }

    public Image createImage(Image image, ImageDTO imageDTO){
        image.setUpdated(Timestamp.from(Instant.now()));
        image.setIdPerson(imageDTO.getIdPerson());
        image.setUrl(imageDTO.getUrlImage());
        return imageService.create(image);
    }

    @PutMapping
    public ResponseApi<ItemImage> update(@RequestBody ImageDTO imageDTO){
        boolean success = false;
        String message = "Error updating image";
        Image image = new Image();
        ItemImage itemImage = new ItemImage();
        try {
            image = updateImage(image, imageDTO);
            if (image != null){
                itemImage = showImage(image, itemImage);
                success = true;
                message = "Image updated successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemImage);
    }

    public Image updateImage(Image image, ImageDTO imageDTO){
        image.setIdImage(imageDTO.getIdImage());
        image.setUrl(imageDTO.getUrlImage());
        return imageService.update(image);
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemImage> findById(@PathVariable("id") Integer idImage){
        boolean success = false;
        String message = "No image found";
        ItemImage itemImage = new ItemImage();
        Image image = imageService.findById(idImage);
        if (image != null){
            success = true;
            message = "Image found";
            itemImage = showImage(image, itemImage);
        }
        return new ResponseApi<>(success, message, itemImage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idImage){
        imageService.delete(idImage);
    }


}
