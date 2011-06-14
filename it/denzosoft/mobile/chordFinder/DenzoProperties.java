package it.denzosoft.mobile.chordFinder;

import java.util.*;

public class DenzoProperties extends Hashtable implements Properties
{

	public DenzoProperties() {
	}

	public int getInt(Object key,int defaultValue) {
		if (containsKey(key))
			return ((Integer)get(key)).intValue();
		return defaultValue;
	}

//	public float getFloat(Object key,float defaultValue) {
//		if (containsKey(key))
//			return ((Float)get(key)).floatValue();
//		return defaultValue;
//	}

	public String getString(Object key,String defaultValue) {
		if (containsKey(key))
			return ((String)get(key));
		return defaultValue;
	}

	public Object getObject(Object key,Object defaultValue) {
		if (containsKey(key))
			return get(key);
		return defaultValue;
	}
}
