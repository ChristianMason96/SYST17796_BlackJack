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
    Scanner input = new Scanner(System.in);

    public BlackjackPlayer() {
        super.setName("player");
    }

    @Override
    public void play(Deck deck) {
        while (true) {
            System.out.println("Choose an action: (1) Hit (2) Stand");
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

