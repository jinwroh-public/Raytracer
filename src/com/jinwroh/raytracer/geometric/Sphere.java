package com.jinwroh.raytracer.geometric;

import com.jinwroh.raytracer.strategy.shading.ShadingStrategy;


/**
 * The Sphere class represents a sphere in the 3 dimensional Cartesian coordinate 
 * system. 
 * 
 * @author	Jin W. Roh
 * @version	1.0.0
 */
public class Sphere extends Shape {
	
	private Point center;
	private double radius;
	
	
	/**
	 * Constructs a Sphere with the specified center and radius, and the given
	 * property of the Sphere object with the shading strategy to be used.
	 * @param center              the center Point of the sphere
	 * @param radius              the radius of the sphere
	 * @param properties          the shape properties of the sphere
	 * @param shadingStrategy     the shading strategy of the sphere
	 */
	public Sphere (Point center, double radius, 
			Shape.Properties properties, ShadingStrategy shadingStrategy) {
		
		super(properties, shadingStrategy);
		
		this.center = center;
		this.radius = radius;
	}
	
	@Override
	public Shape.LocalCalculations calculateIntersection (Ray ray) {
		
		// Vector mathematics, parametric surfaces, and linear algebra
		// We are trying to see if the given ray hits this Sphere.
		// See: http://en.wikipedia.org/wiki/Line%E2%80%93sphere_intersection
		// for detailed information.
		
		Shape.LocalCalculations calculations = new Shape.LocalCalculations();
		
		Vector d = ray.getDirection();
		Vector e = new Vector(ray.getOrigin());
		Vector c = new Vector(this.center);

		// Say hello to the quadratic formula! ( b +- sqrt(b^2 - 4ac) ) / 2a
		double valueA = Vector.dotProduct(d, d);
		double valueB = Vector.dotProduct(d, Vector.subtract(e, c));
		double valueC = Vector.dotProduct(Vector.subtract(e, c), Vector.subtract(e, c)) - Math.pow(this.radius, 2);
		
		double discriminant = Math.pow(valueB, 2) - (valueA * valueC);
		
		// If the discriminant is zero, the ray misses the sphere.
		if (discriminant < 0) {
			calculations.hits = false;
		}
		else {
			double timeOne = ( (-1 * valueB) + Math.sqrt(discriminant) ) / (valueA);
			double timeTwo = ( (-1 * valueB) - Math.sqrt(discriminant) ) / (valueA);
			double time = (timeOne < timeTwo) ? timeOne : timeTwo;
			
			Vector position = Vector.add(e, Vector.multiply(d, time));
			
			calculations.point = new Point(position.getX(), position.getY(), position.getZ());
			calculations.normal = Vector.multiply(Vector.subtract(position, c), 2);
			calculations.hits = true;
			calculations.timeHit = time;
		}
		
		return calculations;
	}
	
}
