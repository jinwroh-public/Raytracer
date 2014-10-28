package com.jinwroh.raytracer.graphics;


/**
 * The Color class represents a single value RGB additive color model
 * system. Each additive primary color - red, green, and blue that composes
 * this class is given in a floating point scale of 0.0 to 1.0. Zero (0.0) 
 * represents no color, where as 1.0 represent the highest color value, 
 * respectively. This is an immutable class, since a color should be 
 * considered as a value object that should not be modified.
 * 
 * @author	Jin W. Roh
 * @version	1.0.0
 */
public final class Color {

	/**
	 * The primary Red, Green, Blue additive colors.
	 */
	private final double r;
	private final double g;
	private final double b;
	
	
	/**
	 * Default Constructor: Constructs a Black Color.
	 */
	public Color () {
		this.r = 0;
		this.g = 0;
		this.b = 0;
	}
	
	/**
	 * Constructs a Color with the the given RGB values.
	 * @param r    the red value
	 * @param g    the green value
	 * @param b    the blue value
	 */
	public Color (double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	
	/**
	 * Gets the red value of this Color.
	 * @return    the red value
	 */
	public double getR () {
		return this.r;
	}
	
	/**
	 * Gets the green value of this Color.
	 * @return    the green value
	 */
	public double getG () {
		return this.g;
	}
	
	/**
	 * Gets the blue value of this Color.
	 * @return    the blue value
	 */
	public double getB () {
		return this.b;
	}
	
	@Override
	public String toString() {
		return "Color: (R:" + this.r + ", G:" + this.g + ", B:" + this.b + ")";
	}
}
