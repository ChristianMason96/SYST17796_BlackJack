/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;



/**
 *
 * @author Mario
 */

public class Blackjack extends Game {
    private Deck deck;
    private BlackjackDealer dealer;
    private ArrayList<BlackjackPlayer> players;

    public Blackjack(String name) {
        super(name);
    }

    public void initializePlayers(int playerCount) {
        deck = new Deck(312); // Assuming a 6-deck shoe (6 * 52 cards)
        dealer = new BlackjackDealer();
        players = new ArrayList<>(playerCount);

        //gives players unique identifier
        for (int i = 1; i <= playerCount; i++) {
            players.add(new BlackjackPlayer("Player " + i));
        }
        deck.shuffle();
    }

    public boolean dealerHasBlackjack() {
        return dealer.hasBlackjack();
    }

    //deals first 2 cards to everybody
    public void dealInitialCards() {
        // Deal one card to each player
        for (BlackjackPlayer player : players) {
            player.hit(deck);
        }
        //changed card dealing order to reflect casino tables
        // Deal one card to the dealer
        dealer.dealerHit(deck);
        // Deal second card to each player
        for (BlackjackPlayer player : players) {
            player.hit(deck);
        }
        // Deal second card to the dealer
        dealer.dealerHit(deck);

        // Check if the dealer has blackjack and end the round if true
        if (dealerHasBlackjack()) {
            System.out.println("Dealer has blackjack!");
            declareWinner();
            return;
        }
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public Deck getDeck() {
        return deck;
    }

    public BlackjackDealer getDealer() {
        return dealer;
    }

    @Override
    public void declareWinner() {
        System.out.println("Dealer's full hand:");
        dealer.showHand();
        
        
        for (BlackjackPlayer player : players) {
            //variables to store hand values
            int playerValue = player.getHand().handValue();
            int dealerValue = dealer.getHand().handValue();
            double winnings = 0;

            //hands printed once game concludes
            System.out.println(player.getName() + "'s final hand:");
            player.showHand();
            
            //if dealer hand has blackjack, game concludes as if everyone stood on opening hands
            //the only hand that wouldnt lose is player blackjack in this case
            if (dealerHasBlackjack()) {
                if (player.hasBlackjack()) {
                    System.out.println(player.getName() + " ties with the dealer.");
                } else {
                    System.out.println(player.getName() + " loses to dealer's blackjack.");
                    winnings = -player.getBet();
                }
            } 
            else {
                //player busts
                if (playerValue > 21) {
                    System.out.println(player.getName() + " busts!");
                    winnings = -player.getBet();
                } 
            //dealer busts, everyone who didnt bust wins
                else if (dealerValue > 21) {
                    System.out.println("Dealer busts! " + player.getName() + " wins.");
                    winnings = player.hasBlackjack() ? player.getBet() * 2.5 : player.getBet();
                }
                //player has blackjack and dealer didnt hit to 21, bonus payout
                else if (player.hasBlackjack()&& dealerValue != 21 ) {
                    System.out.println(player.getName() + " has blackjack and wins!");
                    winnings = player.getBet() * 2.5; // Blackjack payout is 2.5 times
                } 
            //player didnt bust and beat player
                else if (playerValue > dealerValue) {
                    System.out.println(player.getName() + " wins!");
                    winnings = player.getBet();
                } 
            //dealer beat player and didnt bust
                else if (dealerValue > playerValue) {
                    System.out.println("Dealer wins!");
                    winnings = -player.getBet();
                } 
            //covers ties
                else {
                    System.out.println(player.getName() + " ties with the dealer.");
                }
            }

            // Print player's winnings/losses after the game
            System.out.println(player.getName() + "'s winnings/losses: $" + winnings);
        }
    }

    @Override
    public void play() {
        // method is in controller
    }
}
