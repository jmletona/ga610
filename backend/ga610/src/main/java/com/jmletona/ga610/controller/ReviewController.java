package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.ReviewDTO;
import com.jmletona.ga610.item.ItemReview;
import com.jmletona.ga610.model.Review;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseApi<List<ItemReview>> getAllReviews(){
        boolean success = false;
        String message = "No Review found";
        List<ItemReview> itemReviewList = new ArrayList<>();
        List<Review> reviewList = reviewService.findAll();
        if(!reviewList.isEmpty()){
            success = true;
            message = "Review found";
            itemReviewList = showAllReviews(reviewList, itemReviewList);
        }
        return new ResponseApi<>(success, message, itemReviewList);
    }

    public List<ItemReview> showAllReviews(List<Review> reviewList, List<ItemReview> itemReviewList){
        for(Review review : reviewList)
            itemReviewList.add(showReview(review));
        return itemReviewList;
    }

    public ItemReview showReview(Review review){
        ItemReview itemReview = new ItemReview();
        itemReview.setIdReview(review.getIdReview());
        itemReview.setRanking(review.getRanking());
        itemReview.setStatus(review.getStatus());
        itemReview.setComment(review.getComment());
        itemReview.setPerson(review.getIdPerson().toString());
        itemReview.setUser(review.getIdUser().toString());
        if (review.getCreated() != null) itemReview.setCreated(review.getCreated().toString());
        return itemReview;
    }

    @PostMapping
    public ResponseApi<ItemReview> create(@RequestBody ReviewDTO reviewDTO){
        boolean success = false;
        String message = "Error";
        ItemReview itemReview = new ItemReview();
        try {
            Review review = createReview(reviewDTO);
            if (review != null){
                itemReview = showReview(review);
                success = true;
                message = "Review created successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemReview);
    }

    public Review createReview(ReviewDTO reviewDTO){
        Review review = new Review();
        review.setRanking(reviewDTO.getRanking());
        review.setStatus(reviewDTO.getStatus());
        review.setComment(reviewDTO.getComment());
        review.setIdPerson(reviewDTO.getIdPerson());
        review.setIdUser(reviewDTO.getIdUser());
        return reviewService.create(review);
    }

    @PutMapping
    public ResponseApi<ItemReview> update(@RequestBody ReviewDTO reviewDTO){
        boolean success = false;
        String message = "Error updating review";
        ItemReview itemReview = new ItemReview();
        try {
            Review review = updateReview(reviewDTO);
            if (review != null){
                itemReview = showReview(review);
                success = true;
                message = "Review updated successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemReview);
    }

    public Review updateReview(ReviewDTO reviewDTO){
        Review review = new Review();
        review.setRanking(reviewDTO.getRanking());
        review.setStatus(reviewDTO.getStatus());
        review.setComment(reviewDTO.getComment());
        //agregar persona
        //agregar user
        return reviewService.update(review);
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemReview> findById(@PathVariable("id") Integer idReview){
        boolean success = false;
        String message = "No review found";
        ItemReview itemReview = new ItemReview();
        Review review = reviewService.findById(idReview);
        if (review != null){
            success = true;
            message = "Review found";
            itemReview = showReview(review);
        }
        return new ResponseApi<>(success, message, itemReview);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idReview){
        reviewService.delete(idReview);
    }
}
