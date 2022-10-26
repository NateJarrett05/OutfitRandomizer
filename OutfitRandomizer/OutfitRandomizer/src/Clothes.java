import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Clothes extends JPanel implements ActionListener{
	
	//Instance variables
	static final int SCREEN_WIDTH = 500;
	static final int SCREEN_HEIGHT = 785;
	Random rand = new Random();

	//Storing all the names of the clothes
	//To add new clothes you must add the file into the the main folder and add the name into the array
	String[] headNames = {"head1.png", "head2.png"};
	String[] topNames = {"shirt1.png", "shirt2.png"};
	String[] jacketNames = {"jacket1.png"};
	String[] bottomNames = {"pants1.png", "pants2.png", "pants3.png"};
	String[] shoeNames = {"shoes1.png", "shoes2.png"};
	
	//Labels
	JLabel headLabel = new JLabel();
	JLabel topLabel = new JLabel();
	JLabel jacketLabel = new JLabel();
	JLabel bottomLabel = new JLabel();
	JLabel shoeLabel = new JLabel();
	
	//Frame
	JFrame frame;
	
	//Buttons
	JButton allButton;
	JButton headButton;
	JButton topButton;
	JButton jacketButton;
	JButton bottomButton;
	JButton shoesButton;
	
	//Panels
	JPanel headPanel;
	JPanel topPanel;
	JPanel jacketPanel;
	JPanel bottomPanel;
	JPanel shoePanel;
	JPanel heartPanel;
	
	//Change colors between testing and final
	boolean testing = false;
	
	//Constructor
	public Clothes() {
		initializeButtons();
		initializePanels();
		initializeFrame();
	}
	
	//Initializing buttons
	public void initializeButtons() {
		//setting up buttons
		allButton = new JButton();
		allButton.setBounds(270, SCREEN_HEIGHT - 375, 200, 50);
		allButton.addActionListener(this);
		allButton.setText("Randomize Everything!");
		allButton.setFocusable(false);
		
		headButton = new JButton();
		headButton.setBounds(270, SCREEN_HEIGHT - 325, 200, 50);
		headButton.addActionListener(this);
		headButton.setText("Randomize Head!");
		headButton.setFocusable(false);
		
		topButton = new JButton();
		topButton.setBounds(270, SCREEN_HEIGHT - 275, 200, 50);
		topButton.addActionListener(this);
		topButton.setText("Randomize Tops!");
		topButton.setFocusable(false);
		
		jacketButton = new JButton();
		jacketButton.setBounds(270, SCREEN_HEIGHT - 225, 200, 50);
		jacketButton.addActionListener(this);
		jacketButton.setText("Randomize Jackets!");
		jacketButton.setFocusable(false);
		
		bottomButton = new JButton();
		bottomButton.setBounds(270, SCREEN_HEIGHT - 175, 200, 50);
		bottomButton.addActionListener(this);
		bottomButton.setText("Randomize Bottoms!");
		bottomButton.setFocusable(false);
		
		shoesButton = new JButton();
		shoesButton.setBounds(270, SCREEN_HEIGHT - 125, 200, 50);
		shoesButton.addActionListener(this);
		shoesButton.setText("Randomize Shoes!");
		shoesButton.setFocusable(false);
	}
	
	//Initializing GUI
	public void initializeFrame() {
		//setting up frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(187, 187, 187));
		
		//adding parts to the frame
		frame.add(headPanel);
		frame.add(topPanel);
		frame.add(jacketPanel);
		frame.add(bottomPanel);
		frame.add(shoePanel);
		frame.add(heartPanel);
		
		frame.add(allButton);
		frame.add(headButton);
		frame.add(topButton);
		frame.add(jacketButton);
		frame.add(bottomButton);
		frame.add(shoesButton);
	}
	
	//Initializing sections
	public void initializePanels() {
		//setting up panels
		headPanel = new JPanel();
		headPanel.setBounds(0, 0, 250, 125);
		initialClothes(headNames, headLabel, headPanel);
		
		topPanel = new JPanel();
		topPanel.setBounds(0, 125, 250, 200);
		initialClothes(topNames, topLabel, topPanel);
		
		jacketPanel = new JPanel();
		jacketPanel.setBounds(250, 125, 250, 250);
		initialClothes(jacketNames, jacketLabel, jacketPanel);
		
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0, 325, 250, 300);
		initialClothes(bottomNames, bottomLabel, bottomPanel);
		
		shoePanel = new JPanel();
		shoePanel.setBounds(0, 625, 250, 125);
		initialClothes(shoeNames, shoeLabel, shoePanel);
		
		heartPanel = new JPanel();
		heartPanel.setBounds(250, 0, 250, 125);
		JLabel label2 = new JLabel();
		label2.setText("<3");
		label2.setForeground(Color.red);
		label2.setFont(new Font("MV Boli", Font.BOLD, 40));
		
		JLabel label = new JLabel();
		label.setText("Clothing Randomizer");
		label.setFont(new Font("MV Boli", Font.BOLD, 20));
		label.setForeground(Color.red);
		
		heartPanel.add(label);
		heartPanel.add(label2);
		
		//Coloring panels
		if(testing) {
			headPanel.setBackground(Color.magenta);
			topPanel.setBackground(Color.red);
			jacketPanel.setBackground(Color.cyan);
			bottomPanel.setBackground(Color.blue);
			shoePanel.setBackground(Color.green);
			heartPanel.setBackground(Color.pink);
		}
		else{
			headPanel.setBackground(new Color(187, 187, 187));
			topPanel.setBackground(new Color(187, 187, 187));
			jacketPanel.setBackground(new Color(187, 187, 187));
			bottomPanel.setBackground(new Color(187, 187, 187));
			shoePanel.setBackground(new Color(187, 187, 187));
			heartPanel.setBackground(new Color(187, 187, 187));
		}
		
	}
	
	//Setting base clothes for startup
	public void initialClothes(String[] array, JLabel label, JPanel panel) {
		ImageIcon icon = new ImageIcon(array[0]);
		label.setIcon(icon);
		panel.add(label);
	}
	
	//Randomizing items
	public void randomizeItem(String[] array, JLabel label, JPanel panel) {
		int index = rand.nextInt(array.length);
		String selectedItem = array[index];
		ImageIcon icon = new ImageIcon(selectedItem);
		label.setIcon(icon);
		panel.add(label);
		frame.repaint();
	}

	//Checking for button inputs
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == allButton) {
			randomizeItem(topNames, topLabel, topPanel);
			randomizeItem(jacketNames, jacketLabel, jacketPanel);
			randomizeItem(bottomNames, bottomLabel, bottomPanel);
			randomizeItem(shoeNames, shoeLabel, shoePanel);
			randomizeItem(headNames, headLabel, headPanel);
		}
		else if(e.getSource() == headButton) {
			randomizeItem(headNames, headLabel, headPanel);
		}
		else if(e.getSource() == topButton) {
			randomizeItem(topNames, topLabel, topPanel);
		}
		else if(e.getSource() == jacketButton) {
			randomizeItem(jacketNames, jacketLabel, jacketPanel);
		}
		else if(e.getSource() == bottomButton) {
			randomizeItem(bottomNames, bottomLabel, bottomPanel);
		}
		else if(e.getSource() == shoesButton) {
			randomizeItem(shoeNames, shoeLabel, shoePanel);
		}
	}

	
	//Main method
	public static void main(String[] args) {
		new Clothes();
	}
}