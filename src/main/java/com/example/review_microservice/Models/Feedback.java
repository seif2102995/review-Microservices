package com.example.review_microservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "feedback", nullable = false)
    private String comments;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "mail", nullable = false)
    private String mail;


    public Feedback() {
    }

    public Feedback(int id, String comments, int rating, String mail) {
        this.id = id;
        this.comments = comments;
        this.rating = rating;
        this.mail = mail;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Feedback id(int id) {
        setId(id);
        return this;
    }

    public Feedback comments(String comments) {
        setComments(comments);
        return this;
    }

    public Feedback rating(int rating) {
        setRating(rating);
        return this;
    }

    public Feedback mail(String mail) {
        setMail(mail);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Feedback)) {
            return false;
        }
        Feedback feedback = (Feedback) o;
        return id == feedback.id && Objects.equals(comments, feedback.comments) && rating == feedback.rating && Objects.equals(mail, feedback.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comments, rating, mail);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", comments='" + getComments() + "'" +
            ", rating='" + getRating() + "'" +
            ", mail='" + getMail() + "'" +
            "}";
    }
   
}
