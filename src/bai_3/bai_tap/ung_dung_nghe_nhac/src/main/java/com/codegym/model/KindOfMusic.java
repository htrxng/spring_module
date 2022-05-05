package com.codegym.model;

public class KindOfMusic {
    private int kindOfMusicId;
    private String kindOfMusic;

    public KindOfMusic() {
    }

    public KindOfMusic(int kindOfMusicId, String kindOfMusic) {
        this.kindOfMusicId = kindOfMusicId;
        this.kindOfMusic = kindOfMusic;
    }

    public int getKindOfMusicId() {
        return kindOfMusicId;
    }

    public void setKindOfMusicId(int kindOfMusicId) {
        this.kindOfMusicId = kindOfMusicId;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
