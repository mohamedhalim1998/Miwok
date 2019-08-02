package com.example.android.miwok;

public class Word {
    private String miwok;
    private String english;
    private int imageId;
    private int wordSoundId;

    public Word(String english, String miwok, int wordSoundId) {
        this.miwok = miwok;
        this.english = english;
        this.imageId = 0;
        this.wordSoundId = wordSoundId;
    }

    public Word(String english, String miwok, int imageId, int wordSoundId) {
        this.miwok = miwok;
        this.english = english;
        this.imageId = imageId;
        this.wordSoundId = wordSoundId;
    }

    public String getMiwok() {
        return miwok;
    }

    public String getEnglish() {
        return english;
    }

    public int getImageId() {
        return imageId;
    }

    public int getWordSoundId() {
        return wordSoundId;
    }
}
