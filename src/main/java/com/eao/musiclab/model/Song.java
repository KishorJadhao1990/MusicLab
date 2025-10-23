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
@Table(name = "song", catalog = "musiclab")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song-seq")
    @SequenceGenerator(name = "song-seq", sequenceName = "song-seq", allocationSize = 1)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "size")
    private Integer size;

    @Column(name = "artist_id")
    private Integer artistId;

    @Column(name = "genre_id")
    private Integer genreId;

    @Column(name = "album_id")
    private Integer albumId;      // can be null if song doesn't belong to album

    @Column(name = "action_id")
    private Integer actionId;     // can be null if song have no like/dislike

}