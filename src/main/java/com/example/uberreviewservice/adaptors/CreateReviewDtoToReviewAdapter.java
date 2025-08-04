package com.example.uberreviewservice.adaptors;

import com.example.uberreviewservice.dtos.CreateReviewDto;
import com.example.uberreviewservice.models.Review;

public interface CreateReviewDtoToReviewAdapter {

    public Review convertDto(CreateReviewDto createReviewDto);
}
