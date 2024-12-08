/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mario
 */
public class Blackjack extends Game {
    private GroupOfCards deck;
    private BlackjackDealer dealer;
    private BlackjackPlayer player;
    
    
    
    public Blackjack(String name){
        super(name);
        deck = new GroupOfCards(52);
        dealer=new BlackjackDealer();
        player=new BlackjackPlayer();
    }
    
    @Override
    public void declareWinner(){
    
    }
    
    private void startGame(){
        dealer.getHand();
    }
    @Override
    public void play(){
        startGame();
    }
    
}
