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

    public double getBalance() {
        return balance;
    }

    public double getCurrentBet() {
        return currentBet;
    }

    public void placeBet() {
        System.out.println(getName() + ", you have $" + balance);
        System.out.println("Enter your bet amount:");
        double bet = input.nextDouble();
        while (bet > balance || bet <= 0) {
            System.out.println("Invalid bet amount. Your bet must be between $1 and $" + balance);
            System.out.println("Enter your bet amount:");
            bet = input.nextDouble();
        }
        currentBet = bet;
        balance -= bet;
    }

    public void winBet() {
        balance += currentBet * 2;
    }

    public void tieBet() {
        balance += currentBet;
    }

    @Override
    public void play(Deck deck) {
        while (true) {
            System.out.println(getName() + "'s turn:");
            showHand(); // Show the player's hand at the start of their turn
            System.out.println(getName() + ", choose an action: (1) Hit (2) Stand");
            int choice = input.nextInt();
            if (choice == 1) {
                hit(deck);
                if (getHand().handValue() > 21) {
                    System.out.println("Bust! You lose.");
                    break;
                }
            } else if (choice == 2) {
                break;
            }
        }
    }
}
