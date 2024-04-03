import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Extending JLabel makes it act like a label
public class heartImages extends JLabel {
	
	// Creates an array for the image icon of the lives
	public static final ImageIcon[] IMAGE = {
			
			new ImageIcon("images/heart 1.png"),
			new ImageIcon("images/heart 2.png"),
			new ImageIcon("images/heart 3.png"),
	
	};
	
	// Applies an image to each ghost (Ghost constructor)
	public heartImages(int hNum) { // (int hNum) represents the heart number
		
		// Sets the image of the heart based on the live's number
		this.setIcon(IMAGE[hNum]);
		
	}
		
} // End of class