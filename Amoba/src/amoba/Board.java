package amoba;

import java.util.ArrayList;


public class Board {
    
    
    private ArrayList<ArrayList<Field>> board;
    private final int width;
    private final int height;

    /**
     * A leendő játéktábla megvalósítása
     * a 2d mátrix feltöltése Field objektumokkal
     * 
     * @param height
     * @param width 
     */
    public Board(int height, int width) {
        this.width = width;
        this.height = height;
        board = new ArrayList<>();
        for(int i = 0; i < this.height; ++i){
            ArrayList<Field> row = new ArrayList<>();
            for(int j = 0; j < this.width; ++j){
                row.add(new Field());
            }
            board.add(row); 
        }
    }
    /**
     * Szélesség lekérdezés
     * @return width
     */
    public int getWidth() {
        return width;
    }
    /**
     * A magasság lekérdezése
     * @return height
     */
    public int getHeight() {
        return height;
    }
    /**
     * A tábla tisztítása, az új játék előkészítéséhez
     */
    public void clear() {
        
        for(int i = 0; i < this.height; ++i){
            for(int j = 0; j < this.width; ++j){
                board.get(i).get(j).resetOwner();
            }
            
        }
    }
     public Field get(int i,int j){
        return board.get(i).get(j);
    }
     
    /**
     * A megfeleő jel , megfeleő helyre történő beírása, maga az "esés"
     * 2 esettel, 1 amikor üres az oszlop és a legalsó helyre kell
     *            2 már van jel a sorban és annak a "tetejére" kerülés
     * @param x
     * @param y
     * @param player
     * @return logikai metódus
     */ 
    public boolean klick(int x,int y,Player player){
        
        if(board.get(x).get(y).getOwner() != null ){ return false;}
            for(int i = 0; i < this.height;++i){
                   
                if( board.get(i).get(y).getOwner() != null ){
                    
                    
                    board.get(i-1).get(y).setMap(player);
                    
                    return true;
                }
            }
            board.get(this.height-1).get(y).setMap(player);
            return true;
    }
    
}
