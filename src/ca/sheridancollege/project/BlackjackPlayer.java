/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;



/**
 *
 * @author Mario
 */


import java.util.Scanner;

public class BlackjackPlayer extends Player {
    private double balance;
    private double currentBet;
    Scanner input = new Scanner(System.in);

    public BlackjackPlayer(String name, double initialBalance) {
        super.setName(name);
        this.balance = initialBalance;
    }

    //get player balance
    public double getBalance() {
        return balance;
    }

    //get their bet
    public double getCurrentBet() {
        return currentBet;
    }

    public void placeBet() {
        System.out.println(getName() + ", you have $" + balance);
        System.out.println("Enter your bet amount:");
        double bet = input.nextDouble();
        
        //simple error checking to ensure bet is not negative or they dont bet more than they have
        while (bet > balance || bet <= 0) {
            System.out.println("Invalid bet amount. Your bet must be between $1 and $" + balance);
            System.out.println("Enter your bet amount:");
            bet = input.nextDouble();
        }
        currentBet = bet;
        balance -= bet;
    }
    // Win payout
    public void winBet() {
        balance += currentBet * 2; 
    }
    
    //if player ties with dealer return their bet to them
    public void tieBet() {
        balance += currentBet;
    }
    
    //if player gets blackjack, increased payout
    public void blackjackPayout() {
        balance += currentBet * 2.5; 
    }

    @Override
    public void play(Deck deck) {
        while (true) {
            System.out.println(getName() + "'s turn:");
            // Show the player's hand at the start of their turn
            showHand(); 
            System.out.println(getName() + ", choose an action: (1) Hit (2) Stand");
            int choice = input.nextInt();
            if (choice == 1) {
                hit(deck);
                if (getHand().handValue() > 21) {
                    System.out.println("Bust! You lose.");
                    break;
                }
                //if handvalue=21, automatically end the player's turn
                else if (getHand().handValue() == 21) { 
                    System.out.println("Your hand value is 21, your turn ends"); 
                    break; 
                }
            } else if (choice == 2) {
                break;
            }
        }
    }
}
