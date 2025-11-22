package com.kaish.uber.uberReview.repository;

import com.kaish.uber.uberReview.domain.entity.Driver;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @EntityGraph(attributePaths = {"bookings"})
    Set<Driver> findAllByIdIn(Set<Long> ids);
}
