package fantasy_football;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	
	private static JFrame f;
	private static AddImage panel3;
	
	static public void createAndShowGUI() {
		//AddImage panel = new AddImage(new ImageIcon("src/Images/CetpbfB.png").getImage());
		//AddImage panel2 = new AddImage(new ImageIcon("src/Images/hair_dryer_breakfast.png").getImage());
		panel3 = new AddImage(new ImageIcon("src/Images/jetpack_speeding.png").getImage());
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("Testing!!");
        //Add action listener to button
        button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You clicked the button");	
				switchImage(new AddImage(new ImageIcon("src/Images/hair_dryer_breakfast.png").getImage()));
			}
        }); 
		f.setLayout(new GridLayout(2, 1));
	    f.add(button);
		f.getContentPane().add(panel3);
	    f.pack();
        f.setVisible(true);
	}
	
	static public void switchImage(AddImage panel) {
		f.getContentPane().remove(panel3);
		panel3 = panel;
		f.getContentPane().add(panel);
	    f.pack();
        f.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                createAndShowGUI();
            }
        });
	}
}


