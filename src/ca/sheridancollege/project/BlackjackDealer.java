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

    public void showDealerHand() {
        System.out.println("The dealer's face-up card:");
        System.out.println(super.getHand().getCard(0));
    }
    

    @Override
    public void play(Deck deck) {
        while (getHand().handValue() < 17) {
            hit(deck);
        }
        
    }
}

