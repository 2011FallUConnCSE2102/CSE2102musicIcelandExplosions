/*
 * Properties.java
 *
 * Created on 30 maggio 2002, 14.49
 */

package it.denzosoft.mobile.chordFinder;

/**
 *
 * @author  De Sanctis
 * @version
 */
public interface Properties {
	public int getInt(Object key,int defaultValue);
//	public float getFloat(Object key,float defaultValue);
	public String getString(Object key,String defaultValue);
	public Object getObject(Object key,Object defaultValue);
        public Object put(Object key,Object value);
        public Object remove(Object key);
        public Object get(Object key);

}

