package com.example.sampleramwar;


import java.util.Random;

public class PlayingCard {
    private int rank;

    public PlayingCard(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public boolean beats(PlayingCard otherCard) {
        return this.getRank() > otherCard.getRank();
    }

    public String getNameForRank(String format) {
        return String.format(format, rank);
    }

    public static PlayingCard drawRandomCard() {
        int randomRank = new Random().nextInt(13) + 2;
        return new PlayingCard(randomRank);
    }

    public boolean isTie(PlayingCard otherCard) {
        return this.getRank() == otherCard.getRank();
    }
}
