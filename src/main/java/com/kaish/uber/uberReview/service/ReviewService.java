package com.kaish.uber.uberReview.service;

import com.kaish.uber.dto.entity.ReviewBean;

public interface ReviewService{

    Long createReview(ReviewBean review);

    void updateReview(ReviewBean review);

    void deleteReview(Long reviewId);

    ReviewBean getReview(Long id);
}
