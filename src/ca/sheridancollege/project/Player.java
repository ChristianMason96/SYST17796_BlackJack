/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {
    private Hand hand;
    private String name; //the unique name for this player


    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player() {
        this.hand=new Hand(21);
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    //get and set hands
    public void setHand(Hand hand){
        this.hand = hand;
    }
    
    public Hand getHand(){
        return this.hand;
    }

    public void showHand(){
        System.out.println(this.name+"'s hand:");
        System.out.println(this.hand);
    }
    
    //check if player has blackjack
    public boolean hasBlackjack(){
        if (this.getHand().handValue()==21){
            return true;
                }
        else{
            return false;
        }
    }
    public void hit(Deck deck){
        this.hand.takeFromDeck(deck);
        this.showHand();
    }
    //dealer hit that doesnt show hand after drawing
    public void dealerHit(Deck deck){
        this.hand.takeFromDeck(deck);
    }
    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play(Deck deck);

}
