
/**
 * Name: Oliver Lai Wai
 * Date: June 17, 2022

 * Description: 
	This application replicates an online learning platform that specializes in computer programming! 
  	On the menu screen, you have three buttons: “Start learning now!” which teaches you the concepts of Methods, 
  	“Play a game!” which makes you do an activity, and “Test your knowledge!” which tests you on your understanding. 
  	Before you go on your journey of coding, please be aware that the game is currently under maintenance because 
  	the dinosaurs are sleeping. Sorry! 
  	
  	May the Code be with You!
  		- From a Star Wars fan.
 
 * Features:
 * I added a starting frame for the game
 * At the end of the quiz, I added a congratulations frame with a .gif background image!

 * Major Skills:
 
 - New: 
  	- Button Group (for radio buttons)
	- .setViewportView (for Scroll Pane)
	
 - Swing GUI components:
 	- Extends JFrame, implements Action Listener
	- JLabel, JPanel, JButton, JRadioButton, JScrollPane
	- actionPerformed (ActionEvent event)
	- If, else if statements
	- textArea
	- .setBounds/Background/Text/Editable/Visible/…
	- .add( )
- Constructors
- Main method
- Get method
- For Loops and Arrays
	- Buttons, Labels, String, etc.

 * Areas of Concern:
 	- The only major issue is the activity frame not working (only the back button works for navigation)
 	- I stated all the errors and explanations in the Test Matrix!
 *
 */

// This application class runs the Menu Frame, which is the start of the whole program
public class ApplicationClass {
		
	// This method allows the program to start
	public static void main(String[] args) {	
		
		// Calls the menu frame first
		new MenuFrame();
		
	}
	
} // End of class