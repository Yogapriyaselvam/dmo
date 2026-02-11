package com.edupath.edupath_ai.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    private String department;
    private String password;
    private int solvedCount = 0;
    private int score = 0;

    // 1. Mandatory Empty Constructor
    public User() {}

    // 2. Full Constructor
    public User(Long id, String name, String email, String department, String password, int solvedCount, int score) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.password = password;
        this.solvedCount = solvedCount;
        this.score = score;
    }

    // 3. Getters and Setters (Manual)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getSolvedCount() { return solvedCount; }
    public void setSolvedCount(int solvedCount) { this.solvedCount = solvedCount; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}