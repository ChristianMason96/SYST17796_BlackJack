/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 *
 * @author Mario
 */
public class Hand extends GroupOfCards{
    private ArrayList<PlayingCard> hand;
    
    public Hand(int size){
        super(size);
        hand = new ArrayList<>();
    }
    
    
    //see value of hand
    public int handValue(){
        int handValue=0;
        int numberOfAces=0;
        //for each card in hand, add the value of card to total
        for(PlayingCard card:hand){
            //hand score
            handValue+= card.getCardValue();
            //if card value is 11, add to ace count
            if (card.getCardValue()==11){
                numberOfAces++;
            }
        } 
        
        //sets value of ace to 1 if there is an ace and hand >21
        if (handValue>21 && numberOfAces>0){
            while (numberOfAces>0 &&handValue>21){
                numberOfAces --;
                handValue -=10;
            }
        }
        return handValue;
    }
    //takes card from top of deck and puts it to hand
    public void takeFromDeck(Deck deck){
        hand.add(deck.giveCard());
    }
    
    
    //method to get card in hand at index position
    //mainly to show dealer's first card
    public PlayingCard getCard(int index){
        return hand.get(index);
    }
    
    @Override
    public String toString(){
        StringBuilder handString = new StringBuilder(); 
        for (PlayingCard card : hand) { 
            handString.append(card).append(" ");
        } 
       handString.append("Hand Total: ").append(handValue());
       return handString.toString();
    }
}
