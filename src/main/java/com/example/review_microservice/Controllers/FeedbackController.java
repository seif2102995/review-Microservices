package com.example.review_microservice.Controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.review_microservice.Models.Feedback;
import com.example.review_microservice.repository.FeedbackRepository;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;
    
      @GetMapping("")
    public ResponseEntity getFeedbacks(){
        List<Feedback> feedbacks= this.feedbackRepository.findAll(); 
        return new ResponseEntity(feedbacks, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity createPost(@RequestBody Map<String,String> body){
        Feedback feedback = new Feedback(); 
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###########################################" +body);
        feedback.setComments(body.get("comments")); 
        feedback.setMail(body.get("mail"));
        int rate = Integer.parseInt(body.get("rating"));
        feedback.setDate(LocalDate.now()); 
        feedback.setRating(rate);
        this.feedbackRepository.save(feedback); 
        System.out.println(body);
        return new ResponseEntity(feedback, HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteFeedback(@RequestBody Map<String, Integer> body) {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###########################################" + body);
        int id = body.get("id");
        feedbackRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
