import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//By extending the class with JFrame, it acts like a screen
//By implementing action listener, you set up objects to respond to events that occur (like clicking buttons)
public class ActivityStartFrame extends JFrame implements ActionListener{

	// Buttons
	JButton enterButton = new JButton("Enter");
	JButton backButton = new JButton("Back");	
	
	// Labels
	JLabel background = new JLabel();
	JLabel backgroundImage = new JLabel();
	
	// Activity Start Frame Constructor
	public ActivityStartFrame() {
		
		// Frame constructor
		setSize(1440, 900);
		setLayout(null); // No particular layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When user clicks on the X button, it closes the program
		setResizable(false); // Disables frame resizing
		backgroundImage.setLayout(null);
		
		// Sets the title of the frame
		setTitle("Activity Starting Frame");
		
		// Colours
		Color black = new Color(0, 0, 0);
		Color beige = new Color(255, 242, 204);
		
		// Background image constructor
		backgroundImage.setIcon(new ImageIcon("images/dino intro (1).jpg"));
		backgroundImage.setBounds(0, 0, 1440, 900);
		
		// Adds the background image to the frame
		add(backgroundImage);

		
		// Enter button
		enterButton.setBounds(620, 500, 200, 100);
		enterButton.setFont(new Font("Arial", Font.BOLD, 24));
		enterButton.setForeground(black);
		enterButton.setBackground(beige);
		
		enterButton.addActionListener(this);
		
		// Adds the button to the background image
		backgroundImage.add(enterButton);
		
		
		// Back button
		backButton.setBounds(100, 700, 200, 100);
		backButton.setFont(new Font("Arial", Font.BOLD, 24));
		backButton.setForeground(black);
		backButton.setBackground(beige);
		
		backButton.addActionListener(this);
		
		// Adds the button to the background image
		backgroundImage.add(backButton);
		
		// Makes the frame visible
		setVisible(true);
		
	} // End of ActivityStartFrame()
	
	// Listens to the actions performed (e.g. clicking a button) and proceeds accordingly
	@Override
	public void actionPerformed(ActionEvent event) {
		
		// If the user clicks on enter button
		if (event.getSource() == enterButton) 
			
			// Load the activity game frame
			new ActivityGameFrame();
		
		// Otherwise
		else
			
			// Call the menu frame
			new MenuFrame();
		
	} // End of action performed

} // End of class
