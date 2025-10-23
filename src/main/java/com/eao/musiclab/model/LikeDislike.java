package com.eao.musiclab.model;

import jakarta.persistence.*;

@Entity
public class LikeDislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        LIKE, DISLIKE
    }

    // getters and setters
}