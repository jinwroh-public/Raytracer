package com.jinwroh.raytracer.strategy.shading;

import com.jinwroh.raytracer.geometric.Ray;
import com.jinwroh.raytracer.geometric.Shape;
import com.jinwroh.raytracer.graphics.Color;
import com.jinwroh.raytracer.graphics.Scene;


/**
 * The Shading strategy interface allows the encapsulation of different
 * shading algorithms. The shading algorithm is used by the classes that
 * inherit from the Shape abstract class, and each shape will delegate
 * the shading computation to the designated shading strategy.
 * 
 * @author Jin W. Roh
 * @version 1.0.0
 */
public interface ShadingStrategy {

	/**
	 * Computes the shading algorithm, and returns a color at the specified point.
	 * 
	 * @param viewRay             the ray towards
	 * @param localCalculations   the local calculation bundle
	 * @param properties          the local property of the shape
	 * @param scene               the entire raytracing scene.
	 * @return                    the computed Color at the local point
	 */
	public Color shade (Ray viewRay, Shape.LocalCalculations localCalculations, 
			Shape.Properties properties, Scene scene);

}
