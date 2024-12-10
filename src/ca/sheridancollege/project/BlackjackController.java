/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Mario
 * 
 */



public class BlackjackController {
    private Blackjack game;
    private BlackjackView view;

    public BlackjackController(Blackjack game, BlackjackView view) {
        this.game = game;
        this.view = view;
    }

    public void play() {
        int playerCount;
        // Exception handling for player count
        while (true) {
            //if player is above 5 or below 1, 
            try {
                playerCount = view.getPlayerCount();
                if (playerCount < 1 || playerCount > 5) {
                    throw new IllegalArgumentException("The number of players must be between 1 and 5.");
                }
                break;
            } 
            //catches illegal argument and displays message
            catch (IllegalArgumentException e) {
                view.displayMessage(e.getMessage());
            } //general catch
            catch (Exception e) {
                view.displayMessage("Invalid input. Please enter a number between 1 and 5.");
            }
        }
        game.initializePlayers(playerCount);

        ArrayList<Player> players = game.getPlayers();

        for (Player player : players) {
            BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
            int bet;
            // Exceptions for invalid bets
            while (true) {
                try {
                    bet = view.getBetAmount(blackjackPlayer);
                    //bet cant be negative
                    if (bet <= 0) {
                        throw new IllegalArgumentException("Bet must be a positive number.");
                    }
                    break;
                }
                //prints the message
                catch (IllegalArgumentException e) {
                    view.displayMessage(e.getMessage());
                }
                //general catch for invalid inputs: letters, symbols etc
                catch (Exception e) {
                    view.displayMessage("Invalid input. Please enter a valid bet amount.");
                }
            }
            blackjackPlayer.placeBet(bet);
        }

        game.dealInitialCards();

        // If the dealer has blackjack, the game should end immediately, no further actions are allowed
        if (game.dealerHasBlackjack()) {
            return;
        }

        view.displayDealerFaceUpCard(game.getDealer());

        boolean allPlayersBusted = true;

        for (Player player : players) {
            BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;

            view.displayPlayerHand(blackjackPlayer);
            view.displayDealerFaceUpCard(game.getDealer());
            while (blackjackPlayer.getHand().handValue() < 21) {
                int action = 0;
                while (true) {
                    try {
                        action = view.getPlayerAction(blackjackPlayer);
                        if (action != 1 && action != 2) {
                            throw new IllegalArgumentException("Invalid action. Please choose (1) Hit or (2) Stand.");
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        view.displayMessage(e.getMessage());
                    } catch (InputMismatchException e) {
                        view.displayMessage("Invalid input. Please enter 1 or 2.");
                        view.clearInputBuffer();
                    }
                }
                if (action == 1) {
                    blackjackPlayer.hit(game.getDeck());
                    view.displayPlayerHand(blackjackPlayer);
                } else {
                    break;
                }
            }
            if (blackjackPlayer.getHand().handValue() <= 21) {
                allPlayersBusted = false;
            }
        }

        if (allPlayersBusted) {
            view.displayMessage("All players busted! Dealer wins.");
            game.declareWinner();
            return;
        }

        // Dealer's turn is automated and in BlackjackDealer class
        view.displayMessage("Dealer's turn");
        game.getDealer().play(game.getDeck());

        game.declareWinner();
    }
}
