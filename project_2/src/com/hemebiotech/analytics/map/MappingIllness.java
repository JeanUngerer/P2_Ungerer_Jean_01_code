package com.hemebiotech.analytics.map;

import java.util.TreeMap;


/**
* MappingIllness uses a TreeMap
* to store sorted key/value pairs
* @Param mapped <MappingIllness >
* @Param filePath <String>
*/
public class MappingIllness implements MappingIllnessInterface {
	private TreeMap<String, Integer> mapped;
	
	/**
	* Constructor for class IllnessWriter
	*/
	public MappingIllness ()
	{
		this.mapped = new TreeMap<String, Integer> ();
	}
	
	@Override
	public TreeMap<String, Integer> getMapped ()
	{
		return this.mapped;
	}
	
	/**
	* Method addElement : sorts all elements as key in mapped and counts their total as value
	* @param key  <name of the element >
	* @param value  <number associated to the name >
	* @Return <Boolean> true if successful
	*/	
	public boolean addElement (String key, Integer value)
	{
		
		if(!this.mapped.containsKey(key))
		{
			this.mapped.put(key, value);
			return true;
		}
		else {
			this.mapped.put(key, this.mapped.get(key) + value);
			return true;
		}
		
	}
	
	/**
	* Method delElement : removes an element from mapped
	* @param key  <name of the element >
	* @Return <Boolean> true if successful
	*/	
	public boolean delElement (String key)
	{
		this.mapped.remove(key);
		return true;
	}
}
