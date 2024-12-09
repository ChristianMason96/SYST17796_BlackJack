/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;



/**
 *
 * @author Mario
 */

import java.util.ArrayList;

public class Blackjack extends Game {
    private Deck deck;
    private BlackjackDealer dealer;
    private ArrayList<BlackjackPlayer> players;

    public Blackjack(String name) {
        super(name);
    }

    public void initializePlayers(int playerCount) {
        deck = new Deck(312);
        dealer = new BlackjackDealer();
        players = new ArrayList<>(playerCount);

        for (int i = 1; i <= playerCount; i++) {
            //gives players a starting value of 100
            players.add(new BlackjackPlayer("Player " + i, 100));
        }
        deck.shuffle();
    }

    public boolean dealerHasBlackjack() {
        return dealer.hasBlackjack();
    }

    public void dealInitialCards() {
        dealer.dealerHit(deck);
        dealer.dealerHit(deck);
        for (BlackjackPlayer player : players) {
            player.hit(deck);
            player.hit(deck);
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

            //hands printed once game concludes
            System.out.println(player.getName() + "'s final hand:");
            player.showHand();

            //player hand over 21, they lose even if dealer busts
            if (playerValue > 21) {
                System.out.println(player.getName() + " busts!");
            }
            //dealer busts, everyone who didnt bust wins
            else if (dealerValue > 21) {
                System.out.println("Dealer busts! " + player.getName() + " wins.");
                player.winBet();
            } 
            //player gets bonus payout for getting blackjack
            else if (player.hasBlackjack() && dealerValue != 21) {
                System.out.println(player.getName() + " has blackjack!");
                player.blackjackPayout();
            } 
            //player didnt bust and beat player
            else if (playerValue > dealerValue) {
                System.out.println(player.getName() + " wins!");
                player.winBet();
            }
            //dealer beat player and didnt bust
            else if (dealerValue > playerValue) {
                System.out.println("Dealer wins!");
            } 
            //covers ties
            else {
                System.out.println(player.getName()+" ties");
                player.tieBet();
            }
            //print player's balance after game
            System.out.println(player.getName() + "'s balance: $" + player.getBalance());
        }
    }

    @Override
    public void play(){
    //method is in controller
    }
}

