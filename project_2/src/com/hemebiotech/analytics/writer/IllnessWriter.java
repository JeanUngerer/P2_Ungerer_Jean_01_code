package com.hemebiotech.analytics.writer;

import java.util.Map.Entry;
import java.io.FileWriter;
import java.io.IOException;

import com.hemebiotech.analytics.map.MappingIllness;


/**
* IllnessWriter uses MappingIllness and a target file
* to write the key/value pairs in line
* @Param mapped <MappingIllness >
* @Param filePath <String>
*/
public class IllnessWriter implements IllnessWriterInterface {

	private MappingIllness mapped;
	private String filePath;

	/**
	* Constructor for class IllnessWriter
	* @param filePath  <litteral path from workspace root to the target file>
	* @param mapped <class containing a Map <String, Integer> containing data to be written>
	*/
	public IllnessWriter (String filePath, MappingIllness mapped)
	{
		this.mapped = mapped;
		this.filePath = filePath;
	}
	
	/**
	* Method writes all pairs in mapped.Map in the text file in the order of the map
	* @Return <Boolean> true if successful, false otherwise
	*/	
	public boolean writeInFile()
	{ 
		try
		{
			FileWriter writer = new FileWriter(this.filePath);
			for (Entry<String, Integer> element : mapped.getMapped().entrySet())
			{
				writer.write(element.getKey() + " " + element.getValue() + "\n");
			}
			writer.close();
			return true;
		} catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		}
		

	}
}

