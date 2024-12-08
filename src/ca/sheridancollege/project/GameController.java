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
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players (up to 5):"); 
        int playerCount = scanner.nextInt();
        scanner.nextLine();
        
        //ensures # of players entered is between 1 and 5
        while (playerCount < 1 || playerCount > 5) { 
            System.out.println("Please enter a number between 1 and 5:"); 
            playerCount = scanner.nextInt(); 
            scanner.nextLine();
        }
        
        
        Blackjack game = new Blackjack("Blackjack",playerCount);
        game.play();
    }
}
