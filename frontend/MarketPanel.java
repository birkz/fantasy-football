package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

public class MarketPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField field;


	/**
	 * Create the panel.
	 */
	public MarketPanel() {
		setLayout(new BorderLayout(0, 0)); 
		
		field = new JTextField();
		field.setPreferredSize(new Dimension(150, 30));
		field.addKeyListener(new KeyListener(){
        	
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					System.out.println(field.getText() );
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(field.getText() );
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JButton search = new JButton("SEARCH");
		search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(e.getActionCommand() );
            }
        }); 

		List<String> choices = Arrays.asList("CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6");
		List<String> choices2 = Arrays.asList("CHOICE 7","CHOICE 8", "CHOICE 9","CHOICE 10","CHOICE 11","CHOICE 12");
		
		JPanel main = new JPanel();
		JScrollPane scroll = new JScrollPane(main);
		
		JPanel wrapper = new JPanel();
		wrapper.add(field);
		wrapper.add(addComboBox(choices));
		wrapper.add(addComboBox(choices2));
		wrapper.add(search);
		
		add(wrapper, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
	}
	
	public JPanel createEntry() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("hello what's up?"));
		return panel;
	}
	
	public JComboBox<String> addComboBox(List<String> choices) {
		String[] choose = new String[choices.size()];
		for(int i=0; i<choices.size(); ++i) {
			choose[i] = choices.get(i);
		}
		final JComboBox<String> cb = new JComboBox<String>(choose);
		cb.setVisible(true);
		cb.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e)
            {
            	JComboBox<String> cb = (JComboBox<String>) e.getSource();
                String chosen = (String)cb.getSelectedItem();
                System.out.println(chosen);
            }
        }); 
		return cb;
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }

}
