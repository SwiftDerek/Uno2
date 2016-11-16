package uno;

/**
* Class to handle the game logic and flow.
* Methods in this class control player direction, discard pile placement, 
* user input, etc...
*/

public final class UnoModel {
    
    private UnoPlayer[] players;
    private UnoPlayer currentPlayer;
    private final int numCardsDrawn = 7;
    private UnoDeck deck;
    private int currentPlayerIndex = 0;
    private boolean reverse = false;
    private int numPlayers = 0;
    private int drawNumber = 0;
    private boolean cantPlay = false;
    private boolean alreadyPlayed = false;
    private boolean determineColor = false;
    private boolean playerOneUNO = false;
    private boolean playerTwoUNO = false;
    private boolean playerThreeUNO = false;
    private boolean playerFourUNO = false;
    private boolean skipTurn = false;
    
    public UnoModel(){
            
    }
    
    public boolean getCantPlay(){
        return cantPlay;
    }
    
    public void setCantPlayFalse(){
        cantPlay = false;
    }
    
    public void setCantPlayTrue(){
        cantPlay = true;
    }
    
    public boolean getAlreadyPlayed(){
        return alreadyPlayed;
    }
    
    public void setAlreadyPlayedTrue(){
        alreadyPlayed = true;
    }
    
    public void setAlreadyPlayedFalse(){
        alreadyPlayed = false;
    }
    
    public void setSkipTurnFalse(){
        skipTurn = false;
    }
    
    public boolean getSkipTurn(){
        return skipTurn;
    }
    
    public void setDrawNumber(int num){
        drawNumber = num;
    }
    
    public int getDrawNumber(){
        return drawNumber;
    }
    
    /**
    * Method to start game and initialize deck/players
    */
    public void startGame(int numPlayers){
        deck = new UnoDeck();
        this.numPlayers = numPlayers;
        players = new UnoPlayer[numPlayers];
        addPlayers();
        reverse = false;
        deck.discardFirstCard();
        if(deck.getTopOfDiscardPile() instanceof UnoReverse){
            reverse = !reverse;
            nextPlayer();
        }
        if (deck.getTopOfDiscardPile() instanceof UnoSkip){
            nextPlayer();
        }
        if (deck.getTopOfDiscardPile() instanceof UnoDraw){
            draw(2);
            nextPlayer();
        }
    }
    
    /**
    * Method to add players.
    * (Requirement 1.2.3)
    */
    public void addPlayers(){
        for (int i = 0; i < numPlayers; i++){
            players[i] = new UnoPlayer();
            setCurrentPlayer(players[i]);
            draw(numCardsDrawn);
        }
        setCurrentPlayer(players[0]);
    }
    
    /**
    * Method to draw cards.
    * (Requirement 1.3.2)
    */
    public void draw(int cards){
        for (int i = 0; i < cards; i++){
            currentPlayer.addCard(deck.draw());
        }
        if(currentPlayer == players[0])
            playerOneUNO = false;
        if(currentPlayer == players[1])
            playerTwoUNO = false;
        if(players.length >= 3 && currentPlayer == players[2])
            playerThreeUNO = false;
        if(players.length == 4 && currentPlayer == players[3])
            playerFourUNO = false;
    }
    
    public void playerOneDraw(int cards){
        for (int i = 0; i < cards; i++){
            players[0].addCard(deck.draw());
            playerOneUNO = false;
        }
    }
    
    public void playerTwoDraw(int cards){
        for (int i = 0; i < cards; i++){
            players[1].addCard(deck.draw());
            playerTwoUNO = false;
        }
    }
    
    public void playerThreeDraw(int cards){
        for (int i = 0; i < cards; i++){
            players[2].addCard(deck.draw());
            playerThreeUNO = false;
        }
    }
    
    public void playerFourDraw(int cards){
        for (int i = 0; i < cards; i++){
            players[3].addCard(deck.draw());
            playerFourUNO = false;
        }
    }
    
    /**
    * Method to discard card in hand if it matches discard pile card.
    * (Requirement 3.2.3)
    */
    public void discard(UnoCard card){
        if(card instanceof UnoNumber){
            compareNumbers((UnoNumber)card);
        } else if (card instanceof UnoWild){
            discardCard(card);
            determineColor = true;
        } else if (card instanceof UnoWildDraw){
            discardCard(card);
            determineColor = true;
            skipTurn = true;
            drawNumber = 4;
            if(currentPlayer == players[0])
                playerOneUNO = false;
            if(currentPlayer == players[1])
                playerTwoUNO = false;
            if(players.length >= 3 && currentPlayer == players[2])
                playerThreeUNO = false;
            if(players.length == 4 && currentPlayer == players[3])
                playerFourUNO = false;
        } else {
            compareColors(card);
        }
    }
    
    public void setCurrentPlayer(UnoPlayer player){
        currentPlayer = player;
    }
    
    public UnoPlayer getCurrentPlayer(){
        return currentPlayer;
    }
    
    public UnoPlayer[] getPlayers(){
        return players;
    }
    
    public int getCurrentPlayerIndex(){
        return currentPlayerIndex;
    }
    
    public void setCurrentPlayerIndex(){
        this.currentPlayerIndex = 0;
    }
    
    /**
    * Method to determine next player. 
    * If direction is reversed it will do so here.
    * (Requirement 3.2.0)
    */
    public void nextPlayer(){
        if (!reverse){
            currentPlayerIndex++;
            if(currentPlayerIndex > (numPlayers - 1)){
                currentPlayerIndex = 0;
            }
            setCurrentPlayer(players[currentPlayerIndex]);
        } else {
            currentPlayerIndex--;
            if(currentPlayerIndex < 0){
                currentPlayerIndex = numPlayers - 1;
            }
            setCurrentPlayer(players[currentPlayerIndex]); 
        }
    }

    /**
    * Helper methods for discardCard
    */
    public void compareNumbers(UnoNumber card){
        UnoCard topOfPile = deck.getTopOfDiscardPile();
        if (topOfPile instanceof UnoNumber){
            if((card.getNumber() == ((UnoNumber)topOfPile).getNumber()) || (card.getColor().equals(topOfPile.getColor()))){
                discardCard(card);
            } else {
                    cantPlay = true;
            }
        } else {
            if(card.getColor().equals(topOfPile.getColor())){
                discardCard(card);
            } else {
                cantPlay = true;
            }
        }
    }
    
    public void compareColors(UnoCard card){
        UnoCard topOfPile = deck.getTopOfDiscardPile();
        if(card.getColor().equals(topOfPile.getColor())){
            if(card instanceof UnoReverse){
                reverse = !reverse;
                discardCard(card);
            } else if (card instanceof UnoSkip){
                discardCard(card);
                skipTurn = true;
            } else if (card instanceof UnoDraw){
                discardCard(card);
                skipTurn = true;
                drawNumber = 2;
            }
        } else if (card instanceof UnoReverse && topOfPile instanceof UnoReverse){
            reverse = !reverse;
            discardCard(card);
        } else if (card instanceof UnoSkip && topOfPile instanceof UnoSkip){
            discardCard(card);
            skipTurn = true;
        } else if (card instanceof UnoDraw && topOfPile instanceof UnoDraw){
            discardCard(card);
            drawNumber = 2;
            skipTurn = true;
        } else {
            cantPlay = true;
        }
    }
    
    public void discardCard(UnoCard card){
        deck.setTopOfDiscardPile(card);
        currentPlayer.removeCard(card);
    }
    
    /**
    * Method to check for UNO with each player.
    * (Requirement 3.3.0)
    */
    public boolean UNO(){
        if (currentPlayer == players[0] && currentPlayer.getHandSize() == 1)
            playerOneUNO = true;
        if (currentPlayer == players[1] && currentPlayer.getHandSize() == 1)
            playerTwoUNO = true;
        if (players.length >= 3 && currentPlayer == players[2] && currentPlayer.getHandSize() == 1)
            playerThreeUNO = true;
        if (players.length == 4 && currentPlayer == players[3] && currentPlayer.getHandSize() == 1)
            playerFourUNO = true;
        return currentPlayer.getHandSize() == 1;
    }
    
    public boolean checkFirstPlayer(){
        if (players[0] != currentPlayer && players[0].getHandSize() == 1 && playerOneUNO == false)
            return true;
        else
            return false;
    }
    
    public boolean checkSecondPlayer(){
        if (players[1] != currentPlayer && players[1].getHandSize() == 1 && playerTwoUNO == false)
            return true;
        else
            return false;
    }
    
    public boolean checkThirdPlayer(){
        if (players.length >= 3 && players[2] != currentPlayer && players[2].getHandSize() == 1 && playerThreeUNO == false)
            return true;
        else
            return false;
    }
    
    public boolean checkFourthPlayer(){
        if (players.length == 4 && players[3] != currentPlayer && players[3].getHandSize() == 1 && playerFourUNO == false)
            return true;
        else
            return false;
    }
    
    public UnoCard getTopOfDeck(){
        return deck.getTopOfDiscardPile();
    }
    
    public boolean getWildCardPopUp(){
        return determineColor;
    }
    
    public void setWildCardPopUp(){
        this.determineColor = false;
    }
}
