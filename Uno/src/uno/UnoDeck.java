package uno;

/**
* Class to hold the game's deck of cards.
*  
*/

import java.util.ArrayList;
import java.util.Stack;

public class UnoDeck {
    private ArrayList<UnoCard> deck = new ArrayList<>();
    private Stack<UnoCard> discardPile = new Stack<>();
    private int topOfDeck;
    
    private final int numberCards = 76;
    private final int drawCards = 8;
    private final int reverseCards = 8;
    private final int skipCards = 8;
    private final int wildCards = 4;
    private final int wildDrawCards = 4;
    
    private final String colorRed = "red";
    private final String colorBlue = "blue";
    private final String colorYellow = "yellow";
    private final String colorGreen = "green";
    
    /**
    * Method to add cards of each type (108 total) and shuffled.
    * (Requirement 2.0.0)
    */
    public UnoDeck(){
        addNumbers();
        addDraws();
        addReverses();
        addSkips();
        addWilds();
        addWildDraws();
        shuffle();
        shuffle();
        topOfDeck = deck.size() - 1;
    }
    
    // Method to shuffle
    // (Requirement 2.3.0)
    private void shuffle(){
        deck.forEach((card) -> {
            int randIndex = (int)(Math.random() * deck.size());
            UnoCard temp = card;
            deck.set(deck.indexOf(card), deck.get(randIndex));
            deck.set(deck.indexOf(deck.get(randIndex)), temp);
        });
    }
    
    /**
    * Method discard the first card of deck and place in discard pile.
    * (Requirement 3.2.2)
    */
    public void discardFirstCard(){
        while(deck.get(topOfDeck) instanceof UnoWild || deck.get(topOfDeck) instanceof UnoWildDraw)
            shuffle();
        discardPile.push(deck.get(topOfDeck));
        deck.remove(topOfDeck);
        topOfDeck--;
    }
    
    /**
    * Method to allow player to draw card from deck.
    * (Requirement 3.2.5)
    * @return 
    */
    public UnoCard draw(){
        if(deck.isEmpty()){
            discardPile.forEach((card) -> {
                deck.add(discardPile.pop());
            });
            shuffle();
            shuffle();
            topOfDeck = deck.size() - 1;
            discardFirstCard();
        }
        UnoCard card = deck.get(topOfDeck);
        deck.remove(topOfDeck);
        topOfDeck--;
        return card;
    }
    
    public void discard(UnoCard card){
        discardPile.push(card);
    }
    
    public UnoCard getTopOfDiscardPile(){
        return discardPile.peek();
    }
    
    public void setTopOfDiscardPile(UnoCard card){
        this.discardPile.push(card);
    }
    
    /**
    * Methods to add 32 special cards to deck.
    * (Requirement 2.2.0)
    */
    private void addWildDraws() {
        for(int i = 0; i < wildDrawCards; i++){
            deck.add(new UnoWildDraw());
        }
    }

    private void addWilds() {
        for (int i = 0; i < wildCards; i++){
            deck.add(new UnoWild());
        }
    }

    private void addSkips() {
        for (int i = 0; i < skipCards / 4; i++){
            deck.add(new UnoSkip(colorRed));
        }
        for (int i = 0; i < skipCards / 4; i++){
            deck.add(new UnoSkip(colorBlue));
        }
        for (int i = 0; i < skipCards / 4; i++){
            deck.add(new UnoSkip(colorYellow));
        }
        for (int i = 0; i < skipCards / 4; i++){
            deck.add(new UnoSkip(colorGreen));
        }
    }

    private void addReverses() {
        for (int i = 0; i < reverseCards / 4; i++){
            deck.add(new UnoReverse(colorRed));
        }
        for (int i = 0; i < reverseCards / 4; i++){
            deck.add(new UnoReverse(colorBlue));
        }
        for (int i = 0; i < reverseCards / 4; i++){
            deck.add(new UnoReverse(colorYellow));
        }
        for (int i = 0; i < reverseCards / 4; i++){
            deck.add(new UnoReverse(colorGreen));
        }
    }

    private void addDraws() {
        for (int i = 0; i < drawCards / 4; i++){
            deck.add(new UnoDraw(colorRed));
        }
        for (int i = 0; i < drawCards / 4; i++){
            deck.add(new UnoDraw(colorBlue));
        }
        for (int i = 0; i < drawCards / 4; i++){
            deck.add(new UnoDraw(colorYellow));
        }
        for (int i = 0; i < drawCards / 4; i++){
            deck.add(new UnoDraw(colorGreen));
        }
    }

    /**
    * Method to add 76 number cards.
    * (Requirement 2.1.0)
    */
    private void addNumbers() {
        addRedNumbers();
        addBlueNumbers();
        addYellowNumbers();
        addGreenNumbers();
    }

    private void addGreenNumbers() {
        for (int i = 0; i < (numberCards / 8) + 1; i++) {
            deck.add(new UnoNumber(colorGreen, i));
        }
        for (int i = 0; i < (numberCards / 8) + 1; i++) {
            deck.add(new UnoNumber(colorGreen, i));
        }
    }

    private void addYellowNumbers() {
        for (int i = 0; i < (numberCards / 8) + 1; i++) {
            deck.add(new UnoNumber(colorYellow, i));
        }
        for (int i = 0; i < (numberCards / 8) + 1; i++) {
            deck.add(new UnoNumber(colorYellow, i));
        }
    }

    private void addBlueNumbers() {
        for (int i = 0; i < (numberCards / 8) + 1; i++) {
            deck.add(new UnoNumber(colorBlue, i));
        }
        for (int i = 0; i < (numberCards / 8) + 1; i++) {
            deck.add(new UnoNumber(colorBlue, i));
        }
    }

    private void addRedNumbers() {
        for (int i = 0; i < (numberCards / 8) + 1; i++) {
            deck.add(new UnoNumber(colorRed, i));
        }
        for (int i = 0; i < (numberCards / 8) + 1; i++) {
            deck.add(new UnoNumber(colorRed, i));
        }
    }
}
