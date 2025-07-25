package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewService implements CommandLineRunner {
   private ReviewRepository  reviewRepository;
   public ReviewService(ReviewRepository reviewRepository) {
       this.reviewRepository = reviewRepository;
   }
    @Override
    public void run(String... args) throws Exception {

            System.out.println("vvvvvvvvvvvvvv");
            Review r = Review
                    .builder()
                    .content("amazing")
//                    .createdAt(new Date())
//                    .updatedAt(new Date())
                    .rating(3.5)
                    .build();
            System.out.println(r);
            reviewRepository.save(r);


    }
}
