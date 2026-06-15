package org.example.blackjackapplication.model;

public class BlackJackApplication {

    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private String message;
    private boolean gameOver;

    public BlackJackApplication() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        message = "Choose hit or stand.";
        gameOver = false;

        dealInitialCards();
    }

    private void dealInitialCards() {
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public String getMessage() {
        return message;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void hit() {
        if (gameOver) {
            message = "This round is complete. Start a new game by hitting rest.";
            return;
        }

        playerHand.addCard(deck.drawCard());

        if (playerHand.getValue() > 21) {
            message = "You busted! Dealer wins.";
            gameOver = true;
        } else {
            message = "You drew a card. Would you like to hit or stand?";
        }
    }

    public void stand() {
        if (gameOver) {
            message = "This round is complete. Start a new game by hitting rest.";
            return;
        }

        while (dealerHand.getValue() < 17) {
            dealerHand.addCard(deck.drawCard());
        }

        int playerTotal = playerHand.getValue();
        int dealerTotal = dealerHand.getValue();

        if (dealerTotal > 21) {
            message = "Dealer busted. You win!";
        } else if (playerTotal > dealerTotal) {
            message = "You win!";
        } else if (dealerTotal > playerTotal) {
            message = "Dealer wins.";
        } else {
            message = "Push. It's a tie.";
        }

        gameOver = true;
    }
}