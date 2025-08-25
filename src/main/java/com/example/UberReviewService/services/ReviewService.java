package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.print("********************************");

//        Review r = Review
//                .builder()
//                .content("Great ride!")
//                .rating(4.5)
//                .build();
//
//
////        reviewRepository.save(r); // this code execute sql queries
////
////        System.out.println(r.getId());
//
//        Booking b = Booking
//                .builder()
//                .review(r) // setting the review object to the booking object
//                .build();
//
//        bookingRepository.save(b); // this code execute sql queries

        Optional<Booking> fetchedBooking = bookingRepository.findById(2L);
        if(fetchedBooking.isPresent()){
            bookingRepository.delete(fetchedBooking.get());
        }





    }
}
