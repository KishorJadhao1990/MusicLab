package com.eao.musiclab.service.impl;

import com.eao.musiclab.bo.SongBO;
import com.eao.musiclab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Override
    public void save(SongBO songBO) {

    }

    @Override
    public SongBO getSong(String id) {
        return null;
    }

    @Override
    public List<SongBO> getSongs() {
        return List.of();
    }

    @Override
    public SongBO editSong(String id, SongBO songBO) {
        return null;
    }

    @Override
    public void deleteSong(String id) {

    }
}
