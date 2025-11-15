package com.kaish.uber.userReview.service;

import com.kaish.uber.userReview.domain.entity.PassengerReview;
import com.kaish.uber.userReview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        PassengerReview passengerReview = new PassengerReview();
        passengerReview.setContent("good service");
        passengerReview.setRating(4.3);
        passengerReview.setPassengerReviewContent("sdflasdf ahsldf");
        passengerReview.setPassengerReviewRating(3.4);

        reviewRepository.save(passengerReview);
    }
}
