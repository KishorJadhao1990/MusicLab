package com.eao.musiclab.api;

import com.eao.musiclab.bo.SongBO;
import com.eao.musiclab.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/song")
public class SongApi {

    @Autowired
    private SongService songService;

    @PostMapping
    public ResponseEntity<String> createSong(@RequestBody SongBO songBO) {
        songService.save(songBO);
        return ResponseEntity.ok("Song created successfully.");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SongBO> editSongInfo(@PathVariable String id,
                                               @RequestBody SongBO songBO) {
        SongBO updatedSongBo = songService.editSong(id, songBO);
        return ResponseEntity.ok(updatedSongBo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteSong(@PathVariable String id) {
        songService.deleteSong(id);
        return ResponseEntity.ok("Song deleted successfully.");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SongBO> getSong(@PathVariable String id) {
        SongBO songBO = songService.getSong(id);
        return ResponseEntity.ok(songBO);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<SongBO>> getSongList() {
        List<SongBO> songBO = songService.getSongs();
        return ResponseEntity.ok(songBO);
    }
}