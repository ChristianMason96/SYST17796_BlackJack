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
    private Deck deck;
    private BlackjackDealer dealer;
    private BlackjackPlayer player;

    public Blackjack(String name) {
        super(name);
        deck = new Deck(52);
        dealer = new BlackjackDealer();
        player = new BlackjackPlayer();
        play();
    }

    @Override
    public void declareWinner() {
        int playerValue = player.getHand().handValue();
        int dealerValue = dealer.getHand().handValue();
        
    
        
        if (playerValue > 21) {
            System.out.println("Player busts! Dealer wins.");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts! Player wins.");
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins!");
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }



    @Override
    public void play() {
        //deal 2 cards to dealer and player
        dealer.dealerHit(deck);
        dealer.dealerHit(deck);
        
        //shows one card from the dealer
        dealer.showDealerHand();
        
        //deal 2 cards to player
        player.hit(deck);
        player.hit(deck);
        
        
        player.showHand();
        
        //check immediately for dealer blackjack, game ends if they do
        if (dealer.hasBlackjack()){
            dealer.showHand();
            declareWinner();
            return;   
        }
        

        if (player.hasBlackjack()){
            System.out.println("you have blackjack");
            declareWinner();
            return;   
        }
        
        //players turn
        player.play(deck);
        
        if (player.getHand().handValue()>21){
            System.out.println("player busts");
            return;
        }         
        
        //dealers turn
        System.out.println("dealer's turn");
        System.out.println("dealer hits and stands on 17 or above");
        dealer.play(deck);
        declareWinner();
    }
}

