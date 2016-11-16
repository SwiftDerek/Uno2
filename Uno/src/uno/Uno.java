package uno;

/**
* Class to start the game. Instantiates the View/Model and sends the objects
* to the controller.
* 
*/

public class Uno {

    public static void main(String[] args) {
        UnoView View = new UnoView();
        UnoModel Model = new UnoModel();
        UnoController Controller = new UnoController(View, Model);
        View.setController(Controller);
    }
    
}
