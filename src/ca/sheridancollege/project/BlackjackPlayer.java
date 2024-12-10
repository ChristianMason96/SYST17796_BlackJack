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
    private double bet; // Track the current bet amount
    private Scanner input;
    private boolean lost;
    private boolean tie;

    public BlackjackPlayer(String name) {
        super.setName(name);
        this.input = new Scanner(System.in);
        this.lost = false;
        this.tie = false;
    }

    public double getBet() {
        return bet;
    }

    public void placeBet(double bet) {
        this.bet = bet;
    }

    @Override
    public void play(Deck deck) {
        //control variable
        boolean continuePlaying = true;
        // Player continues playing until they bust or stand
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
        // Indicate the player was dealt a card
        System.out.println(this.getName() + " is dealt a card.");
        super.hit(deck);
    }
}
