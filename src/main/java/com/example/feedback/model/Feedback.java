package com.example.feedback.model;

import javax.persistence.*;

@Table(name = "feedback")
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int id;

    @Column(name = "ratings")
    int rating;

    @Column(name = "user")
    String user;

    @Column(name = "feedback")
    String comments;

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public String getUser() {
        return user;
    }

    public String getComments() {
        return comments;
    }

}
