package com.jinwroh.raytracer.graphics;


/**
 * The Pixel class represents a single pixel in the computer screen.
 * The class encapsulates the x, y coordinates, and the color value.
 * This is an immutable class.
 * 
 * @author	Jin W. Roh
 * @version	1.0.0
 */ 
public final class Pixel {

	/**
	 * The x, y coordinates and the color value of this pixel.
	 */
	private final int x;
	private final int y;
	private final Color color;
	
	
	/**
	 * Constructs a pixel with the x, y coordinates, and the color value.
	 * @param x        the x-coordinate
	 * @param y        the y-coordinate
	 * @param color    the Color class that represents the color of this pixel
	 */
	public Pixel (int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	
	/**
	 * Gets the x-coordinate of this pixel.
	 * @return    the x-coordinate of this pixel
	 */
	public int getX () {
		return this.x;
	}
	
	/**
	 * Gets the y-coordinate of this pixel.
	 * @return    the y-coordinate of this pixel
	 */
	public int getY () {
		return this.y;
	}
	
	/**
	 * Gets the color of this pixel.
	 * @return    the Color object that represents the color of this pixel
	 */
	public Color getColor () {
		return this.color;
	}
	
}
