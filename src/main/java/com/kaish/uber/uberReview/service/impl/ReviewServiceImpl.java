package com.kaish.uber.uberReview.service.impl;

import com.google.common.base.Preconditions;
import com.kaish.uber.dto.entity.ReviewBean;
import com.kaish.uber.uberReview.domain.entity.Driver;
import com.kaish.uber.uberReview.domain.entity.Review;
import com.kaish.uber.uberReview.repository.ReviewRepository;
import com.kaish.uber.uberReview.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly=true)
public class ReviewServiceImpl implements ReviewService {

    private final ModelMapper mapper;
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ModelMapper mapper, ReviewRepository reviewRepository) {
        this.mapper = mapper;
        this.reviewRepository = reviewRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public Long createReview(ReviewBean reviewBean) {
        Review review = mapper.map(reviewBean, Review.class);
        Driver driver = new Driver();
        driver.setId(reviewBean.getDriverId());
        review.setDriver(driver);
        review = reviewRepository.save(review);
        return review.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void updateReview(ReviewBean reviewBean) {
        Preconditions.checkArgument(reviewBean.getId() != null && reviewBean.getId() > 0, "Review Id can't be null or less than 1");
        Review review = mapper.map(reviewBean, Review.class);
        Driver driver = new Driver();
        driver.setId(reviewBean.getDriverId());
        review.setDriver(driver);
        reviewRepository.save(review);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteReview(Long reviewId) {
        Preconditions.checkArgument(reviewId != null, "Review Id can't be null");
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public ReviewBean getReview(Long id) {
       Optional<Review> review = reviewRepository.findById(id);
       if(review.isEmpty()){
           throw new ObjectRetrievalFailureException(getClass(), id);
       }
       return mapper.map(review.get(), ReviewBean.class);
    }
}
