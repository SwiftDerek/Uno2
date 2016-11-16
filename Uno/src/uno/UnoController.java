package uno;

/**
* Controller to handle interactions between the model and view. 
*  
*/


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UnoController {
    
    private UnoView View;
    private UnoModel Model;
    
    // Set the view and model for the controller.
    public UnoController(UnoView view, UnoModel model){
        this.View = view;
        this.Model = model;
        
        View.setVisible(true);
        View.hidePanel();
    }
    
    /**
    * Method to set number of players and begin game.
    * (Requirement 1.2.3)
    */
    public void setNumPlayers(int numPlayers){
        Model.setCurrentPlayerIndex();
        View.clearPlayersLabel();
        Model.startGame(numPlayers);
        View.setDiscardPile(View.getImage(Model.getTopOfDeck()));
        View.showPanel();
        startTurn();
    }
    
    /**
    * Method to update the amount of cards in player's hands.
    * (Requirement 1.5.0)
    */
    public void changePlayerLabel(UnoPlayer[] players){
        View.setPlayers1Label(players[0].getHandSize());
        View.setPlayers2Label(players[1].getHandSize());
        if (players.length == 3){
            View.setPlayers3Label(players[2].getHandSize());
        } 
        if (players.length == 4){
            View.setPlayers3Label(players[2].getHandSize());
            View.setPlayers4Label(players[3].getHandSize());
        }
    }
    
    /**
    * Method to start a player's turn and update the board.
    * (Requirement 1.5.0)
    */
    public void startTurn(){
        changePlayerLabel(Model.getPlayers());
        View.setCurrentPlayerLabel(Model.getCurrentPlayerIndex());
        View.showDrawButton();
        displayHandCards();
        Model.setCantPlayFalse();
        Model.setAlreadyPlayedFalse();
    }
    
    /**
    * Method to end a turn after a card has been played and
    * handle the flow of special cards (i.e. Wild/Draw/Reverse/Skip)
    * (Requirement 3.2.0)
    * (Requirement 3.1.1 - 3.1.5)
    */
    public void endTurn(){
        if (Model.getSkipTurn()){
            Model.nextPlayer();
            if (Model.getDrawNumber() == 2)
                Model.draw(2);
            if (Model.getDrawNumber() == 4)
                Model.draw(4);
            Model.setSkipTurnFalse();
            Model.setDrawNumber(0);
        }
        Model.nextPlayer();
        startTurn();
    }
    
    /**
    * Method to check if UNO has been reached.
    * (Requirement 3.3.0
    */
    public boolean checkUNO(){
        return Model.UNO();
    }
    
    /**
    * Method to check if player did not declare UNO
    * (Requirement 1.3.4)
    */
    public void checkMissedUNO(){
        if (firstStatus() == true)
            Model.playerOneDraw(2);
        if (secondStatus() == true)
            Model.playerTwoDraw(2);
        if (thirdStatus() == true)
            Model.playerThreeDraw(2);
        if (fourthStatus() == true)
            Model.playerFourDraw(2);
        changePlayerLabel(Model.getPlayers());
    }
    
    public boolean firstStatus(){
        return Model.checkFirstPlayer();
    }
    
    public boolean secondStatus(){
        return Model.checkSecondPlayer();
    }
    
    public boolean thirdStatus(){
        return Model.checkThirdPlayer();
    }
    
    public boolean fourthStatus(){
        return Model.checkFourthPlayer();
    }
    
    /**
    * Method to allow player to draw a card.
    * (Requirement 3.2.6)
    */
    public void draw(){
        Model.draw(1);
        View.hideDrawButton();
        changePlayerLabel(Model.getPlayers());
        displayHandCards();
    }
    
    /**
    * Method to display cards in current player hand.
    * (Requirement 1.4.0) 
    */
    public void displayHandCards(){
        int h = Model.getCurrentPlayer().getHand().size();
        if (h > 25){ // Handle if hand is bigger than the screen allows
            h = 25;
        }
        ImageIcon image;
        for (int i = 0; i < h; i++){
            image = View.getImage(Model.getCurrentPlayer().getHand().get(i));
            View.labelArray[i].setIcon(image);
            View.labelArray[i].setVisible(true);
            View.currentHand[i] = Model.getCurrentPlayer().getHand().get(i);
        }
        for (int i = h; i < 26; i++){
            View.labelArray[i].setVisible(false);
        }
    }
    
    /**
    * Method to discard card if playable AND check if player won the game.
    * (Requirement 3.2.3)
    * (Requirement 3.3.1)
    */
    public void discardCard(UnoCard card){
        Model.setCantPlayFalse();
        if (!Model.getAlreadyPlayed())
            Model.discard(card);
        if (wildCardPopUp()){
            Model.getTopOfDeck().setColor(View.chooseColor());
            Model.setWildCardPopUp();
        }
        if(!Model.getCantPlay() && !Model.getAlreadyPlayed()){
            View.hideDrawButton();
            changePlayerLabel(Model.getPlayers());
            View.labelArray[View.getCardNumber()].setVisible(false);
            Model.setAlreadyPlayedTrue();
            Model.setCantPlayFalse();
        }
        if (Model.getPlayers()[0].getHandSize() == 0){
            JOptionPane.showMessageDialog(null, "Player 1 won the game!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            View.hidePanel();
        }
        if (Model.getPlayers()[1].getHandSize() == 0){
            JOptionPane.showMessageDialog(null, "Player 2 won the game!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            View.hidePanel();
        }
        if (Model.getPlayers().length >= 3 && Model.getPlayers()[2].getHandSize() == 0){
            JOptionPane.showMessageDialog(null, "Player 3 won the game!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            View.hidePanel();
        }
        if (Model.getPlayers().length == 4 && Model.getPlayers()[3].getHandSize() == 0){
            JOptionPane.showMessageDialog(null, "Player 4 won the game!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            View.hidePanel();
        }
    }
    
    public boolean invalidPlay(){
        return Model.getCantPlay();
    }
    
    public boolean invalidPlayTwo(){
        return Model.getAlreadyPlayed();
    }
    
    public UnoCard getTopOfDeck(){
        return Model.getTopOfDeck();
    }
    
    public boolean wildCardPopUp(){
        return Model.getWildCardPopUp();
    }
    
}
