package amoba;

public class Field {
    
    private Player owner;

    public Field() {
        this.owner = null;
    }
    /**
     * 
     * @return 
     */
    public Player getOwner(){
        return this.owner;
    }
    public void resetOwner() {
        this.owner = null;
    }
    public void setMap(Player player){
        this.owner = player;
    }
    
}
