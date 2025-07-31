package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class ReviewService implements CommandLineRunner {
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;
    //    private final DriverRepository driverRepository;
    private ReviewRepository  reviewRepository;
   public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
       this.reviewRepository = reviewRepository;
       this.bookingRepository = bookingRepository;
//
       this.driverRepository = driverRepository;
   }
    @Override
    public void run(String... args) throws Exception {

            System.out.println("vvvvvvvvvvvvvv");
//            Review r = Review
//                    .builder()
//                    .content("amazing")
//                  .createdAt(new Date())
//                  .updatedAt(new Date())
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

//        Optional<Booking> b1=bookingRepository.findById(4L);
//      if(b1.isPresent()){
//          bookingRepository.delete(b1.get());
//      }
//        List<Driver> drivers=driverRepository.findAll();
//for(Driver driver:drivers){
//    System.out.println(driver.getName());
//}

//        Optional<Driver> driver=driverRepository.findById(1L );
//if(driver.isPresent()){
//    System.out.println(driver.get().getName());
//    List<Booking> b=driver.get().getBookings();
//
//    for(Booking b1:b){
//        System.out.println(b1.getId());
//    }
//    List<Booking> bookings=bookingRepository.findAllByDriverId(1L);
//    for(Booking booking:bookings){
//        System.out.println(booking.getBookingStatus());
//    }
//}
//Optional<Driver> d=driverRepository.rawfindByIDAndLicenseNumber(1L,"Dl1234" );
//        Optional<Driver> d=driverRepository.rawFindByIdAndLicense(1L,"Dl1234");
//System.out.println(d.get().getName());

//for(d.isPresent()){
//    System.out.println(d.get().getLicenseNumber());
//}
    List<Long> driverIds=new ArrayList<>(Arrays.asList(1L,2L));
    List<Driver> drivers=driverRepository.findAllByIdIn(driverIds);
//    List<Booking> bookings=bookingRepository.findAllByDriverIn(drivers);
    for(Driver driver:drivers){
        List<Booking> bookings=driver.getBookings();
        bookings.forEach(booking->System.out.println(booking.getId()));
    }
    }
}
