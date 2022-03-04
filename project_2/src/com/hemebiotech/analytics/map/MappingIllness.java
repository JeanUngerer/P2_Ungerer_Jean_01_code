package com.hemebiotech.analytics.map;

import java.util.TreeMap;

public class MappingIllness implements MappingIllnessInterface {
	private TreeMap<String, Integer> mapped;
	
	public MappingIllness ()
	{
		this.mapped = new TreeMap<String, Integer> ();
	}
	
	@Override
	public TreeMap<String, Integer> getMapped ()
	{
		return this.mapped;
	}
	
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
	
	public boolean delElement (String key)
	{
		this.mapped.remove(key);
		return true;
	}
}
