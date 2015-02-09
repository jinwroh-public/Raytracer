package com.jinwroh.raytracer;

import com.jinwroh.raytracer.geometric.Point;
import com.jinwroh.raytracer.geometric.Shape;
import com.jinwroh.raytracer.geometric.Sphere;
import com.jinwroh.raytracer.geometric.Vector;
import com.jinwroh.raytracer.graphics.Camera;
import com.jinwroh.raytracer.graphics.Color;
import com.jinwroh.raytracer.graphics.Light;
import com.jinwroh.raytracer.graphics.Scene;
import com.jinwroh.raytracer.graphics.Viewport;
import com.jinwroh.raytracer.graphics.Window;
import com.jinwroh.raytracer.strategy.shading.BlinnPhongShadingStrategy;
import com.jinwroh.raytracer.strategy.shading.ShadingStrategy;

public class Driver {

	public static void main (String[] args) {
		
		// Setting up the raytracer elementes
		Point eye = new Point(0.0, 0.0, 0.0);
		Viewport viewport = new Viewport(2, 2, new Point(0, 0, 2));
		Window window = new Window(500, 500);
		Camera camera = new Camera(eye, viewport, window);		
		
		
		// Create a test sphere
		Point sphereCenterPoint = new Point(0, 0, 20);
		double sphereRadius = 3.0;
		Shape.Properties sphereProperties = new Shape.Properties();
		sphereProperties.ambientColorProperty = new Color(0.1, 0.1, 0.1);
		sphereProperties.diffuseColorProperty = new Color(1.0, 0.0, 0.0);
		sphereProperties.specularColorProperty = new Color(1.0, 1.0, 1.0);
		sphereProperties.specularCoefficient = 500;
		ShadingStrategy sphereShadingStrategy = new BlinnPhongShadingStrategy();
		Sphere sphere = new Sphere (sphereCenterPoint, sphereRadius, sphereProperties, sphereShadingStrategy);
		
		
		// Create a test sphere
		Point sphereCenterPoint2 = new Point(2, 2, 10);
		double sphereRadius2 = 3.0;
		Shape.Properties sphereProperties2 = new Shape.Properties();
		sphereProperties2.ambientColorProperty = new Color(0.1, 0.1, 0.1);
		sphereProperties2.diffuseColorProperty = new Color(1.0, 0.0, 0.0);
		sphereProperties2.specularColorProperty = new Color(1.0, 1.0, 1.0);
		sphereProperties2.specularCoefficient = 50;
		ShadingStrategy sphereShadingStrategy2 = new BlinnPhongShadingStrategy();
		Sphere sphere2 = new Sphere (sphereCenterPoint2, sphereRadius2, sphereProperties2, sphereShadingStrategy2);
		
		// Create a test light
		Light light = new Light(new Vector (0.57735027, -0.57735027, 0.57735027), new Color (1, 1, 1));
		
		
		// Setting up the scene
		Scene sceneOne = new Scene();
		sceneOne.addLight(light);
		sceneOne.addShape(sphere);
		//sceneOne.addShape(sphere2);
		
		// ACTION!
		camera.shoot(sceneOne);
		camera.print();
	}
}
