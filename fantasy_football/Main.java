package fantasy_football;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {
	
	private static JFrame frame;
	private static JPanel left;
	private static JPanel right;
	private static JPanel change;
	
	static public void createAndShowGUI() {
		frame = new JFrame();
		JPanel startPanel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton startButton = new JButton("One Player");
		JButton startButton2 = new JButton("Two Players");
		JButton startButton3 = new JButton("Three Players");
		
        //Add action listener to button
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				startGame(startPanel);
			}
        }); 
		
		startPanel.setBorder(new EmptyBorder(100, 100, 100, 100));
		startPanel.setLayout(new GridLayout(3, 1, 5, 5));
		startPanel.add(startButton);
		startPanel.add(startButton2);
		startPanel.add(startButton3);
		
		frame.add(startPanel);
	    frame.pack();
        frame.setVisible(true);
	}
	
	public static void startGame(JPanel startPanel) {
		frame.remove(startPanel);
		AddImage panel = new AddImage(new ImageIcon("src/Images/CetpbfB.png").getImage());
		AddImage panel2 = new AddImage(new ImageIcon("src/Images/hair_dryer_breakfast.png").getImage());
		AddImage panel3 = new AddImage(new ImageIcon("src/Images/jetpack_speeding.png").getImage());
		JPanel buttons = new JPanel();
		left = new JPanel();
		right = new JPanel();
		change = new JPanel();
		JButton button = new JButton("New Panel");
		
        //Add action listener to button
        button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchImage(new AddImage(new ImageIcon("src/Images/jetpack_speeding.png").getImage()));
			}
        }); 
        JButton button2 = new JButton("Old panel");
        //Add action listener to button
        button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchImage(new AddImage(new ImageIcon("src/Images/CetpbfB.png").getImage()));
			}
        }); 

        buttons.add(button);
        buttons.add(button2);
        frame.setLayout(new BorderLayout(0, 0));
		
		frame.add(left, BorderLayout.WEST);
		
		frame.add(right, BorderLayout.EAST);
		
		left.setBorder(new EmptyBorder(5, 5, 5, 5));
		left.setLayout(new BorderLayout(0, 0));
		left.add(buttons, BorderLayout.NORTH);
		change.add(panel);
		left.add(change, BorderLayout.SOUTH);
		
		right.setBorder(new EmptyBorder(5, 5, 5, 5));
		right.setLayout(new BorderLayout(0, 0));
		right.add(panel3, BorderLayout.NORTH);
		right.add(panel2, BorderLayout.SOUTH);
		
	    frame.pack();
        frame.setVisible(true);
	}
	
	static public void switchImage(AddImage panel) {
		change.removeAll();
		change.add(panel);
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


