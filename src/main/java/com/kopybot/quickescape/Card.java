package com.kopybot.quickescape;

import java.util.List;

enum Suite {
    Clubs, Diamonds, Hearts, Spades, SmallJoker, BigJoker
}
public class Card {
    private Suite suite;
    private int value;

    public Card(Suite suite, int value) {
        this.suite = suite;
        this.value = value;
    }

    public Suite getSuite() {
        return suite;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return suite + "-" + value;
    }

    public static String toString(List<Card> cards){
        StringBuffer sb = new StringBuffer();
        for (Card card: cards) {
            sb.append(card);
            sb.append('\n');
        }
        return sb.toString();
    }
}
