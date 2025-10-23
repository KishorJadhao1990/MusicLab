package com.eao.musiclab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author kishor
 * Created on 23/10/2025
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "genre", catalog = "musiclab")
public class Genre {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private GenreType type;

    public enum GenreType {
        CLASSICAL, ROCK, POP, JAZZ
    }
}