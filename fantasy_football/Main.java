package fantasy_football;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {
	
	private static JFrame frame;
	private static AddImage left;
	private static AddImage right;
	private static JPanel innerPanel;
	
	static public void createAndShowGUI() {
		//AddImage panel = new AddImage(new ImageIcon("src/Images/CetpbfB.png").getImage());
		right = new AddImage(new ImageIcon("src/Images/hair_dryer_breakfast.png").getImage());
		left = new AddImage(new ImageIcon("src/Images/jetpack_speeding.png").getImage());
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		innerPanel = new JPanel();
		JPanel buttons = new JPanel();
		
		JButton button = new JButton("New Panel");
        //Add action listener to button
        button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchImage(new AddImage(new ImageIcon("src/Images/CetpbfB.png").getImage()));
			}
        }); 
        JButton button2 = new JButton("Old panel");
        //Add action listener to button
        button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchImage(new AddImage(new ImageIcon("src/Images/jetpack_speeding.png").getImage()));
			}
        }); 

        buttons.add(button);
        buttons.add(button2);
		
		
		innerPanel = new JPanel();
		innerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		innerPanel.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(innerPanel);
		
		innerPanel.add(left, BorderLayout.WEST);
		
		innerPanel.add(right, BorderLayout.EAST);
		
		innerPanel.add(buttons, BorderLayout.NORTH);
		
	    frame.pack();
        frame.setVisible(true);
	}
	
	static public void switchImage(AddImage panel) {
		innerPanel.remove(left);
		left = panel;
		innerPanel.add(left);
		innerPanel.setVisible(true);
		frame.pack();
        frame.setVisible(true);
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


