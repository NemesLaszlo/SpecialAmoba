package amoba;

public class Field {
    
    private Player owner;

    public Field() {
        this.owner = null;
    }
    
    public void setMap(Player player){
        this.owner = player;
    }
    
}
