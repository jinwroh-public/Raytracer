package com.jinwroh.raytracer.geometric;


/**
 * The Point class represents a point in the 3 dimensional Cartesian coordinate 
 * system. This is an immutable class, since a point should be considered as
 * a value object that should not be modified.
 * 
 * @author	Jin W. Roh
 * @version	1.0.0
 */ 
public final class Point {

	/**
	 * The respective x, y, z coordinates of the point
	 */
	private final double x;
	private final double y;
	private final double z;
	
	
	/**
	 * Constructs a Point with the respective x, y, z coordinates
	 * 
	 * @param x	the x-coordinate
	 * @param y	the y-coordinate
	 * @param z	the z-coordinate
	 */
	public Point (double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	/**
	 * Gets the x-coordinate of this point
	 * @return	the x-coordinate of this point
	 */
	public double getX () {
		return this.x;
	}
	
	
	/**
	 * Gets the y-coordinate of this point
	 * @return	the y-coordinate of this point
	 */
	public double getY () {
		return this.y;
	}
	
	
	/**
	 * Gets the z-coordinate of this point
	 * @return	the z-coordinate of this point
	 */
	public double getZ () {
		return this.z;
	}
	
	
	
	@Override
	public String toString() {
		return "Point: (" + this.x + ", " + this.y + ", " + this.z + ")";
	}
}
