package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Review;

import java.util.List;

public interface IReviewService {

    Review create(Review review);

    Review update(Review review);

    Review findById(Integer id);

    List<Review> findAll();

    List<Review> findByIdPersonAndStatus(Integer idPerson, String status);

    void delete(Integer id);
}
