package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;
    private DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
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

//        Optional<Booking> fetchedBooking = bookingRepository.findById(2L);
//        if(fetchedBooking.isPresent()){
//            bookingRepository.delete(fetchedBooking.get());
//        }

//        Optional<Driver> fetchedDriver = driverRepository.findByIdAndLicenseNumber(1L, "DL123456");
//        if(fetchedDriver.isPresent()){
//            Driver driver = fetchedDriver.get();
//            System.out.println("Driver Name: " + driver.getName());
//            List<Booking> bookings = driver.getBookings(); // LAZY loading happens here
//            for(Booking booking: bookings){
//                System.out.println(booking.getId());
//            }
//        }

        Optional<Driver> fetchedDriver = driverRepository.hqlFindByIdAndLicenseNumber(1L, "DL123456");
        System.out.println(fetchedDriver.get().getName());
    }
}
