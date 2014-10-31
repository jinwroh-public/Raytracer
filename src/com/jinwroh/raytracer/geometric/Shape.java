package com.jinwroh.raytracer.geometric;

import com.jinwroh.raytracer.graphics.Color;
import com.jinwroh.raytracer.graphics.Scene;
import com.jinwroh.raytracer.strategy.shading.ShadingStrategy;


/**
 * The Shape class an the abstract class that acts as a base for different
 * shapes in the raytracing scene. All subclasses (shapes) are responsible for
 * computing their own intersection calculations for with regards to ray (Vector).
 * The shading, or coloring algorithm is done via the Strategy (or Policy) pattern.
 * The shading algorithm is delegated to a shading strategy class, which is set
 * at a Shape object construction.
 * 
 * @author	Jin W. Roh
 * @version	1.0.0
 */
public abstract class Shape {
	
	private ShadingStrategy shadingStrategy;
	private Properties properties;
	
	
	/**
	 * The abstract class constructor enforces class constraints. All subclasses
	 * must be constructed with the respective Shape Properties, and the ShadingStrategy.
	 * 
	 * @param properties         the properties of the object
	 * @param shadingStrategy    the shading strategy to be used to color th object
	 */
	public Shape (Shape.Properties properties, ShadingStrategy shadingStrategy) {
		this.shadingStrategy = shadingStrategy;
		this.properties = properties;
	}
	
	
	/**
	 * Calculates the intersection with the given ray with this Shape.
	 * 
	 * @param ray    the ray towards the object
	 * @return       the data object containing relevant calculation information
	 */
	public abstract Shape.LocalCalculations calculateIntersection (Ray ray);
	
	
	/**
	 * Computes the coloring algorithm with respect to the object's shading strategy.
	 * 
	 * @param viewRay             the ray towards the object
	 * @param localCalculations   the calculation information data object
	 * @param scene               the raytracing scene
	 * @return                    the computed color at the point specified in the calculation object
	 */
	public Color shade (Ray viewRay, Shape.LocalCalculations localCalculations, Scene scene) {
		return this.shadingStrategy.shade(viewRay, localCalculations, this.properties, scene);
	}

	/**
	 * Gets the Shape's shading strategy.
	 * @return    the Shape's shading strategy
	 */
	public ShadingStrategy getShadingStrategy () {
		return this.shadingStrategy;
	}

	/**
	 * Sets the Shape's shading strategy.
	 * @param shadingStrategy    the new shading strategy
	 */
	public void setShadingStrategy (ShadingStrategy shadingStrategy) {
		this.shadingStrategy = shadingStrategy;
	}
	
	/**
	 * Gets the Properties of this shape.
	 * @return    the properties of this shape
	 */
	public Shape.Properties getProperties () {
		return this.properties;
	}
	
	/**
	 * Sets the Properties of this shape.
	 * @param properties     the new properties of this shape
	 */
	public void setProperties (Shape.Properties properties) {
		this.properties = properties;
	}

	
	
	/**
	 * LocalCalculation encapsulate all the necessary calculation information
	 * at a local point of a Shape. The class contains variables that denote:
	 * if the ray is hit at the point (hits),  the single Point of the shape 
	 * in consideration (point), the time that took the ray to hit the point (timeHit),
	 * the surface normal vector (normal), and the reflected ray (reflectedRay).
	 * 
	 * @author Jin W. Roh
	 * @version 1.0.0
	 */
	public static class LocalCalculations {
		public boolean hits;
		public Point point;
		public double timeHit;
		public Vector normal;
		public Vector reflectedRay;
	}
	
	
	/**
	 * Properties inner class bundles up relevant properties for a Shape class,
	 * necessary to compute shading / coloring information.
	 * 
	 * @author Jin W. Roh
	 * @version 1.0.0
	 */
	public static class Properties {
		public Color ambientColorProperty;
		public Color diffuseColorProperty;
		public Color specularColorProperty;
		public int specularCoefficient;
		public int reflectionCoefficient;
		public int refractionCoefficient;
	}
}
