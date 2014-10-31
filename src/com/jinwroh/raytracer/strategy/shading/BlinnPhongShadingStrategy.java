package com.jinwroh.raytracer.strategy.shading;

import com.jinwroh.raytracer.geometric.Ray;
import com.jinwroh.raytracer.geometric.Shape;
import com.jinwroh.raytracer.geometric.Vector;
import com.jinwroh.raytracer.graphics.Color;
import com.jinwroh.raytracer.graphics.Light;
import com.jinwroh.raytracer.graphics.Scene;


/**
 * The BlinnPhongShadingStrategy Class is a concrete implementation of the 
 * ShadingStrategy interface. This class encapsulates the shading model
 * developed by Blinn Phong and Bui Tuong Phong.
 * See link for more information: http://en.wikipedia.org/wiki/Blinn%E2%80%93Phong_shading_model
 * 
 * @author Jin W. Roh
 * @version 1.0.0
 */
public class BlinnPhongShadingStrategy implements ShadingStrategy {

	@Override
	public Color shade (Ray viewRay, Shape.LocalCalculations localCalculations, 
			Shape.Properties properties, Scene scene) {

		// red, green, blue values; range from 0.0 to 1.0
		double r = 0.0;
		double g = 0.0;
		double b = 0.0;
		
		
		// Take all the lights in the scene into account. Light is additive.
		for (Light light : scene.getLights()) {
			
			// Magical shading algorithm computation:
			// In a nutshell, we compute the ambient, diffuse, and specular colors, and add them up
			Vector l = light.getDirection();
			Vector n = localCalculations.normal;
			Vector v = new Vector(localCalculations.point, viewRay.getOrigin());
			
			l.normalize();
			n.normalize();
			v.normalize();
			
			Vector rv = Vector.subtract(Vector.multiply(n, (Vector.dotProduct(l, n) * 2.0)), l);
			rv.normalize();

			double rAmbient = properties.ambientColorProperty.getR() * light.getColor().getR();
			double rDiffuse = properties.diffuseColorProperty.getR() * light.getColor().getR() 
					* Math.max(0, Vector.dotProduct(n, l));
			double rSpecular = properties.specularColorProperty.getR() * light.getColor().getR() 
					* Math.pow(Math.max(0, Vector.dotProduct(v, rv)), properties.specularCoefficient);
			r += rAmbient + rDiffuse + rSpecular;
			
			double gAmbient = properties.ambientColorProperty.getG() * light.getColor().getG();
			double gDiffuse = properties.diffuseColorProperty.getG() * light.getColor().getG() 
					* Math.max(0, Vector.dotProduct(n, l));
			double gSpecular = properties.specularColorProperty.getG() * light.getColor().getG() 
					* Math.pow(Math.max(0, Vector.dotProduct(v, rv)), properties.specularCoefficient);
			g += gAmbient + gDiffuse + gSpecular;
			
			double bAmbient = properties.ambientColorProperty.getB() * light.getColor().getB();
			double bDiffuse = properties.diffuseColorProperty.getB() * light.getColor().getB() 
					* Math.max(0, Vector.dotProduct(n, l));
			double bSpecular = properties.specularColorProperty.getB() * light.getColor().getB() 
					* Math.pow(Math.max(0, Vector.dotProduct(v, rv)), properties.specularCoefficient);
			b += bAmbient + bDiffuse + bSpecular;
		}
		
		r = Math.min(1.0, r);
		g = Math.min(1.0, g);
		b = Math.min(1.0, b);
		
		return new Color(r, g, b);
	}
}
