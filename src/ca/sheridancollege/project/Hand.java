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
    //method to get card in hand at index position
    public PlayingCard getCard(int index){
        return hand.get(index);
    }
}
