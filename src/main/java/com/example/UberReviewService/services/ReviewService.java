package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.print("********************************");

        Review r = Review
                .builder()
                .content("Great ride!")
                .rating(4.5)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        System.out.println(r);

        reviewRepository.save(r); // this code execute sql queries

    }
}
