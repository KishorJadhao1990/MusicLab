package com.eao.musiclab.bo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SongBO implements Serializable {

    private String title;
    private String album;
    private String artist;
    private String genre;
    private String action;
    private Integer size;
    private Integer duration;
    private String fileUrl;

}
