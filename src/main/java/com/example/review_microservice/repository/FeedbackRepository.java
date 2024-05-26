package com.example.review_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.review_microservice.Models.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    
}
