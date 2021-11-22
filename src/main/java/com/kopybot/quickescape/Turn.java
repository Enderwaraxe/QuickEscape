package com.kopybot.quickescape;

public class Turn {
    public static Turn PASS = new Turn(0,0);

    private int numCards;
    private int cardVal;

    public Turn(int numCards, int cardVal) {
        this.numCards = numCards;
        this.cardVal = cardVal;
    }

    public int getNumCards() {
        return numCards;
    }

    public int getCardVal() {
        return cardVal;
    }

    @Override
    public String toString() {
        return "Turn{" +
                "numCards=" + numCards +
                ", cardVal=" + cardVal +
                '}';
    }
}
