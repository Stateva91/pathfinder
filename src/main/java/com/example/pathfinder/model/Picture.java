package com.example.pathfinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    private User author;

    @OneToOne(mappedBy = "header")
    private Route route;
}
