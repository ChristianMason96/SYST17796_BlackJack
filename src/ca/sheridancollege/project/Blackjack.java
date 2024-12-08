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

    public Blackjack(String name, int numPlayers) {
        super(name);
        deck = new Deck(312); // 6 decks x 52 cards = 312 cards
        dealer = new BlackjackDealer();
        players = new ArrayList<>(numPlayers);

        for (int i = 1; i <= numPlayers; i++) {
            players.add(new BlackjackPlayer("Player " + i, 100)); // Initialize players with a starting balance of 100
        }
        deck.shuffle();
    }

    @Override
    public void declareWinner() {
        dealer.showHand();

        for (BlackjackPlayer player : players) {
            int playerValue = player.getHand().handValue();
            int dealerValue = dealer.getHand().handValue();

            System.out.println(player.getName() + "'s final hand:");
            player.showHand();

            if (playerValue > 21) {
                System.out.println(player.getName() + " busts! Dealer wins.");
            } else if (dealerValue > 21) {
                System.out.println("Dealer busts! " + player.getName() + " wins.");
                player.winBet();
            } else if (playerValue > dealerValue) {
                System.out.println(player.getName() + " wins!");
                player.winBet();
            } else if (dealerValue > playerValue) {
                System.out.println("Dealer wins!");
            } else {
                System.out.println(player.getName()+"ties with the dealer");
                player.tieBet();
            }

            System.out.println(player.getName() + "'s balance: $" + player.getBalance());
        }
    }

    @Override
    public void play() {
        for (BlackjackPlayer player : players) {
            player.placeBet();
        }

        dealer.dealerHit(deck);
        dealer.dealerHit(deck);
        dealer.showDealerHand();

        for (BlackjackPlayer player : players) {
            player.hit(deck);
            player.hit(deck);
            player.showHand();
        }

        if (dealer.hasBlackjack()) {
            System.out.println("Dealer has blackjack!");
            declareWinner();
            return;
        }

        boolean allPlayersBusted = true;

        for (BlackjackPlayer player : players) {
            if (!player.hasBlackjack()) {
                player.play(deck);
                if (player.getHand().handValue() <= 21) {
                    allPlayersBusted = false;
                }
            } else {
                System.out.println(player.getName() + " has blackjack!");
            }
        }

        if (allPlayersBusted) {
            System.out.println("All players busted! Dealer wins.");
            return;
        }

        System.out.println("Dealer's turn");
        dealer.play(deck);

        declareWinner();
    }
}
