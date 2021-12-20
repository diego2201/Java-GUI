import javax.swing.*;

/**
 * This class constructs the JComboBox's, the vehicles that are listed depends on 
 * which file is passed through to the constructor 
 * 
 * @author Diego Cifuentes
 * @version 1
 *
 */
public class DropdownMenu extends JComboBox 
{
	//This is where the array of vehicleID is stored from the ReadFile class
	private String[] vehicles;
	//The file passed through
	private String file;
		
	/**
	 * The constructor for the JComboBox
	 * 
	 * @param filePath		The filePath passed through used to read the file and then assign to the ComboBox
	 */
	public DropdownMenu(String filePath) 
	{
		//Assigns the passed in file path to the instance variable file
		this.file = filePath;
		//Initializes the vehicles array
		vehicles = new String[5];
		
		//Creates a ReadFile object and passes in the file
		ReadFile reader = new ReadFile(file);
		//Calls the readFile method in the ReadFile class in order to read in the file
		reader.readFile();
		//Calls the getID method and then stores the array in the vehicles array
		vehicles = reader.getID();
		
		//A for loop to assign each vehicleID to the JComboBox
		for (String s : vehicles) 
		{
			this.addItem(s);
		}
	}
}
