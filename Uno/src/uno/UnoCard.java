package uno;

/**
* Abstract class to hold the color of card (unless it's wild).
* Each card type extends from this class.
*/
public abstract class UnoCard {
    
        String color;
        
        public String getColor(){
            return this.color;
        }
        
        public void setColor(String color){
            this.color = color;
        }
}
