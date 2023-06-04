package com.example.fifth_test.beans;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Topic topic;
    private int score;

    public Grade() {
    }

    public Grade(Topic topic, int score) {
        this.topic = topic;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
