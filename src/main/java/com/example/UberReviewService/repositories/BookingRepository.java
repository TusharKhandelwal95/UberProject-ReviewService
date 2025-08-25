package com.example.UberReviewService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.UberReviewService.models.Booking;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
