package com.kaish.uber.uberReview.rest;

import com.kaish.uber.dto.entity.ReviewBean;

public interface ReviewRestService{

    ReviewBean createReview(ReviewBean review);

    ReviewBean updateReview(ReviewBean review);

    void deleteReview(Long id);

    ReviewBean getReview(Long id);
}
