package com.hemebiotech.analytics;


import com.hemebiotech.analytics.xmlLoader.XmlLoader;
import com.hemebiotech.analytics.map.MappingIllness;
import com.hemebiotech.analytics.reader.IllnessReader;
import com.hemebiotech.analytics.writer.IllnessWriter;


public class AnalyticsCounter {
	private static final String FILENAME = "src/config.xml";
	private static String fileInput;
	private static String fileOutput;
	private static MappingIllness mapped = new MappingIllness();
	
	public static void main(String[] args) {
		
		XmlLoader xmlLoader = new XmlLoader(FILENAME);
		xmlLoader.parsing();
		
		
		// Read config into attributes little parsing
		fileInput = xmlLoader.getInputFile();
		fileOutput = xmlLoader.getOutputFile();
		
        // display
        System.out.println("File in : " + fileInput);
        System.out.println("File out : " + fileOutput);
		
		
		IllnessReader reader = new IllnessReader(fileInput, mapped);
		reader.readSymptoms();

		IllnessWriter writer = new IllnessWriter (fileOutput, mapped);
		writer.writeInFile();
		
		System.out.println("Done");

		
		
		
			      


	}
}
