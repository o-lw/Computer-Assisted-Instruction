import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//By extending the class with JFrame, it acts like a screen
//By implementing action listener, you set up objects to respond to events that occur (like clicking buttons)
public class MenuFrame extends JFrame implements ActionListener {

	// Labels
	JLabel background = new JLabel();
	JLabel logoLabel = new JLabel();

	// Text Area
	JTextArea sloganText = new JTextArea();
	JTextArea topicText = new JTextArea();
	JTextArea gameText = new JTextArea();

	// Panels
	JPanel linePanel = new JPanel();

	// Colours
	Color backgroundColour = new Color(39, 56, 157); // Blue
	Color fontColour = new Color(255, 255, 255); // White
	Color orangeColour = new Color(255, 137, 0); // Orange
	Color blackColour = new Color(0, 0, 0);

	// Creates a buttons array
	private JButton[] buttonsArray = new JButton[3];

	// Creates a string array for the buttons
	private String[] buttonsStringArray = {

			"Start learning now!", "Game (WIP)", "Test your knowledge!",

	};

	// Menu Frame Constructor
	public MenuFrame() {

		// Frame Constructor
		setSize(1440, 900);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		background.setLayout(null);

		// Sets the title of the frame
		setTitle("Menu Frame");

		// Slogan Text
		sloganText.setText("Welcome to Codify, your\ninteractive learning platform\nfor computer programming.");

		sloganText.setBounds(120, 150, 1000, 300);
		sloganText.setFont(new Font("Arial", Font.BOLD, 42));
		sloganText.setForeground(fontColour);

		// Makes the background of the slogan transparent
		sloganText.setOpaque(false);

		// Text cannot be changed by the user
		sloganText.setEditable(false);

		// Adds to the background
		background.add(sloganText);

		// Today's Topic Text
		topicText.setText("Today's topic: Methods");

		topicText.setBounds(120, 350, 1000, 100);
		topicText.setFont(new Font("Arial", Font.BOLD, 32));
		topicText.setForeground(fontColour);

		topicText.setOpaque(false);
		topicText.setEditable(false);

		background.add(topicText);

		// Today's Game Text
		gameText.setText("Today's Game: Dino Park");

		gameText.setBounds(590, 740, 1000, 300);
		gameText.setFont(new Font("Arial", Font.BOLD, 18));
		gameText.setForeground(fontColour);

		gameText.setOpaque(false);
		gameText.setEditable(false);

		background.add(gameText);

		// Line Panel
		linePanel.setBounds(120, 320, 650, 5);
		linePanel.setBackground(orangeColour);

		background.add(linePanel);

		// Sets the starting value for x
		int x = 230;

		// From index 0 to the length of the array, construct the buttons
		for (int index = 0; index < buttonsArray.length; index++) {

			buttonsArray[index] = new JButton(buttonsStringArray[index]);
			buttonsArray[index].setBounds(x, 520, 300, 200);
			buttonsArray[index].setFont(new Font("Arial", Font.BOLD, 24));
			buttonsArray[index].setBackground(orangeColour);
			buttonsArray[index].setForeground(blackColour);

			buttonsArray[index].addActionListener(this);

			background.add(buttonsArray[index]);

			// Increases the x value for every button
			x += 330;
		}

		// Codify Logo
		logoLabel.setIcon(new ImageIcon("images/Robot assistant.jpg"));

		logoLabel.setBounds(820, 70, 420, 362);
		background.add(logoLabel);

		// Background constructor
		background.setBounds(0, 0, 1440, 900);
		background.setOpaque(true);
		background.setBackground(backgroundColour);

		add(background);

		// Makes the frame visible
		setVisible(true);

	} // End of MenuFrame

	// Listens to the actions performed (e.g. clicking a button) and proceeds
	// accordingly
	@Override
	public void actionPerformed(ActionEvent event) {

		// If the user clicks on the concepts button, call the concepts frame
		if (event.getSource() == buttonsArray[0])

			new ConceptsFrame();

		// Otherwise if the user clicks on the activity button, call the activity start
		// frame
		else if (event.getSource() == buttonsArray[1])

			new ActivityStartFrame();

		// Otherwise call the quiz frame
		else

			new QuizFrame();

	} // End of action performed

} // End of MenuFrame class

/**
 * Previous codes
 */

//// Buttons
//JButton conceptsButton = new JButton("Start learning now!");
//JButton activityButton = new JButton("Play a game!");
//JButton quizButton = new JButton("Test your knowledge!");

//// Concepts button
//conceptsButton.setBounds(230, 520, 300, 200);
//conceptsButton.setFont(new Font("Arial", Font.BOLD, 24));
//conceptsButton.setBackground(orangeColour);
//
//conceptsButton.addActionListener(this);

//// Activity button
//activityButton.setBounds(560, 520, 300, 200);
//activityButton.setFont(new Font("Arial", Font.BOLD, 24));
//activityButton.setBackground(orangeColour);
//
//activityButton.addActionListener(this);

//// Quiz button
//quizButton.setBounds(900, 520, 300, 200);
//quizButton.setFont(new Font("Arial", Font.BOLD, 24));
//quizButton.setBackground(orangeColour);
//
//quizButton.addActionListener(this);

//// Adds each button to the background
//background.add(conceptsButton);
//background.add(activityButton);
//background.add(quizButton);
