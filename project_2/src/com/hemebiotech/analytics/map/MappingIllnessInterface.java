package com.hemebiotech.analytics.map;

import java.util.Map;

public interface MappingIllnessInterface {
	
	public Map<String, Integer> getMapped ();
	public boolean addElement (String key, Integer value);
	public boolean delElement (String key);
}
