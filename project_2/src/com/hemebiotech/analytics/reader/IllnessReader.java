package com.hemebiotech.analytics.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.hemebiotech.analytics.map.MappingIllness;

/**
* IllnessReader uses MappingIllness and a source file
* to write the key/value pairs in a map
* @Param mapped <MappingIllness >
* @Param filePath <String>
*/
public class IllnessReader implements IllnessReaderInterface {
	private String filePath;
	private MappingIllness mapper;
	
	/**
	* Constructor for class IllnessReader
	* @param filePath  <litteral path from workspace root to the target file>
	* @param mapped <class containing a Map <String, Integer> containing data to be written>
	*/
	public IllnessReader (String filePath, MappingIllness mapper)
	{
		this.filePath = filePath;
		this.mapper = mapper;
	}
	
	/**
	* Method readSymptoms () : reads all lines in the text file and writes it in the the map
	* @Return <Boolean> true if successful, false otherwise
	*/	
	public boolean readSymptoms ()
	{
		if (this.filePath == null) 
		{
			return false;
		}
		
		try {
			BufferedReader reader = new BufferedReader (new FileReader(this.filePath));
			String line = reader.readLine();
			
			while (line != null) {
				mapper.addElement(line, 1);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
}
