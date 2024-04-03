import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// By extending the class with JFrame, it acts like a screen
// By implementing action listener, you set up objects to respond to events that occur (like clicking buttons)
public class QuizFrame extends JFrame implements ActionListener {

	// Label
	JLabel multipleChoiceLabel = new JLabel("Multiple Choice");

	// Text Area
	JTextArea scoreText = new JTextArea();
	JTextArea textArea = new JTextArea();

	// Panels
	JPanel topPanel = new JPanel();
	JPanel middlePanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JPanel scoreBackground = new JPanel();

	// Orange lines
	JPanel linePanel = new JPanel();
	JPanel linePanel2 = new JPanel();

	// Scroll Pane
	JScrollPane scrollPane;

	// Colours
	Color backgroundColour = new Color(39, 56, 157); // Blue
	Color whiteColour = new Color(255, 255, 255); // White
	Color orangeColour = new Color(255, 137, 0); // Orange
	Color lightOrangeColour = new Color(255, 199, 33); // Light orange
	Color blackColour = new Color(0, 0, 0); // Temporary colour

	// Buttons
	JButton submitButton = new JButton("Submit");
	JButton backButton = new JButton("Back");

	// Tracks the score
	private static int score = 0;

	// Creates a radio button array for the buttons
	private JRadioButton[] buttonsArray = new JRadioButton[9];

	// Creates a label array for the questions
	private JLabel[] questionsArray = new JLabel[3];

	// Creates a string array for the questions
	private String[] questionsStringArray = { "1. The term that we use to describe methods is...?",
			"2. private [blank] void RollDice(int numRolls)", "3. Parameters... ",

	}; // Thanks Frank for clearing up my clouded mind with this!

	// Creates a string array for the buttons
	private String[] buttonsStringArray = {

			"Divisor", // Index 0
			"Divide and Conquer", 
			"Strategic Approach",

			"static", // Index 3
			"Static", 
			"None of the above",

			"Receive data", // Index 6
			"Send information", 
			"Are arguments",

	};

	// Quiz Frame Constructor
	public QuizFrame() {

		// Frame constructor
		setSize(1440, 900);
		setLayout(null); // No particular layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When user clicks on the X button, it closes the program
		setResizable(false); // Disables frame resizing

		// Sets the title of the frame
		setTitle("Quiz Frame");

		// Line panel
		linePanel.setBounds(0, 127, 1440, 10);
		linePanel.setBackground(orangeColour);

		add(linePanel);

		linePanel2.setBounds(0, 664, 1440, 10);
		linePanel2.setBackground(orangeColour);

		add(linePanel2);

		// Top panel
		topPanel.setBounds(0, 0, 1440, 127);
		topPanel.setBackground(backgroundColour);
		topPanel.setLayout(null);

		add(topPanel);

		// Multiple Choice label
		multipleChoiceLabel.setBounds(20, 20, 1440, 50);
		multipleChoiceLabel.setFont(new Font("Arial", Font.BOLD, 24));
		multipleChoiceLabel.setForeground(whiteColour);

		topPanel.add(multipleChoiceLabel);

		// Middle Panel
		middlePanel.setBounds(0, 137, 1440, 529);
		middlePanel.setLayout(null);
		middlePanel.setBackground(whiteColour);

		// Score Panel and Text Area
		scoreBackground.setBounds(0, 0, 1440, 700);
		scoreBackground.setLayout(null);
		scoreBackground.setBackground(backgroundColour);

		scoreText.setBounds(100, 60, 400, 50);

		scoreText.setFont(new Font("Arial", Font.BOLD, 18));
		scoreText.setBackground(backgroundColour);
		scoreText.setForeground(whiteColour);

		scoreText.setText("Your score is: 0/3");

		scoreText.setEditable(false);

		topPanel.add(scoreText);

		// Bottom Panel
		bottomPanel.setBounds(0, 667, 1440, 327);
		bottomPanel.setBackground(backgroundColour);
		bottomPanel.setLayout(null);

		add(bottomPanel);

		// Back Button
		backButton.setBounds(20, 50, 150, 100);
		backButton.setFont(new Font("Arial", Font.BOLD, 24));
		backButton.setBackground(lightOrangeColour);
		backButton.setForeground(blackColour);

		backButton.addActionListener(this);

		bottomPanel.add(backButton);

		// Submit button
		submitButton.setBounds(200, 50, 150, 100);
		submitButton.setFont(new Font("Arial", Font.BOLD, 24));
		submitButton.setBackground(lightOrangeColour);
		submitButton.setForeground(blackColour);

		submitButton.addActionListener(this);

		bottomPanel.add(submitButton);

		// Button Group
		// Link: https://youtu.be/bn2KdCLqHlg
		ButtonGroup groupQ1 = new ButtonGroup();
		ButtonGroup groupQ2 = new ButtonGroup();
		ButtonGroup groupQ3 = new ButtonGroup();

		// Initialize the x and y coordinates with their starting values
		int x = 20;
		int y = 50;

		// For the index 0 to the length of the array, construct the questions
		for (int index = 0; index < questionsArray.length; index++) {

			questionsArray[index] = new JLabel(questionsStringArray[index]);
			questionsArray[index].setBounds(x, 0, 500, 100);
			questionsArray[index].setFont(new Font("Arial", Font.BOLD, 16));
			questionsArray[index].setForeground(blackColour);

			middlePanel.add(questionsArray[index]);

			// Increases the x value for every question
			x += 480;

			// Increasing the x and y values and resetting them is really efficient. Thanks
			// Frank for the idea!

		}

		// For the index 0 to 2 in the button array, construct them
		for (int index = 0; index <= 2; index++) {

			buttonsArray[index] = new JRadioButton(buttonsStringArray[index]);
			buttonsArray[index].setBounds(20, y, 200, 100);
			buttonsArray[index].setFont(new Font("Arial", Font.BOLD, 14));
			buttonsArray[index].setForeground(blackColour);

			buttonsArray[index].addActionListener(this);

			// Adds the buttons of the first question to the first group
			groupQ1.add(buttonsArray[index]);

			middlePanel.add(buttonsArray[index]);

			// Increases the y value for every button
			y += 50;

		}

		// Resets y value back to 50
		y = 50;

		// For the index 3 to 5 in the button array, construct them
		for (int index = 3; index <= 5; index++) {

			buttonsArray[index] = new JRadioButton(buttonsStringArray[index]);
			buttonsArray[index].setBounds(500, y, 200, 100);
			buttonsArray[index].setFont(new Font("Arial", Font.BOLD, 14));
			buttonsArray[index].setForeground(blackColour);

			buttonsArray[index].addActionListener(this);

			// Adds the buttons of the second question to the second group
			groupQ2.add(buttonsArray[index]);

			middlePanel.add(buttonsArray[index]);

			// Increases the y value for every button
			y += 50;

		}

		// Reset y value back to 50
		y = 50;

		// For the index 6 to 8 in the button array, construct them
		for (int index = 6; index <= 8; index++) {

			buttonsArray[index] = new JRadioButton(buttonsStringArray[index]);
			buttonsArray[index].setBounds(980, y, 200, 100);
			buttonsArray[index].setFont(new Font("Arial", Font.BOLD, 14));
			buttonsArray[index].setForeground(blackColour);

			buttonsArray[index].addActionListener(this);
			groupQ3.add(buttonsArray[index]);

			middlePanel.add(buttonsArray[index]);

			// Increases the y value for every button
			y += 50;

		}

		// Adds the middle panel onto the frame
		add(middlePanel);

		// Makes the frame visible
		setVisible(true);

	}

	// Listens to the actions performed (e.g. clicking a button) and proceeds
	// accordingly
	@Override
	public void actionPerformed(ActionEvent event) {

		// If the user clicks on the submit button, call the congrats frame
		if (event.getSource() == submitButton)

			new CongratsFrame();

		// Otherwise if the user clicks on the back button, go to the menu frame
		else if (event.getSource() == backButton) {

			new MenuFrame();

		}

		// If the user clicks on the correct buttons, increase the score
		else if (event.getSource() == buttonsArray[1] || event.getSource() == buttonsArray[3]
				|| event.getSource() == buttonsArray[6]) {

			score++;
			scoreText.setText("Your score is: " + score + "/3");

		}

		// Otherwise, if the user clicks on other buttons, decrease the score
		else if (event.getSource() != buttonsArray[1] || event.getSource() != buttonsArray[3]
				|| event.getSource() != buttonsArray[6]) {

			score--;
			scoreText.setText("Your score is: " + score + "/3");

		}

	} // End of actionPerformed

	// Gets the score to use it in Quiz Frame
	public static int getScore() {
		return score;
	}

} // End of class

/**
 * My previous codes
 */

// Labels

//JLabel question1Label = new JLabel("1. The term that we use to describe methods is...");
//JLabel question2Label = new JLabel("2. Question fill in the blanks");
//JLabel question3Label = new JLabel("3. Question uhhhh?");
//
//JLabel background = new JLabel();

//// Question 1
//JRadioButton q1Button1 = new JRadioButton("Divisor");
//JRadioButton q1Button2 = new JRadioButton("Divide and Conquer");
//JRadioButton q1Button3 = new JRadioButton("Strategic Approach");
//
//// Question 2
//JRadioButton q2Button1 = new JRadioButton("A");
//JRadioButton q2Button2 = new JRadioButton("B");
//JRadioButton q2Button3 = new JRadioButton("C");
//
//// Question 3
//JRadioButton q3Button1 = new JRadioButton("A");
//JRadioButton q3Button2 = new JRadioButton("B");
//JRadioButton q3Button3 = new JRadioButton("C");

//add(scoreBackground);

// Scroll Pane

// scrollPane.setLayout(null);
// scrollPane.setBackground(whiteColour);

//// Question 1
//question1Label.setBounds(20, 0, 500, 100);
//question1Label.setFont(new Font("Arial", Font.BOLD, 16));
//question1Label.setBackground(lightOrangeColour);
//question1Label.setForeground(blackColour);
//
//middlePanel.add(question1Label);
//
//// Question 2
//question2Label.setBounds(500, 0, 500, 100);
//question2Label.setFont(new Font("Arial", Font.BOLD, 16));
//question2Label.setForeground(blackColour);
//
//middlePanel.add(question2Label);

//// Button 1
//q1Button1.setBounds(20, 50, 500, 100);
//q1Button1.setFont(new Font("Arial", Font.BOLD, 14));
//q1Button1.setForeground(blackColour);
//
//q1Button1.addActionListener(this);
//
//middlePanel.add(q1Button1);
//
//// Button 2
//q1Button2.setBounds(20, 150, 500, 100);
//q1Button2.setFont(new Font("Arial", Font.BOLD, 14));
//q1Button2.setForeground(blackColour);
//
//q1Button2.addActionListener(this);
//middlePanel.add(q1Button2);
//
//// Button 3
//q1Button3.setBounds(20, 200, 500, 100);
//q1Button3.setFont(new Font("Arial", Font.BOLD, 14));
//q1Button3.setForeground(blackColour);
//
//q1Button3.addActionListener(this);
//middlePanel.add(q1Button3);
//
////// Question 2
////question2Label.setBounds(500, 0, 500, 100);
////question2Label.setFont(new Font("Arial", Font.BOLD, 16));
////question2Label.setForeground(blackColour);
////
////middlePanel.add(question2Label);
//
//// Button 1
//q2Button1.setBounds(500, 50, 500, 100);
//q2Button1.setFont(new Font("Arial", Font.BOLD, 14));
//q2Button1.setForeground(blackColour);
//
//q2Button1.addActionListener(this);
//middlePanel.add(q2Button1);
//
//// Button 2
//q2Button2.setBounds(500, 150, 500, 100);
//q2Button2.setFont(new Font("Arial", Font.BOLD, 14));
//q2Button2.setForeground(blackColour);
//
//q2Button2.addActionListener(this);
//middlePanel.add(q2Button2);
//
//// Button 3
//q2Button3.setBounds(500, 200, 500, 100);
//q2Button3.setFont(new Font("Arial", Font.BOLD, 14));
//q2Button3.setForeground(blackColour);
//
//q2Button3.addActionListener(this);
//middlePanel.add(q2Button3);
//
//// Question 3
//question3Label.setBounds(600, 500, 700, 100);
//question3Label.setFont(new Font("Arial", Font.BOLD, 16));
//question3Label.setForeground(blackColour);
//
//middlePanel.add(question3Label);
//
//// Button 1
//q3Button1.setBounds(600, 600, 500, 100);
//q3Button1.setFont(new Font("Arial", Font.BOLD, 14));
//q3Button1.setForeground(blackColour);
//
//q3Button1.addActionListener(this);
//middlePanel.add(q3Button1);
//
//// Button 2
//q3Button2.setBounds(600, 700, 500, 100);
//q3Button2.setFont(new Font("Arial", Font.BOLD, 14));
//q3Button2.setForeground(blackColour);
//
//q3Button2.addActionListener(this);
//middlePanel.add(q3Button2);
//
//// Button 3
//q3Button3.setBounds(600, 800, 500, 100);
//q3Button3.setFont(new Font("Arial", Font.BOLD, 14));
//q3Button3.setForeground(blackColour);
//
//q3Button3.addActionListener(this);
//middlePanel.add(q3Button3);

// Attempted Code

// background.setIcon(new ImageIcon("images/blankPage.jpg"));

//scrollPane = new JScrollPane(middlePanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//scrollPane.getViewport().setMinimumSize(new Dimension(500,300));
//scrollPane.getViewport().setPreferredSize(new Dimension(500,300));
//scrollPane.setBounds(0, 137, 1000, 529);

// add(scrollPane);
