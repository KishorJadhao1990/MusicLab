package com.eao.musiclab.service.impl;

import com.eao.musiclab.bo.SongBO;
import com.eao.musiclab.framework.BizException;
import com.eao.musiclab.model.*;
import com.eao.musiclab.repository.*;
import com.eao.musiclab.service.SongService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private SongRepository songRepository;

    @Override
    public void saveSong(SongBO songBO) {
        if (StringUtils.isEmpty(songBO.getTitle())
                || StringUtils.isEmpty(songBO.getArtist())
                || Objects.isNull(songBO.getDuration())){
            throw new BizException("Song title, artist and duration can't be empty.");
        }
        Song song = new Song();
        if (!StringUtils.isEmpty(songBO.getAlbum())) {
            Optional<Album> existedAlbum = albumRepository.findByAlbum(songBO.getAlbum());
            if (existedAlbum.isEmpty()) {
                Album album = Album.builder().name(songBO.getAlbum()).releaseDate(LocalDate.now()).build();
                Album savedAlbum = albumRepository.save(album);
                song.setAlbumId(savedAlbum.getId());
            } else {
                song.setAlbumId(existedAlbum.get().getId());
            }
        }
        Artist artist = artistRepository.findByUsername(songBO.getArtist());
        song.setArtistId(artist.getId());
        Genre genre = genreRepository.findByName(songBO.getGenre());
        song.setGenreId(genre.getId());
        song.setSize(songBO.getSize());
        song.setTitle(songBO.getTitle());
        song.setDuration(songBO.getDuration());
        songRepository.save(song);
    }

    @Override
    public SongBO getSong(String id) {
        return songRepository.findById(Integer.valueOf(id)).map(this::buildFrom).orElse(null);
    }

    @Override
    public List<SongBO> getSongs() {
        return songRepository.findAll().stream().map(this::buildFrom).toList();
    }

    @Override
    public SongBO editSong(String id, SongBO songBO) {
        Optional<Song> songOpt = songRepository.findById(Integer.valueOf(id));
        if (songOpt.isEmpty()) {
            throw new BizException("Song not found");
        }
        Song song = songOpt.get();
        song.setTitle(songBO.getTitle());
        Song updatedSong = songRepository.save(song);
        return buildFrom(updatedSong);
    }

    @Override
    public void deleteSong(String id) {
        Optional<Song> songOpt = songRepository.findById(Integer.valueOf(id));
        if (songOpt.isEmpty()) {
            throw new BizException("Song not found");
        }
        songRepository.delete(songOpt.get());
    }

    private SongBO buildFrom(Song song) {
        Optional<Artist> artistOpt = artistRepository.findById(song.getArtistId());
        Optional<Action> actionOpt = actionRepository.findById(song.getActionId());
        Optional<Genre> genreOpt = genreRepository.findById(song.getGenreId());
        Optional<Album> albumOpt = albumRepository.findById(song.getAlbumId());

        return SongBO.builder().title(song.getTitle()).fileUrl(song.getFileUrl())
                .album(albumOpt.map(Album::getName).orElse(null))
                .artist(artistOpt.map(Artist::getFirstname).orElse(null))
                .genre(genreOpt.map(Genre::getName).orElse(null))
                .action(String.valueOf(actionOpt.map(Action::getType).orElse(null)))
                .duration(song.getDuration()).size(song.getSize()).build();
    }
}
