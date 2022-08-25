package com.codegym.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto {
    private int id;
    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Size(max = 800)
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Vui lòng nhập đúng định dạng!!!")
    private String nameOfSong;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Size(max = 300)
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Vui lòng nhập đúng định dạng!!!")
    private String artistsShow;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Size(max = 1000)
    @Pattern(regexp = "^[A-Za-z0-9 \\,]*$", message = "Vui lòng nhập đúng định dạng!!!")
    private String kindOfMusic;

    public MusicDto() {
    }

    public MusicDto(int id, String nameOfSong, String artistsShow, String kindOfMusic) {
        this.id = id;
        this.nameOfSong = nameOfSong;
        this.artistsShow = artistsShow;
        this.kindOfMusic = kindOfMusic;
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
}
