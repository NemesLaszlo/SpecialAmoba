package amoba;

import java.util.ArrayList;


public class Board {
    
    
    private ArrayList<ArrayList<Field>> board;
    private final int wigth;
    private final int height;

    public Board(int wigth, int height) {
        this.wigth = wigth;
        this.height = height;
        board = new ArrayList<>();
        for(int i = 0; i < this.wigth; ++i){
            ArrayList<Field> row = new ArrayList<>();
            for(int j = 0; j < this.height; ++j){
                row.add(new Field());
            }
            board.add(row); 
        }
    }

    public int getWigth() {
        return wigth;
    }

    public int getHeight() {
        return height;
    }
    
     public Field get(int i,int j){
        return board.get(i).get(j);
    }
     
    public boolean klick(int x,int y,Player player){
        if(board.get(x).get(y) != null ){return false;}
            for(int i = y; i < this.height;++i){
                if( board.get(x).get(i) != null ){
                    board.get(x).get(i-1).setMap(player);
                    return true;
                }
            }
            board.get(x).get(this.height -1).setMap(player);
            return true;
    }
    
}
