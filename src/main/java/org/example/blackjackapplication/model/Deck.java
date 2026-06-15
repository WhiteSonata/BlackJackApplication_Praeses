package org.example.blackjackapplication.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        Collections.shuffle(cards);
    }

    private void initializeDeck() {
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                int value;

                if (rank.equals("Ace")) {
                    value = 11;
                } else if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
                    value = 10;
                } else {
                    value = Integer.parseInt(rank);
                }

                cards.add(new Card(suit, rank, value));
            }
        }
    }

    public Card drawCard() {
        return cards.remove(0);
    }
}