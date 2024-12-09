/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;



/**
 *
 * @author Mario
 */


public class BlackjackPlayer extends Player {
    private double balance;
    private double bet;
    private Scanner input;

    public BlackjackPlayer(String name, double startingBalance) {
        super.setName(name);
        this.balance = startingBalance;
        this.input = new Scanner(System.in);
    }

    //get player balance
    public double getBalance() {
        return balance;
    }
    
    //method to take the bet from user's default balance of 100
    public void placeBet(double bet) {
        this.bet = bet;
        balance -= bet;
    }

    //adds original bet back to balance * 2 for winning
    public void winBet() {
        balance += 2 * bet;
    }
    //if player's starting hand is blackjack, they get extra payout
    public void blackjackPayout() {
        balance += 2.5 * bet;
    }

    //returns bet to player if they tie with the dealer
    public void tieBet() {
        balance += bet;
    }

    @Override
    public void play(Deck deck) {
        //control variable
        boolean continuePlaying = true;
        //player still plays while continuePlaying is true
        while (continuePlaying && this.getHand().handValue() < 21) {
            System.out.println(this.getName() + ", choose an action: (1) Hit (2) Stand");
            int action = input.nextInt();
            
            //if player types 1, they hit and keep playing their turn
            if (action == 1) {
                this.hit(deck);
                if (this.getHand().handValue() > 21) {
                    System.out.println(this.getName() + " busts with " + this.getHand().handValue());
                    continuePlaying = false;
                }
            }
            //if player enters 2, they end their turn with their current hand
            else if (action == 2) {
                continuePlaying = false;
            } 
            else {
                System.out.println("Invalid action. Please choose (1) Hit or (2) Stand.");
            }
        }
    }

    @Override
    public void hit(Deck deck) {
        //output to let us know which player was dealt card in initial dealing
        System.out.println(this.getName() + " is dealt a card.");
        super.hit(deck);
    }
}
