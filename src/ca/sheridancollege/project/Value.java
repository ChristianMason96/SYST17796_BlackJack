/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mario
 */
public enum Value {
    Ace("ace",11),
    Two("two",2),
    Three("three",3),
    Four("four",4),
    five("five",5),
    Six("six",6),
    Seven("seven",7),
    Eight("eight",8),
    Nine("nine",9),
    Ten("ten",10),
    Jack("jack",10),
    Queen("queen",10),
    King("king",10);
    
    String name;
    int cardValue;
    Value(String name,int cardValue){
    this.name=name;
    this.cardValue=cardValue;
    }
    
    @Override 
    public String toString(){
    return name;
    }
}
