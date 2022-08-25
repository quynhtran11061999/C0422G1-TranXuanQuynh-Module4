package com.codegym.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MusicDto {
    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Size(max = 800)
    private String nameOfSong;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Size(max = 300)
    private String artistsShow;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Size(max = 1000)
    private String kindOfMusic;

    public MusicDto() {
    }

    public MusicDto(String nameOfSong, String artistsShow, String kindOfMusic) {
        this.nameOfSong = nameOfSong;
        this.artistsShow = artistsShow;
        this.kindOfMusic = kindOfMusic;
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
}
