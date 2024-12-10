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


public class GameController {
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner input = new Scanner(System.in);
        // Instantiate the game, view, and controller
        Blackjack game = new Blackjack("Blackjack");
        BlackjackView view = new BlackjackView();
        BlackjackController controller = new BlackjackController(game, view);

        boolean continuePlaying = true;

        // Main game loop to allow multiple rounds
        while (continuePlaying) {
            controller.play();

            while (true) {
                System.out.println("Do you want to play another round? (yes/no)");
                //removes whitespace and makes answer not case sensitive
                String answer = input.nextLine().trim().toLowerCase();
               
                //starts new round
                if (answer.equals("yes")) {
                    continuePlaying = true;
                    break;
                } 
                //ends program if players type no
                else if (answer.equals("no")) {
                    continuePlaying = false;
                    break;
                } 
                //error handling
                else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
        }

        input.close();
    }
}
