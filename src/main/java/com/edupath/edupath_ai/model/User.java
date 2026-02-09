package com.edupath.edupath_ai.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String department;
    private String password;
    private int solvedCount = 0;
private int score = 720;
}
// Inside your User.java model


// Add Getters and Setters for these two fields!