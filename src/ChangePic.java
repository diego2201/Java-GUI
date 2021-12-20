
/**
 * A class created to help reduce redundant code from Main class.
 * In this class we help determine if the passed in image is a valid image and depending on that
 * it will return a file path to be outputted to the GUI
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class ChangePic 
{
	/** Where the passed in value will be stored */
	private String value;
	/** Used to help differentiate between values */
	private String selectedValue;
	
	/**
	 * The constructor, assigns the passed in selectedValue from the action listener
	 * to the instance variable
	 * 
	 * @param selectedValue		the passed in value to be assigned
	 */
	public ChangePic(String selectedValue)
	{
		//Assigns the passed in selectedValue to both instance variables
		value = selectedValue;
		this.selectedValue = selectedValue;
	}
	
	/**
	 * Depending on if the image is valid, will create a file path to an error image or an image path 
	 * to the passed in selectedValue
	 * 
	 * @return image path as a String
	 */
	public String choosenPic() 
	{		
		//Checks if the image is one of the two faulty images
		if(value.equals("veh05") || value.equals("veh11"))
		{
			//If so it assigns "error" to value
			value = "error";
		}
		/*else
		{
			//Else it remains the same
			value = selectedValue;
		}*/
		
		//Creates a new String to add on the extensions to the String in order to be correctly read in as an image
		String pic;
		pic = "image/" + value + ".jpg";
		
		//Returns the image path
		return pic;
	}
}
