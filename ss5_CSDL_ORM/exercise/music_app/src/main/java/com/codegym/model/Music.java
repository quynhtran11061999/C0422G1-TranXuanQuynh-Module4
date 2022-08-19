package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_of_song")
    private String nameOfSong;
    @Column(name = "artists_show")
    private String artistsShow;
    @Column(name = "kind_of_music")
    private String kindOfMusic;
    @Column(name = "song_file_path")
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
