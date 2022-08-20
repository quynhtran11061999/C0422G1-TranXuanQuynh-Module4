package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Music {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nameOfSong;
    private String artistsShow;
    private String kindOfMusic;
    private String songFilePath;

    public Music() {
    }

    public Music(int id, String nameOfSong, String artistsShow, String kindOfMusic, String songFilePath) {
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

    public String getSongFilePath() {
        return songFilePath;
    }

    public void setSongFilePath(String songFilePath) {
        this.songFilePath = songFilePath;
    }
}
