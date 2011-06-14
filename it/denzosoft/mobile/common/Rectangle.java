/*
 * Rectangle.java
 *
 * Created on 10 novembre 2006, 17.23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package it.denzosoft.mobile.common;

/**
 * 
 * @author De Sanctis
 */
public class Rectangle {

	/** Creates a new instance of Rectangle */
	public Rectangle(int top, int left, int width, int height) {
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;

	}

	/**
	 * Holds value of property top.
	 */
	private int top;

	/**
	 * Getter for property top.
	 * 
	 * @return Value of property top.
	 */
	public int getTop() {
		return this.top;
	}

	/**
	 * Holds value of property left.
	 */
	private int left;

	/**
	 * Getter for property left.
	 * 
	 * @return Value of property left.
	 */
	public int getLeft() {
		return this.left;
	}

	/**
	 * Holds value of property width.
	 */
	private int width;

	/**
	 * Getter for property width.
	 * 
	 * @return Value of property width.
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Holds value of property height.
	 */
	private int height;

	/**
	 * Getter for property height.
	 * 
	 * @return Value of property height.
	 */
	public int getHeight() {
		return this.height;
	}

}
