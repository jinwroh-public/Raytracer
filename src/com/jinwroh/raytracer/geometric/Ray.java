package com.jinwroh.raytracer.geometric;

/**
 * The Ray represents the ray to be traced in the raytracing program. The
 * class is composed by a Point - representing the origin of the ray, 
 * and a Vector - representing the direction of this ray.
 * 
 * @author	Jin W. Roh
 * @version	1.0.0
 */
public class Ray {

	private Point origin;
	private Vector direction;

	/**
	 * Constructs a Ray with the origin point and the vector direction.
	 * @param origin     the point of origin of the ray.
	 * @param direction	 the direction of the ray.
	 */
	public Ray (Point origin, Vector direction) {
		this.origin = origin;
		this.direction = direction;
	}
	
	
	/**
	 * Gets the origin point of the ray.
	 * @return	the origin point.
	 */
	public Point getOrigin () {
		return this.origin;
	}
	
	/**
	 * Gets the direction of the ray.
	 * @return the direction of the ray.
	 */
	public Vector getDirection () {
		return this.direction;
	}
	
	/**
	 * Sets the origin point of the ray.
	 * @param origin  the new origin point of this ray.
	 */
	public void setOrigin (Point origin) {
		this.origin = origin;
	}
	
	/**
	 * Sets the direction of this ray.
	 * @param direction  the new direction of this ray.
	 */
	public void setDirection (Vector direction) {
		this.direction = direction;
	}
	
	
	@Override
	public String toString () {
		return "Ray : \n\tOrigin: " + this.origin + "\n\tDirection: " + this.direction;
	}
}
