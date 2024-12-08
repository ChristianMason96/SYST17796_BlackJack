/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mario
 */
public class PlayingCard extends Card{
    
    private Suit suit;
    private Value value;
    
    //constructor
    public PlayingCard(Suit suit, Value value){
        this.suit=suit;
        this.value=value;
    }
    
    public Suit getSuit(){
        return suit;
    }
    
    public Value getValue(){
        return value;
    }
    public int getCardValue(){
        return value.cardValue;
    }
    @Override
    public String toString(){
        return value+" of "+suit;
    };
}
