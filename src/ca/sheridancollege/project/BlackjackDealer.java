/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mario
 */
public class BlackjackDealer extends Player{
    
    //creates player named dealer, uses player class's method
    public BlackjackDealer(){
    super.setName("dealer");
    }
    public void showDealerHand(){
        System.out.println("the dealer's face up card:");
        System.out.println(super.getHand().getCard(0));
    }
    @Override
    public void play(){}
    
}
