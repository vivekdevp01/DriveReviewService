package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {
    private final BookingRepository bookingRepository;
    private ReviewRepository  reviewRepository;
   public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
       this.reviewRepository = reviewRepository;
       this.bookingRepository = bookingRepository;
   }
    @Override
    public void run(String... args) throws Exception {

            System.out.println("vvvvvvvvvvvvvv");
//            Review r = Review
//                    .builder()
//                    .content("amazing")
////                    .createdAt(new Date())
////                    .updatedAt(new Date())
//                    .rating(4.8)
//                    .build();
//           Booking b=Booking
//                    .builder()
//                  .review(r)
//                    .endTime(new Date())
//                    .build();
//        bookingRepository.save(b);
//            System.out.println(r);
//            reviewRepository.save(r);
//        List<Review> reviews=reviewRepository.findAll();
//        System.out.println(r.getId());
//        for(Review r1:reviews){
//            System.out.println(r1.getContent());
//        }

        Optional<Booking> b=bookingRepository.findById(4L);
      if(b.isPresent()){
          bookingRepository.delete(b.get());
      }

    }
}
