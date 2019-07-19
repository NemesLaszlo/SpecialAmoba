
package amoba;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class AmobaGUI {
    private JFrame frame;
    private BoardGUI boardGUI;

    /**
     * A GUI felület megtestesítése
     * a BoardGUI hívása maga a játék lebonyolításának a vizuális kivitelezése
     * a menü szerkezetének felépítése, lehetőségek megválasztásának biztosítása
     * 
     */
    public AmobaGUI() {
        frame = new JFrame("Amoba");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenu newGame = new JMenu("New Game");
        gameMenu.add(newGame);
        //Game Modes
        int [] boardSizes = new int[] {8,10,12};
        int [] boardSizes2 = new int[] {5,6,7};
        boardGUI =new BoardGUI(8,10);
        frame.getContentPane().add(boardGUI.getBoardPanel(),BorderLayout.CENTER);
        for(int i =0; i< boardSizes.length; ++i){
            int y = boardSizes[i];
            int x = boardSizes2[i];
            JMenuItem newMenuItem = new JMenuItem(boardSizes[i] + " x " + boardSizes2[i]);
            newMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(boardGUI.getBoardPanel());
                boardGUI =new BoardGUI(x,y);
                
                frame.getContentPane().add(boardGUI.getBoardPanel(),BorderLayout.CENTER);
                frame.pack();
                }
            } );
            newGame.add(newMenuItem);
        }
        
        
       
        frame.pack();
        frame.setVisible(true);
    }
    
    
}
