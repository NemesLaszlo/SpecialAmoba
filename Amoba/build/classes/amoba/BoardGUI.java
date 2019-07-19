package amoba;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardGUI {
    private ArrayList<ArrayList<JButton>> buttons;
    private Board board;
    private JPanel BoardPanel;
    private Player p;

    public BoardGUI(int wigth,int height) {
        board = new Board(wigth,height);
        Player p = new Player('X');
        buttons = new ArrayList<>();
        BoardPanel = new JPanel();
        BoardPanel.setLayout(new GridLayout(wigth,height));
        for(int i = 0; i < wigth; ++i){
            ArrayList<JButton> row = new ArrayList<>();
            for(int j = 0; j < height; ++j){
                JButton button = new JButton();
                button.addActionListener(new ButtonListener(i,j) );
                row.add(button);
                BoardPanel.add(button);
                button.setPreferredSize(new Dimension(80,40));
            }
            buttons.add(row);
        }
        
    }
    
    public JPanel getBoardPanel() {
        return BoardPanel;
    }
    
    public void refresh(){
        for(int i = 0; i < board.getWigth() ; ++i){
            for(int j = 0; j < board.getHeight(); ++j){
                // null akkor semmi , ha nem az akkor azt kell beírni a buttonbe
            }
        }
    }
    
    public void changePlayer(){
    
    }
    
    
    class ButtonListener implements ActionListener{
        
        private int x;
        private int y;

        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(board.klick(x, y, p)){
                refresh();
                changePlayer();
            }
           
        }
    }
    
}
