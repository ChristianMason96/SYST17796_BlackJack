/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mario
 */
public class BlackjackDealer extends Player {
    public BlackjackDealer() {
        super.setName("dealer");
    }



    @Override
    public void play(Deck deck) {
        //makes dealer hit until their score is lower than 17
        while (getHand().handValue() < 17) {
            hit(deck);
        }
        
    }
}

