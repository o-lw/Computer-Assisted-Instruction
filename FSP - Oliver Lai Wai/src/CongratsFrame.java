import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

//By extending the class with JFrame, it acts like a screen
//By implementing action listener, you set up objects to respond to events that occur (like clicking buttons)
public class CongratsFrame extends JFrame implements ActionListener {

	// Label
	JLabel backgroundGif = new JLabel(new ImageIcon("images/dancingBanana.gif"));

	// Button
	JButton backButton = new JButton("Back");

	// Text Area
	JTextArea scoreText = new JTextArea();

	// Congrats Frame Constructor
	public CongratsFrame() {

		// Frame constructor
		setSize(550, 367);
		setLayout(null); // No particular layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When user clicks on the X button, it closes the program
		setResizable(false); // Disables frame resizing

		// Sets the title of the frame
		setTitle("Congrats Frame");

		// Back Button
		backButton.setBounds(50, 100, 100, 50);
		backButton.addActionListener(this);

		backgroundGif.add(backButton);

		// Score Text
		scoreText.setBounds(50, 50, 240, 20);

		// Add the score to the background
		backgroundGif.add(scoreText);

		// Background
		backgroundGif.setBounds(0, 0, 550, 367);
		add(backgroundGif);

		// Run the score checker method
		scoreChecker();

		// Makes the frame visible
		setVisible(true);

	}

	// Listens to the actions performed (e.g. clicking a button) and proceeds accordingly
	@Override
	public void actionPerformed(ActionEvent event) {

		// If the user clicks on the back button, load up the menu frame
		if (event.getSource() == backButton)

			new MenuFrame();

	}

	// Method that checks the score
	public void scoreChecker() {

		// If the score is less than 0 (you'll see on the label on top in the Quiz
		// Frame)
		if (QuizFrame.getScore() < 0) {

			// Set the score to 0
			scoreText.setText("Congratulations! Your score is: 0/3");
			scoreText.setEditable(false);

		}

		// Otherwise set the score to the current score
		else {
			scoreText.setText("Congratulations! Your score is: " + QuizFrame.getScore() + "/3");
			scoreText.setEditable(false);

		}

	}

} // End of class
