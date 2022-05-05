package com.codegym.model;

public class Song {
    private String songName;
    private String artist;
    private int kindOfMusicId;
    private String filePath;

    public Song() {
    }

    public Song(String songName, String artist, int kindOfMusicId, String filePath) {
        this.songName = songName;
        this.artist = artist;
        this.kindOfMusicId = kindOfMusicId;
        this.filePath = filePath;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getKindOfMusicId() {
        return kindOfMusicId;
    }

    public void setKindOfMusicId(int kindOfMusicId) {
        this.kindOfMusicId = kindOfMusicId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
