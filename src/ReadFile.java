import java.io.*;

/**
 * The class that reads in the given file in order to obtain the vehicleIDs
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class ReadFile 
{
	//Where the vehicleIDs will be stored
	private String[] vehicleID;
	//The file passed in to be read
	private String file;
		
	/**
	 * Assigns the passed in filePath to the instance variable file
	 * 
	 * @param filePath		The passed in filePath
	 */
	public ReadFile(String filePath)
	{
		this.file = filePath;
	}
	
	/**
	 * The method that reads in the file and then stores the vehicleID into an array
	 */
	public void readFile()
	{
		//Creates a new File object
		File read = new File(file);
		
		try(BufferedReader br = new BufferedReader(new FileReader(read)))
		{			
			//Initializes the vehicleID array
			
			vehicleID = new String[6]; 
			//vehiclePic = new String[5];
			
			int count = 1;
			
			//Reads the first line in order to skip it
			br.readLine();
			
			//Used in order to help assign the read in line to the array
			String line;
			String vehicleLine;
			
			vehicleID[0] = "Find Car";
				
			//Reads the file as long as the line is not null
			while((line = br.readLine()) != null)
			{
				vehicleLine = line;
				//secondVLine = line;
				
				//Parses the vehicleID and then assigns it to the array
				vehicleID[count] = vehicleLine.substring(0, 5);
				//vehiclePic[count] = secondVLine.substring(5, 15);
				
				count++;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the vehicleIDs
	 * 
	 * @return		The array containing the vehilceIDs
	 */
	public String[] getID()
	{
		return vehicleID;
	}
}
