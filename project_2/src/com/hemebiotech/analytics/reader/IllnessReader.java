package com.hemebiotech.analytics.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.hemebiotech.analytics.map.MappingIllness;

public class IllnessReader implements IllnessReaderInterface {
	private String filePath;
	private MappingIllness mapper;
	
	public IllnessReader (String filePath, MappingIllness mapper)
	{
		this.filePath = filePath;
		this.mapper = mapper;
	}
	
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
		}
		return true;
		
	}
	
}
