package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Review;
import com.jmletona.ga610.repository.IReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService{
    @Autowired
    private IReviewRepository reviewRepository;

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Review review) {
        Review reviewTMP = findById(review.getIdReview());
        reviewTMP.setRanking(review.getRanking());
        reviewTMP.setStatus((review.getStatus()));
        reviewTMP.setComment(review.getComment());
        return reviewRepository.save(reviewTMP);
    }

    @Override
    public Review findById(Integer id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        return reviewOptional.orElse(null);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        reviewRepository.deleteById(id);
    }
}
