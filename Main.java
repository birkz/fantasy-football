import javax.swing.*;

public class Main {
	
	private static JFrame f;
	
	static public void createAndShowGUI() {
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 750);
        f.setLocationRelativeTo(null);
        //f.pack();
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
