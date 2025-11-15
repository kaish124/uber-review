package com.kaish.uber.userReview.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.kaish.uber.userReview.domain.embeddable.Name;
import com.kaish.uber.userReview.domain.entity.Booking;
import com.kaish.uber.userReview.domain.entity.Driver;
import com.kaish.uber.userReview.domain.entity.Review;
import com.kaish.uber.userReview.domain.enums.BookingStatus;
import com.kaish.uber.userReview.repository.BookingRepository;
import com.kaish.uber.userReview.repository.DriverRepository;
import com.kaish.uber.userReview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Review review = new Review();
        review.setContent("good service");
        review.setRating(4.3);

        Booking booking = new Booking();
        booking.setReview(review);
        booking.setStatus(BookingStatus.SCHEDULED);
        booking.setStartTime(Instant.now());
        booking.setEndTime(Instant.now().plus(30, ChronoUnit.MINUTES));
        booking.setTotalDuration(Duration.between(booking.getStartTime(), booking.getEndTime()));
        booking.setTotalDistance(3555L);

        Name name = new Name();
        name.setFirstName("John");
        name.setLastName("Doe");
        name.setPreferredName("Jonny");
        Driver driver = new Driver();
        driver.setName(name);
        driver.setEmail("afasf@askfnk.com");
        driver.setPhoneNumber("9349-5-2");
        driver.setLicenseNumber("dfa98sdf0a9f9asdff");
        review.setDriver(driver);
        driver.getReviews().add(review);

        driverRepository.save(driver);

//        bookingRepository.save(booking);
    }
}
