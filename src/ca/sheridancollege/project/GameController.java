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
        //instantiates blackjack model view and controller
        Blackjack game = new Blackjack("Blackjack");
        BlackjackView view = new BlackjackView();
        BlackjackController controller = new BlackjackController(game, view);

        controller.play();
    }
}
