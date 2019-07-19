package amoba;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BoardGUI {
    private ArrayList<ArrayList<JButton>> buttons;
    private Board board;
    private JPanel BoardPanel;
    private Player p  = new Player('X');
    private Player p2 = new Player('O');
    private Player curr;
    private ButtonListener listener;
    
    /**
     * Konstruktorban, a megfelelő paraméterekkel létrehozzuk a boardot.
     * Megtörténik a panel kialakítása a gombokkal, és azon elrendezése.
     * Kialakul a játékmező, és meghívásra kelül a ButtonListener.
     *  
     */
    public BoardGUI(int height,int width) {
        board = new Board(height,width);
        curr = p;
        buttons = new ArrayList<>();
        BoardPanel = new JPanel();
        BoardPanel.setLayout(new GridLayout(height,width));
        for(int i = 0; i < height; ++i){
            ArrayList<JButton> row = new ArrayList<>();
            for(int j = 0; j < width; ++j){
                JButton button = new JButton();
                listener = new ButtonListener(i,j);
                button.addActionListener( listener );
                row.add(button);
                BoardPanel.add(button);
                button.setPreferredSize(new Dimension(80,40));
            }
            buttons.add(row);
        }
        
    }
    
    /**
     *Lekérdezésre kerül a BoardPanel 
     *
     */
    public JPanel getBoardPanel() {
        return BoardPanel;
    }
    /**
     * A játékmező tisztítása, új játékhoz.
     */
    public void clearTable() {
        for (int i = 0; i < board.getHeight(); i++) {
        for (int j = 0; j < board.getWidth(); j++) { 
            board.clear();
        }}
    }
    
    /**
     * A győztes keresése / ellenőrzése vízszintesen megvan-e neki a 4 azonos jel.
     * 
     */
    public boolean hasHorizontalWin(Board board,Player p) {
    int count = 0;
    for (int i = 0; i < board.getHeight(); i++) {
        for (int j = 0; j < board.getWidth(); j++) {
            if (board.get(i,j).getOwner() == p){
                count++;
                if (count == 4){
                    
                    return true;
                }
            }
            else{
                count = 0; 
            }
        }
    }
    return false;
}
   /**
    * A győztes keresése / ellenőrzése
    * jobb átló alapján történő vizsgála, hogy meg van-e a 4 azonos jel.
    * 
    */
        public boolean hasRtr(Board board,Player p){
        int count= 0;
        for (int i = 0; i < board.getHeight(); i++) {
        for (int j = 0; j < board.getWidth(); j++) { 
        if(board.get(i,j).getOwner() == p) {
                count++;
            for(int k=1;k<4;k++){
                if(i-k>=0 && j+k<board.getHeight()) {
                    if(board.get(i-k,j+k).getOwner() == p) {
                        count++;
                        if(count == 4) {
                            return true;
                        }
                    }
                    else {
                        count = 0;
                    }
                }
            }
        }  
        }}
        return false;
    }
    
        /**
        * A győztes keresése / ellenőrzése
        * bal átló alapján történő vizsgála, hogy meg van-e a 4 azonos jel.
        * 
        */
    public boolean hasLtr(Board board,Player p){
        int count= 0;
        for (int i = 0; i < board.getHeight(); i++) {
        for (int j = 0; j < board.getWidth(); j++) { 
            if(board.get(i,j).getOwner() == p) {
                count++;
                for(int k=1;k<4;k++){
                if(i+k<board.getHeight() && j+k<board.getWidth()) {
                    if(board.get(i+k,j+k).getOwner() == p) {
                        count++;
                        if(count == 4) {
                            return true;
                        }
                    }
                    else {
                        count = 0;
                    }
                }
            }
            }
            
        }}
        return false;
    }
    
    /**
     *  Függőleges ellenőrzése a győzelemnek
     * szintén a 4 azonos jel tesztelése
     */
    public boolean hasVerticalWin(Board board,Player p) {
    int count = 0;
    for (int i = 0; i < board.getWidth(); i++) {
        for (int j = 0; j < board.getHeight(); j++) {
            if (board.get(j,i).getOwner() == p){
                count++;
                if (count == 4){
                    
                    return true;
            }
            }
            else{
                count = 0;
                
            }
       
        }
    }
    return false;

}
    /**
     * Maga a frissítés itt történik a jel beírásának, a megfelelő helyre való helyesése "leesése".
     * Emelett a fenti különböző győzelmi esetek tesztelése minden jel beírása után.
     * És a Döntetlen játék ellenőrzése.
     */
    public void refresh(){
        int count=0;
        boolean gameOver = false;
        for(int i = 0; i < board.getHeight() ; ++i){
           
            for(int j = 0; j < board.getWidth(); ++j){
                if(board.get(i,j).getOwner() != null) {
                    buttons.get(i).get(j).setText(board.get(i,j).getOwner().toChar().toString());
                    count++;
                }
                else {
                     buttons.get(i).get(j).setText("");
                }
            }
        }
       if(count == board.getHeight()*board.getWidth()) {
            JOptionPane.showMessageDialog(BoardPanel, "Döntetlen!");
            gameOver = true;
            
        }
        if(hasHorizontalWin(board,p) || hasVerticalWin(board,p) || hasLtr(board,p) || hasRtr(board,p) ) {
            JOptionPane.showMessageDialog(BoardPanel, "X nyert!");
            gameOver = true;
        }
        if(hasHorizontalWin(board,p2) || hasVerticalWin(board,p2) || hasLtr(board,p2) || hasRtr(board,p2) ) {
            JOptionPane.showMessageDialog(BoardPanel, "O nyert!");
            gameOver = true;
        }
        if(!gameOver){
        changePlayer();
        }
        else {
            clearTable();
            refresh();
        }
    }
    
    /**
     * A jétékosok cseréje, a jel leírása után a következő játékos jön
     */
    public void changePlayer(){
        
        if(curr == p){
            curr = p2;
        }
        else { curr = p; }
    }
    
    /**
     *  Az esemény kezelő.
     * ha a játékos tud jelet rakni akkor azt a refresh() metódus hívással a megfelelő helyre teszi, 
     * és ellenőrzi a győzelmet, döntetlent
     */
    class ButtonListener implements ActionListener{
        
        private int x;
        private int y;
        
        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
           
            if(board.klick(this.x, this.y, curr)){
                refresh();
                
            }
           
        }
    }
    
}
