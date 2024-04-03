import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// By extending the class with JFrame, it acts like a screen
// By implementing action listener, you set up objects to respond to events that occur (like clicking buttons)
public class ActivityGameFrame extends JFrame implements ActionListener {

	// Initializes the lives at 3
	int lives = 3;

	// Initializes the current panel at 1
	int currentPanel = 1;

	// Keeps the track of the order of the panels
	int numPanels = 1;

	// This array assigns images to each heart
	private static heartImages[] heartArray = new heartImages[3]; // [3] - the amount of ghosts

	// This array changes panels to panels
	private static JPanel[] numPanelsArray = new JPanel[5];

	// Panels
	JPanel topPanel = new JPanel();

	// Topic: Program Modules
	JPanel gamePanel1 = new JPanel();

	// Topic: static Methods
	JPanel gamePanel2 = new JPanel();

	// Topic:
	JPanel gamePanel3 = new JPanel();

	// Bottom panel (for buttons)
	JPanel bottomPanel = new JPanel();

	// Game over panel
	JPanel gameOverPanel = new JPanel();

	// Congrats panel
	JPanel congratsPanel = new JPanel();

	// Labels
	JLabel tacoDinoImage = new JLabel();
	JLabel heart1 = new JLabel();
	JLabel heart2 = new JLabel();
	JLabel heart3 = new JLabel();

	// Text area
	JTextArea rulesText = new JTextArea();
	JTextArea livesText = new JTextArea();

	// Game over text area
	JTextArea noLivesText = new JTextArea();

	// Buttons
	JButton backButton = new JButton("Back");
	JButton submitButton = new JButton("Submit");

	// Game over button
	JButton restartButton = new JButton();

	// Colours
	Color brown = new Color(137, 89, 39);
	Color beige = new Color(255, 242, 204);
	Color white = new Color(255, 255, 255);
	Color black = new Color(0, 0, 0);

	// Topic 1: Program Modules
	JCheckBox programDestroyer = new JCheckBox("Program Destroyer");
	JCheckBox divideConquer = new JCheckBox("Divide and Conquer");
	JCheckBox minecraft = new JCheckBox("Minecraft");
	JCheckBox cheese = new JCheckBox("Cheese and Mac?");

	// Topic 2: static Methods
	JCheckBox tacos = new JCheckBox("Keyword: Tacos?");
	JCheckBox mainMethod = new JCheckBox("main() method");
	JCheckBox mathPie = new JCheckBox("Math.Pie");
	JCheckBox MathPI = new JCheckBox("Math.PI");
	JCheckBox staticElectricity = new JCheckBox("STATIC ELECTRICITY!");
	JCheckBox classMethod = new JCheckBox("Class Method");

	// Activity Game Frame Constructor
	public ActivityGameFrame() {

		// Frame constructor
		setSize(1440, 900);
		setLayout(null); // No particular layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When user clicks on the X button, it closes the program
		setResizable(false); // Disables frame resizing

		// Sets the title of the frame
		setTitle("Game Frame");

		/**
		 * Main idea: I want to use arrays to change between different topics which are
		 * on different panels
		 */

		// Creates a panel array
		numPanelsArray[1] = new JPanel();
		numPanelsArray[2] = new JPanel();
		numPanelsArray[3] = new JPanel();

		// Assigns an array index to each panels
		gamePanel1 = numPanelsArray[1];
		gamePanel2 = numPanelsArray[2];
		gamePanel3 = numPanelsArray[3];

		// Rules text
		rulesText.setText("Rules: Click on the dinosaurs that are correct and relate to the given topic! Be careful of the tiny details!");
		rulesText.setBounds(20, 20, 1440, 127);
		rulesText.setFont(new Font("Arial", Font.BOLD, 24));
		rulesText.setForeground(white);

		// Makes the background of the rules text transparent
		rulesText.setOpaque(false);

		// Rules text cannot be changed by the user
		rulesText.setEditable(false);

		topPanel.add(rulesText);

		// Lives text
		livesText.setText("Lives:");
		livesText.setBounds(20, 100, 500, 200);
		livesText.setFont(new Font("Arial", Font.BOLD, 24));
		livesText.setForeground(white);

		// Makes the background of the lives text transparent
		livesText.setOpaque(false);

		// Lives text cannot be changed by the user
		livesText.setEditable(false);

		// Adds lives text to the game panel
		topPanel.add(livesText);

		// Top panel
		topPanel.setBounds(0, 0, 1440, 200);
		topPanel.setBackground(brown);
		topPanel.setLayout(null);

		add(topPanel);

		// Game panel 1
		gamePanel1.setBounds(0, 200, 1440, 500);
		gamePanel1.setBackground(beige);
		gamePanel1.setLayout(null);

		programDestroyer.setBounds(50, 100, 200, 50);
		programDestroyer.setFont(new Font("Arial", Font.BOLD, 15));

		divideConquer.setBounds(50, 200, 200, 50);
		divideConquer.setFont(new Font("Arial", Font.BOLD, 15));

		minecraft.setBounds(250, 100, 200, 50);
		minecraft.setFont(new Font("Arial", Font.BOLD, 15));

		cheese.setBounds(250, 200, 200, 50);
		cheese.setFont(new Font("Arial", Font.BOLD, 15));

		gamePanel1.add(programDestroyer);
		gamePanel1.add(divideConquer);
		gamePanel1.add(minecraft);
		gamePanel1.add(cheese);

		add(gamePanel1);

		// Game panel 2
		gamePanel2.setBounds(0, 200, 1440, 500);
		gamePanel2.setBackground(beige);
		gamePanel2.setLayout(null);

		// Add buttons for the second topic here
		//
		//

		// Game panel 3
		gamePanel3.setBounds(0, 200, 1440, 500);
		gamePanel3.setBackground(beige);
		gamePanel3.setLayout(null);

		// Add buttons for the third topic here
		//
		//

		// Bottom panel
		bottomPanel.setBounds(0, 700, 1440, 200);
		bottomPanel.setBackground(brown);
		bottomPanel.setLayout(null);

		add(bottomPanel);

		// Back Button
		backButton.setBounds(50, 50, 150, 70);
		backButton.setFont(new Font("Arial", Font.BOLD, 24));
		backButton.addActionListener(this);

		bottomPanel.add(backButton);

		// Submit Button
		submitButton.setBounds(300, 50, 150, 70);
		submitButton.setFont(new Font("Arial", Font.BOLD, 24));
		submitButton.addActionListener(this);

		bottomPanel.add(submitButton);

		// Dino Images
		tacoDinoImage.setIcon(new ImageIcon("images/dino icon template.png"));
		tacoDinoImage.setBounds(350, 100, 300, 300);

		// Adds the taco dino image to the game panel
		gamePanel1.add(tacoDinoImage);

		// Checkboxes
		tacos.setBounds(200, 100, 200, 50);
		tacos.setFont(new Font("Arial", Font.BOLD, 15));

		tacos.addActionListener(this);

		// Adds the tacos checkbox to the game panel
		gamePanel2.add(tacos);

		// Heart images
		heartArray[0] = new heartImages(0);
		heartArray[1] = new heartImages(1);
		heartArray[2] = new heartImages(2);

		// Sets the image obtained from the array to the JLabel variables
		heart1 = heartArray[0];
		heart2 = heartArray[1];
		heart3 = heartArray[2];

		// Heart 1 image
		heart1.setBounds(150, -30, 300, 300);

		topPanel.add(heart1);

		// Heart 2 image
		heart2.setBounds(300, -30, 300, 300);

		topPanel.add(heart2);

		heart3.setBounds(450, -30, 300, 300);

		topPanel.add(heart3);

		// Makes the frame visible
		setVisible(true);

	}

	// Listens to the actions performed (e.g. clicking a button) and proceeds
	// accordingly
	@Override
	public void actionPerformed(ActionEvent event) {

		// If the user clicks on the back button, bring up the activity start frame
		if (event.getSource() == backButton) {

			new ActivityStartFrame();

		}

		/**
		 * if (event.getSource() == submitButton1 || event.getSource() == submitButton2)
		 * {
		 */

		// Otherwise, if the user clicks on the submit button, change panels (topics)
		else if (event.getSource() == submitButton) {

			// First game panel

			/**
			 * if (event.getSource() == divideConquer || event.getSource() == correct answer
			 * from game panel 2 || etc.) {
			 */

			// If the user chooses the correct answer(s)
			if (event.getSource() == divideConquer) {

				// Based on the number of the current panel, remove the panel assigned to the
				// index of the array
				remove(numPanelsArray[currentPanel]);

				// Increase the number of the current panel
				currentPanel++;

				// If the user completes all the 3 panels (meaning that it's now 4)
				if (currentPanel == 4) {

					// Add the congratsPanel here

				}

				// Otherwise, add the new current panel
				else {

					add(numPanelsArray[currentPanel]);
				}

			}

			// Otherwise, remove a life
			else
				lifeRemover();

		}

	} // End of action performed

	// This method removes the lives
	public void lifeRemover() {

		// Takes out a life
		lives--;

		// Remove the heart image
		remove(heartArray[lives]);

		// If the number of lives is 0
		if (lives == 0) {

			// Add the game over panel

		}

	}

} // End of class
