
package amoba;

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class AmobaGUI {
    private JFrame frame;
    private BoardGUI boardGUI;

    public AmobaGUI() {
        frame = new JFrame("Amoba");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         boardGUI = new BoardGUI(10,10);
        frame.getContentPane().add(boardGUI.getBoardPanel(),BorderLayout.CENTER);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    
}
