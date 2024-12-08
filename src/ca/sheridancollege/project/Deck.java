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
public class Deck extends GroupOfCards{
    private ArrayList<PlayingCard> deck;
    
    public Deck(int size){
        super(size);
        deck=new ArrayList<PlayingCard>(size);
        
        
    }
}

 
  
    
 
    
