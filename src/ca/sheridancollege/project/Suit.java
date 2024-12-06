/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mario
 */
public enum Suit {
    Club("clubs"),
    Diamond("diamonds"),
    Heart("hearts"),
    Spade("spades");
    String cardSuit;
    Suit (String cardSuit) {
    this.cardSuit=cardSuit;
    }
    
    @Override
    public String toString(){
    return cardSuit;
    }
}
