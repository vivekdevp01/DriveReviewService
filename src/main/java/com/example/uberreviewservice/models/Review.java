package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;

@Entity
@Table(name = "booking_review")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Double rating;



  @Override
    public String toString() {
      return "Review"+this.content+" "+this.rating+" "+this.createdAt;
  }
//    private String content;
//
//    private String createdOn;
//
//    private String modifiedOn;
}
