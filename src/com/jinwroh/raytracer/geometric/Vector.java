package com.jinwroh.raytracer.geometric;


/**
 * The Vector class represents a vector in the 3 dimensional Cartesian coordinate 
 * system. A vector is represented by a direction and a magnitude. This class provides
 * static methods for vector arithmetic: dot product, addition, subtraction, and 
 * multiplication and division by a scalar. The only mutation allowed is via 
 * the normalization.
 * 
 * @author	Jin W. Roh
 * @version	1.0.0
 */
public class Vector {

	/**
	 * x, y, z represents the vector's direction.
	 */
	private double x;
	private double y;
	private double z;
	private double magnitude;
	
	
	/**
	 * Constructs a Vector from a Point. 
	 * 
	 * The point represents the direction of the Point, implicitly from the
	 * origin (0, 0, 0).
	 * 
	 * @param a	the Point to which the vector is directed.
	 */
	public Vector (Point a) {
		this(a.getX(), a.getY(), a.getZ());
	}
	
	/**
	 * Constructs a Vector from two Points. 
	 * 
	 * Point a represents the 'starting point', and the Point b represents 
	 * end 'end point' of the Vector.
	 * 
	 * @param a the starting point of the vector.
	 * @param b	the direction, or the end point of the vector.
	 */
	public Vector (Point a, Point b) {
		this( b.getX() - a.getX(), b.getY() - a.getY(), b.getZ() - a.getZ() );
	}
	
	/**
	 * Constructs a Vector from a given x, y, z coordinates. 
	 * 
	 * The x, y, z coordinates represent the direction of the Vector.
	 * 
	 * @param x the x-coordinate of the direction
	 * @param y the y-coordinate of the direction
	 * @param z	the z-coordinate of the direction
	 */
	public Vector (double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.magnitude = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
	}
	
	
	/**
	 * Gets the x-coordinate of the Vector
	 * @return	the x-coordinate of the Vector
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the y-coordinate of the Vector
	 * @return	the y-coordinate of the Vector
	 */
	public double getY() {
		return y;
	}

	/**
	 * Gets the z-coordinate of the Vector
	 * @return	the z-coordinate of the Vector
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * Gets the magnitude of the Vector
	 * @return	the magnitude of the Vector
	 */
	public double getMagnitude () {
		return this.magnitude;
	}
	
	
	/**
	 * Mutates the vector into a unit vector (normalization).
	 */
	public void normalize () {
		this.x /= this.magnitude;
		this.y /= this.magnitude;
		this.z /= this.magnitude;
		this.magnitude = 1.0;
	}
	
	
	/**
	 * Computes the dot product (inner product) of two given vectors.
	 * @param a	First vector
	 * @param b	Second vector
	 * @return	the computed dot product of the two vectors
	 */
	public static double dotProduct (Vector a, Vector b) {
		return a.getX()*b.getX() + a.getY()*b.getY() + a.getZ()*b.getZ();
	}
	
	/**
	 * Subtracts two Vectors. 
	 * @param a	First Vector
	 * @param b	Second Vector
	 * @return	the resulting new Vector from the subtraction
	 */
	public static Vector subtract (Vector a, Vector b) {
		return new Vector( a.getX()-b.getX(), a.getY()-b.getY(), a.getZ()-b.getZ() );
	}
	
	/**
	 * Adds two Vectors.
	 * @param a	First Vector
	 * @param b	Second Vector
	 * @return	the resulting new Vector from the vector addition
	 */
	public static Vector add (Vector a, Vector b) {	
		return new Vector( a.getX()+b.getX(), a.getY()+b.getY(), a.getZ()+b.getZ() );
	}
	
	/**
	 * Multiplies a given vector with the given scalar.
	 * @param a			the vector to be multiplied
	 * @param scalar	the scalar multiply
	 * @return	the resulting new Vector from the scalar multiplication
	 */
	public static Vector multiply (Vector a, double scalar) {
		return new Vector(a.getX()*scalar, a.getY()*scalar, a.getZ()*scalar);
	}
	
	
	/**
	 * Divides a given vector with the given scalar
	 * @param a			the vector to be divided
	 * @param scalar	the divisor
	 * @return	the resulting new Vector from the scalar division
	 */
	public static Vector divide (Vector a, double scalar) {
		return new Vector(a.getX()/scalar, a.getY()/scalar, a.getZ()/scalar);
	}
	
	@Override
	public String toString () {
		String output = "Vector: (" + this.x + ", " + this.y + ", " + this.z + ")";
		output += "\tMagnitude: " + this.magnitude;
		return output;
	}
}
