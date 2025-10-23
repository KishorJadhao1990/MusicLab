package com.eao.musiclab.service;

import com.eao.musiclab.bo.SongBO;

import java.util.List;

public interface SongService {
    void save(SongBO songBO);

    SongBO getSong(String id);

    List<SongBO> getSongs();

    SongBO editSong(String id, SongBO songBO);

    void deleteSong(String id);
}
