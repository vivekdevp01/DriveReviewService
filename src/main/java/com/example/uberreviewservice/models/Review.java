package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "bookingreview")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EnableJpaAuditing
public class Review {

    @Id  //this annotation make this id primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    private Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

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
