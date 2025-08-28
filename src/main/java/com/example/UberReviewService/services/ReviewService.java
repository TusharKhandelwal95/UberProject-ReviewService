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

import java.util.*;


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
    @Transactional
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

        /*
        * Handling N+1 problem
        * Suppose for a list of driver id we have to find bookings for all of them
        * So we would make 1 call to get all driver data then we will make N calls for each driver's booking
        *
        * To prevent it we can
        * 1..  Get all driver(1 call) --> get booking of all drivers using join(2nd call)
        * 2.. Get all driver(1 call) --> then use @fetch in driver class then use loop.
        * also make function @Transactional so that session is open till the end of function
        * */
        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        List<Driver> drivers = driverRepository.findByIdIn(driverIds);

//        1..
//        List<Booking> bookings = bookingRepository.findAllByDriverIn(drivers);
//        2..
        for(Driver driver : drivers){
            List<Booking> bookings = driver.getBookings(); // LAZY loading happens here but no n+1 problem because of @Fetch
            System.out.println(driver.getName() + " : " + bookings.size() + " bookings.");
            bookings.forEach(booking -> System.out.println(booking.getId()));
        }
    }
}
