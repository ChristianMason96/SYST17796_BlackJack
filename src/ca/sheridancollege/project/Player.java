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
    private String name;

    public Player() {
        this.hand = new Hand(21);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void showHand() {
        System.out.println("\n"+this.hand+"\n");
    }

    public boolean hasBlackjack() {
        return this.getHand().handValue() == 21&&this.getHand().size()==2;
    }

    public void hit(Deck deck) {
        this.hand.takeFromDeck(deck);
        this.showHand();
    }

    public void dealerHit(Deck deck) {
        this.hand.takeFromDeck(deck);
    }

    public abstract void play(Deck deck);
}
