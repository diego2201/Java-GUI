import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * @author Diego Cifuentes
 * @version 2021.11.5
 * Main class of Project 5
 */
public class Main 
{
	/** DropdownMenu objects that will change depending on what file is passed in */
	private static DropdownMenu menu;
	private static DropdownMenu secondMenu;
	/** ImageIcon objecs that will be put into JLabels and change depending on actionlisteners*/
	private static ImageIcon image1;
	private static ImageIcon image2;

	/**
	 * Where the GUI components are fully created and then assigned, 
	 * where the frame is formatted 
	 * 
	 * @param args
	 * @throws IOException if the image file cannot be read in or found
	 */
	public static void main(String[] args) throws IOException
	{
		//Creates the JLabels for the GUI
		JLabel firstCar = new JLabel("Choose the first car:");
		JLabel secondCar = new JLabel("Choose the second car:");
		
		//Creates the JLabels and assigns ImageIcons to them that will change
		JLabel img1 = new JLabel(image1);
		JLabel img2 = new JLabel(image2);
		
		//Creates a new DropdownMenu object
		menu = new DropdownMenu("vehicleone.txt");
		
		//From Stack Overflow
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Does this to fully utilize the JComboBox action listener,
					//as DropdownMenu does construct a JComboBox, it is still
					//its own object
				JComboBox combo = (JComboBox)e.getSource();
				
				//Whatever value is selected from the JComboBox will be assigned to
					//this String variable
				String selectedValue = combo.getSelectedItem().toString();
				
				//Creates a new object that will check for the invalid images and 
					//will return an error image if it cannot be found
				ChangePic pickPic = new ChangePic(selectedValue);
				//Calls the choosenPic method that will return an error message
					//if the pic cannot load
				String returnedValue = pickPic.choosenPic();
				
				//Creates a new ImageIcon with the returnedValue from above
				image1 = new ImageIcon(returnedValue, "");
				//Transforms the ImageIcon object into an Image object in order to resize
				Image image = image1.getImage(); 
				//Idea from Discord Discussion
				//Resizes the image and scales it smoothly
				Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH); 
				//Then creates a new ImageIcon object using the newly scaled Image object
				image1 = new ImageIcon(newimg); 
				
				//Updates the JLabel's icon
				img1.setIcon(image1);
			}
		}            
				);
		
		//Same code from first menu, refactored for secondMenu
		secondMenu = new DropdownMenu("vehicletwo.txt");
		
		//From Stack Overflow
		secondMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComboBox combo = (JComboBox)e.getSource();
				String selectedValue = combo.getSelectedItem().toString();
				
				ChangePic pickPic = new ChangePic(selectedValue);
				String returnedValue = pickPic.choosenPic();
				
				image2 = new ImageIcon(returnedValue, "");
				Image image = image2.getImage(); 
				//Idea from Discord Discussion
				Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH); 
				image2 = new ImageIcon(newimg); 
				
				img2.setIcon(image2);
			}
		}            
				);
		
		//Creates a new JButton object that will be used to swap the images
		JButton swapper = new JButton("Swap");
		swapper.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Similar process as in the DropdownMenu
				String selectedValue1 = menu.getSelectedItem().toString();
				String selectedValue2 = secondMenu.getSelectedItem().toString();
				
				ChangePic firstValue = new ChangePic(selectedValue1);
				ChangePic secondValue = new ChangePic(selectedValue2);
				
				String firstReturned = firstValue.choosenPic();
				String secondReturned = secondValue.choosenPic();
				
				image1 = new ImageIcon(firstReturned, "");
				image2 = new ImageIcon(secondReturned, "");

				Image firstImg = image1.getImage(); 
				Image newimg = firstImg.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);  
				image1 = new ImageIcon(newimg);  
				
				Image secondImg = image2.getImage(); 
				Image secondNewImg = secondImg.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);   
				image2 = new ImageIcon(secondNewImg); 
				
				//Where the swap occurs
				img1.setIcon(image2);
				img2.setIcon(image1);
			}
		}            
				);
		
		//Creates a new JFrame
		JFrame frame = new JFrame();
		frame.setSize(850, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Idea from Lab9
		//Makes a new GridBagLayout 
		GridBagLayout gbLayout = new GridBagLayout();
		
		//Advice from Mohammed
		//Sets the dimensions of the blank space 
		gbLayout.columnWidths = new int[] {34, 152, 121, 26, 0, 57, 2, 87, 297, 0};
		gbLayout.rowHeights = new int[] {88, 78, 235, 50, 63, 0, 0, 0 };
		//Sets the layout to the JFrameß
		frame.getContentPane().setLayout(gbLayout);
		
		//Creates the constraints for the first JLabel
		GridBagConstraints firstLabelConstraints = new GridBagConstraints();
		firstLabelConstraints.fill = GridBagConstraints.BOTH;
		//Sets the coordinates where it will be placed
		firstLabelConstraints.gridx = 1;
		firstLabelConstraints.gridy = 1;
		//Adds the JLabel and its constraints to the frame
		frame.getContentPane().add(firstCar, firstLabelConstraints);
		
		//Repeats this process from above for all of the J components with some variations
			//e.g. adding padding (Insets), anchors, and changing the coordinates
		GridBagConstraints secondLabelConstraints = new GridBagConstraints();
		secondLabelConstraints.anchor = GridBagConstraints.WEST;
		secondLabelConstraints.fill = GridBagConstraints.VERTICAL;
		secondLabelConstraints.gridx = 8;
		secondLabelConstraints.gridy = 1;
		frame.getContentPane().add(secondCar, secondLabelConstraints);
		
		GridBagConstraints firstMenuConstraints = new GridBagConstraints();
		firstMenuConstraints.anchor = GridBagConstraints.SOUTH;
		firstMenuConstraints.fill = GridBagConstraints.HORIZONTAL;
		firstMenuConstraints.insets = new Insets(0, 0, 5, 5);
		firstMenuConstraints.gridwidth = 3;
		firstMenuConstraints.gridx = 1;
		firstMenuConstraints.gridy = 1;
		frame.getContentPane().add(menu, firstMenuConstraints);
		
		GridBagConstraints firstImgConstraints = new GridBagConstraints();
		firstImgConstraints.fill = GridBagConstraints.BOTH;
		firstImgConstraints.insets = new Insets(0, 0, 5, 5);
		firstImgConstraints.gridwidth = 3;
		firstImgConstraints.gridx = 1;
		firstImgConstraints.gridy = 2;
		frame.getContentPane().add(img1, firstImgConstraints);
		
		GridBagConstraints secondMenuConstraints = new GridBagConstraints();
		secondMenuConstraints.anchor = GridBagConstraints.SOUTH;
		secondMenuConstraints.fill = GridBagConstraints.HORIZONTAL;
		secondMenuConstraints.insets = new Insets(0, 0, 5, 0);
		secondMenuConstraints.gridx = 8;
		secondMenuConstraints.gridy = 1;
		frame.getContentPane().add(secondMenu, secondMenuConstraints);
		
		GridBagConstraints secondImgConstraints = new GridBagConstraints();
		secondImgConstraints.fill = GridBagConstraints.BOTH;
		secondImgConstraints.insets = new Insets(0, 0, 5, 5);
		secondImgConstraints.gridwidth = 3;
		secondImgConstraints.gridx = 8;
		secondImgConstraints.gridy = 2;
		frame.getContentPane().add(img2, secondImgConstraints);
		
		JPanel panel = new JPanel();

		/*GridBagConstraints panelConstraints = new GridBagConstraints();
		panelConstraints.fill = GridBagConstraints.BOTH;
		panelConstraints.insets = new Insets(0, 0, 5, 5);
		panelConstraints.gridwidth = 3;
		panelConstraints.gridx = 1;
		panelConstraints.gridy = 2;
		frame.getContentPane().add(panel, panelConstraints);*/

		GridBagConstraints buttonConstraints = new GridBagConstraints();
		buttonConstraints.gridheight = 2;
		buttonConstraints.insets = new Insets(0, 0, 5, 5);
		buttonConstraints.anchor = GridBagConstraints.WEST;
		buttonConstraints.fill = GridBagConstraints.VERTICAL;
		buttonConstraints.gridx = 5;
		buttonConstraints.gridy = 4;
		frame.getContentPane().add(swapper, buttonConstraints);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
	}
}
