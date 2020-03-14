import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class HelpWindow extends JFrame {
	
	JLabel label;
	JFrame frame;
	JPanel contentPane;
	
	public HelpWindow() {

		label = new JLabel("Hello");
		contentPane.add(label);
		
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
