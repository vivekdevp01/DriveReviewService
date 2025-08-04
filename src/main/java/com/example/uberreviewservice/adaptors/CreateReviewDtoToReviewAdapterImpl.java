package com.example.uberreviewservice.adaptors;

import com.example.uberreviewservice.dtos.CreateReviewDto;
import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter{

    private BookingRepository  bookingRepository;
    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {
        Optional<Booking> booking=bookingRepository.findById(createReviewDto.getBookingId());
        if(booking.isEmpty()){
            return null;
        }
        Review review=Review.builder()
                .rating(createReviewDto.getRating())
                .booking(booking.get())
                .content(createReviewDto.getContent())
                .build();
        return review;
    }
}
