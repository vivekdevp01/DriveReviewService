package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.FetchNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements  ReviewService{
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) throws EntityNotFoundException {
        Optional<Review> review;
        try{
            review=this.reviewRepository.findById(id);
            if(review.isEmpty()){
                throw new EntityNotFoundException("Review with id"+id+"not found");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            if(e.getClass()==EntityNotFoundException.class){
                throw new FetchNotFoundException("Review with id"+id+"not found",id);
            }
            throw new FetchNotFoundException("Unable to fetch review with id"+id+"",id);
        }
        return review;
    }

    @Override
    public List<Review> findAllReviews() {
        return this.reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id) {
        try{
            Review review=this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            this.reviewRepository.delete(review);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public Review publishReview(Review review) {
       return this.reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review newReview) {
      Review review=this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
      if(newReview.getRating()!=null){
          review.setRating(newReview.getRating());
      }
      if(newReview.getContent()!=null){
          review.setContent(newReview.getContent());
      }
      return this.reviewRepository.save(review);
    }



}
