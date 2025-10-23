package com.eao.musiclab.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "artists")
    private Set<Song> songs;

    @ManyToMany(mappedBy = "artists")
    private Set<Album> albums;

    @ManyToMany
    @JoinTable(
        name = "artist_role",
        joinColumns = @JoinColumn(name = "artist_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(
        name = "artist_follower",
        joinColumns = @JoinColumn(name = "artist_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> followers;

    // getters and setters
}