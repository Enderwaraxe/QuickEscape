package com.kopybot.quickescape;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }
    public void takeCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return name +":\n" + Card.toString(hand);
    }
}
