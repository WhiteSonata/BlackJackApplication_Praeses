package org.example.blackjackapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getValue() {
        int total = 0;
        int aces = 0;

        for (Card card : cards) {
            total += card.getValue();

            if (card.getRank().equals("Ace")) {
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    public boolean isBusted() {
        return getValue() > 21;
    }

    public boolean hasBlackjack() {
        return cards.size() == 2 && getValue() == 21;
    }
}