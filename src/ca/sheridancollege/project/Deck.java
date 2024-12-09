/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mario
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Deck extends GroupOfCards{
    private ArrayList<PlayingCard> deck;
    
    public Deck(int size){
        super(size);
        this.deck=new ArrayList<>(size);
        createDeck();
        shuffle();
    }
    
public void createDeck() { // 6-8 decks for the shoe 
    int shoeCount = 6; 
    for (int i = 0; i < shoeCount; i++) { 
        for (Suit suit : Suit.values()) { 
            for (Value value : Value.values()) { 
                deck.add(new PlayingCard(suit, value));
            }
        }
    }
    setCards(new ArrayList<>(deck));
}
    
    @Override
    public void shuffle() { 
        Collections.shuffle(deck, new Random());
    }
        
    //method to take card from the deck and return it
    public PlayingCard giveCard(){
        PlayingCard topCard = new PlayingCard(deck.get(0).getSuit(),deck.get(0).getValue());
        deck.remove(0);
        return topCard;
    }
}