package com.example.uberreviewservice.dtos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CreateReviewDto {

    private  String content;

    private Double rating;

    private Long bookingId;
}
