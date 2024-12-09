/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mario
 */


import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackjackView {
    private final Scanner scanner = new Scanner(System.in);

    public int getPlayerCount() {
        while (true) {
            try {
                System.out.println("Enter the number of players (up to 5):");
                int playerCount = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return playerCount;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }

    public int getBetAmount(Player player) {
        if (player instanceof BlackjackPlayer) {
            BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
            while (true) {
                try {
                    System.out.println(blackjackPlayer.getName() + ", you have $" + blackjackPlayer.getBalance());
                    System.out.println("Enter your bet amount:");
                    int bet = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    return bet;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid bet amount.");
                    scanner.nextLine(); // consume invalid input
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid player type");
        }
    }

    public int getPlayerAction(Player player) {
        //exception handling
        while (true) {
            try {
                System.out.println(player.getName() + "'s turn:");
                System.out.println(player.getHand());
                System.out.println(player.getName() + ", choose an action: (1) Hit (2) Stand");
                int action = scanner.nextInt();
                //player doesnt enter 1 or 2
                if (action != 1 && action != 2) {
                    throw new IllegalArgumentException("Invalid action. Please choose (1) Hit or (2) Stand.");
                }
                return action;
            } 
            //player enters different datatype, letters, symbols etc
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                scanner.nextLine(); // consume invalid input
            } 
            //prints illegal argument exception message
            catch (IllegalArgumentException e) 
            {
                System.out.println(e.getMessage());
            }
        }
    }
    //clears scanner
    public void clearInputBuffer() {
        if (scanner.hasNext()) {
            scanner.next();
        }
    }
    //print dealer card
    public void displayDealerFaceUpCard(BlackjackDealer dealer) {
        System.out.println("The dealer's face-up card:");
        System.out.println(dealer.getHand().getCard(0));
    }

    //print dealers hand at the end of the game
    public void displayDealerHand(BlackjackDealer dealer) {
        System.out.println("Dealer's full hand:");
        dealer.showHand();
    }

    public void displayPlayerHand(Player player) {
        System.out.println(player.getName() + "'s hand:");
        System.out.println(player.getHand());
    }

    public void displayPlayerFinalHand(Player player) {
        System.out.println(player.getName() + "'s final hand:");
        player.showHand();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

