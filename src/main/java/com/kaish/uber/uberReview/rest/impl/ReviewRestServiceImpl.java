package com.kaish.uber.uberReview.rest.impl;

import com.kaish.uber.dto.entity.ReviewBean;
import com.kaish.uber.uberReview.rest.ReviewRestService;
import com.kaish.uber.uberReview.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services/review")
public class ReviewRestServiceImpl implements ReviewRestService {

    private final ReviewService reviewService;

    @Autowired
    public ReviewRestServiceImpl(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewBean createReview(@RequestBody ReviewBean review) {
         Long id = reviewService.createReview(review);
         return reviewService.getReview(id);
    }

    @Override
    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ReviewBean updateReview(ReviewBean review) {
        reviewService.updateReview(review);
        return reviewService.getReview(review.getId());
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReview(@PathVariable("id") Long id) {
       reviewService.deleteReview(id);
    }

    @Override
    @GetMapping("/{id}")
    public ReviewBean getReview(@PathVariable("id") Long id) {
        return reviewService.getReview(id);
    }
}
