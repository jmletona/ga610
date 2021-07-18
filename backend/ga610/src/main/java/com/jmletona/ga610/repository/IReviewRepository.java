package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByIdPersonAndStatus(Integer idPerson, String status);
}
