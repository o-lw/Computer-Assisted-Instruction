import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// By extending the class with JFrame, it acts like a screen
// By implementing action listener, you set up objects to respond to events that occur (like clicking buttons)
public class ConceptsFrame extends JFrame implements ActionListener {

	// Scroll Pane
	JScrollPane scrollPane = new JScrollPane();

	// Panel
	JPanel displayBox = new JPanel();

	// Colours
	Color backgroundColour = new Color(39, 56, 157); // Blue
	Color displayBoxColour = new Color(61, 133, 198); // Light blue
	Color whiteColour = new Color(255, 255, 255); // White
	Color topicColour = new Color(255, 137, 0); // Orange
	Color backButtonColour = new Color(255, 199, 33); // Light orange
	Color blackColour = new Color(0, 0, 0);

	// Labels
	JLabel background = new JLabel();
	JLabel logoLabel = new JLabel();

	// Topic images
	JLabel topic1Image = new JLabel();

	JLabel topic2Image = new JLabel();

	JLabel topic3Image = new JLabel();

	// Buttons
	JButton backButton = new JButton("Back");

	// Creates a buttons array
	private JButton[] buttonsArray = new JButton[3];

	// Creates a string array for the buttons
	private String[] buttonsStringArray = {

			"Topic 1: Program Modules", "Topic 2: static Methods", "Topic 3: Parameters in Methods",

	};

	// Concepts Frame Constructor
	public ConceptsFrame() {

		// Sets the size and disables frame resizing
		setSize(1440, 900);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		background.setLayout(null);

		// Sets the title of the frame (not inside the frame)
		setTitle("Concepts Frame");

		// Sets the starting y value
		int y = 150;

		// For the index 0 to the length of the array, construct the buttons
		for (int index = 0; index < buttonsArray.length; index++) {

			buttonsArray[index] = new JButton(buttonsStringArray[index]);
			buttonsArray[index].setBounds(100, y, 400, 150);
			buttonsArray[index].setBackground(topicColour);
			buttonsArray[index].setForeground(blackColour);
			buttonsArray[index].setFont(new Font("Arial", Font.BOLD, 16));

			buttonsArray[index].addActionListener(this);
			background.add(buttonsArray[index]);

			// Increases the y value for every button
			y += 200;

		}

		// Back Button
		backButton.setBounds(100, 760, 200, 70);
		backButton.setBackground(backButtonColour);
		backButton.setForeground(blackColour);
		backButton.setFont(new Font("Arial", Font.BOLD, 12));

		backButton.addActionListener(this);

		background.add(backButton);

		// Scroll Pane
		scrollPane.setBackground(backgroundColour);
		scrollPane.setBounds(15, 15, 800, 770);

		// Sets the display box's bounds, colour, and layout manager
		displayBox.setBounds(570, 25, 830, 800);
		displayBox.setBackground(displayBoxColour);
		displayBox.setLayout(null);

		// Adds the scroll pane to the display box
		// Then adds the display box to the frame
		displayBox.add(scrollPane);
		add(displayBox);

		// Background Constructor
		background.setBounds(0, 0, 1440, 900);
		background.setOpaque(true);
		background.setBackground(backgroundColour);
		add(background);

		// Makes the frame visible
		setVisible(true);

	}

	// Listens to the actions performed (e.g. clicking a button) and proceeds
	// accordingly
	@Override
	public void actionPerformed(ActionEvent event) {

		// If the user clicks on the first topic, show the topic 1 image
		if (event.getSource() == buttonsArray[0]) {

			// Sets the image for this label
			topic1Image.setIcon(new ImageIcon("codingImages/programModulesImage.jpg"));

			// Shows the image on the scroll pane
			scrollPane.setViewportView(topic1Image);

			// You don't need to set the bounds of the label! I'm so happy I found this!

		}

		// Otherwise, if the user clicks on the second topic, show the topic 2 image
		else if (event.getSource() == buttonsArray[1]) {

			// Sets the image for this label
			topic2Image.setIcon(new ImageIcon("codingImages/staticMethodsImage.jpg"));

			// Shows the image on the scroll pane
			scrollPane.setViewportView(topic2Image);

		}

		// Otherwise, if the user clicks on the third topic, show the topic 3 image
		else if (event.getSource() == buttonsArray[2]) {

			// Sets the image for this label
			topic3Image.setIcon(new ImageIcon("codingImages/parametersImage.jpg"));

			// Shows the image on the scroll pane
			scrollPane.setViewportView(topic3Image);

		}

		// Otherwise, call the Menu Frame (back button)
		else

			new MenuFrame();

	} // End of action performed

} // End of class

/**
 * Previous Codes
 */

//// Buttons
//topic1Button.setBounds(100, 150, 400, 150);
//topic1Button.setBackground(topicColour);
//topic1Button.setForeground(blackColour);
//topic1Button.setFont(new Font("Arial", Font.BOLD, 24));
//
//topic1Button.addActionListener(this);
//
//topic2Button.setBounds(100, 350, 400, 150);
//topic2Button.setBackground(topicColour);
//topic2Button.setForeground(blackColour);
//topic2Button.setFont(new Font("Arial", Font.BOLD, 24));
//
//topic2Button.addActionListener(this);
//
//topic3Button.setBounds(100, 550, 400, 150);
//topic3Button.setBackground(topicColour);
//topic3Button.setForeground(blackColour);
//topic3Button.setFont(new Font("Arial", Font.BOLD, 24));
//
//topic3Button.addActionListener(this);
//

//// Adds the buttons to the background
//background.add(topic1Button);
//background.add(topic2Button);
//background.add(topic3Button);
