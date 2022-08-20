package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MusicForm {
    private int id;
    private String nameOfSong;
    private String artistsShow;
    private String kindOfMusic;
    private MultipartFile songFilePath;

    public MusicForm() {
    }

    public MusicForm(String nameOfSong, String artistsShow, String kindOfMusic, MultipartFile songFilePath) {
        this.nameOfSong = nameOfSong;
        this.artistsShow = artistsShow;
        this.kindOfMusic = kindOfMusic;
        this.songFilePath = songFilePath;
    }

    public MusicForm(int id, String nameOfSong, String artistsShow, String kindOfMusic, MultipartFile songFilePath) {
        this.id = id;
        this.nameOfSong = nameOfSong;
        this.artistsShow = artistsShow;
        this.kindOfMusic = kindOfMusic;
        this.songFilePath = songFilePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }

    public String getArtistsShow() {
        return artistsShow;
    }

    public void setArtistsShow(String artistsShow) {
        this.artistsShow = artistsShow;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public MultipartFile getSongFilePath() {
        return songFilePath;
    }

    public void setSongFilePath(MultipartFile songFilePath) {
        this.songFilePath = songFilePath;
    }
}
