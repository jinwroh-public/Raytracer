package com.jinwroh.raytracer.graphics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jinwroh.raytracer.geometric.Shape;


/**
 * The Scene class represents the lights and the objects (shapes) to which the raytracer
 * should shoot and trace rays. The Scene class is composed of shapes and lights 
 * that create the 'scene' of the raytracer.
 * 
 * @author Jin W. Roh
 * @version 1.0.0
 */
public class Scene {

	/**
	 * The data structures that contain the shapes and the lights.
	 * The integers act as unique Ids, or keys, that map to a single light or shape.
	 * Using the Ids, the caller will be able to delete or mutate the 
	 * respective shape or light.
	 */
	private Map<Integer, Shape> shapes;
	private Map<Integer, Light> lights;;
	
	/**
	 * The keys to shapes and lights. 
	 */
	private int shapeId;
	private int lightId;
	
	
	/**
	 * Constructs an empty scene. An empty scene is still a valid scene.
	 * Shape and Light keys are initialized to start from 0s, and will be incremented
	 * every time a light or a shape is added to the scene.
	 */
	public Scene () { 
		this.shapes = new HashMap<Integer, Shape>();
		this.lights = new HashMap<Integer, Light>();
		
		this.shapeId = 0;
		this.lightId = 0;
	}
	
	/**
	 * Adds a shape to the scene, and returns the unique ID respective to the Shape.
	 * @param shape    the shape to be added
	 * @return         the unique ID respective to the Shape
	 */
	public int addShape (Shape shape) {
		this.shapeId++;
		this.shapes.put(this.shapeId, shape);
		return this.shapeId;
	}
	
	/**
	 * Adds a light to the scene, and returns the unique ID respective to the Light.
	 * @param light    the light to be added
	 * @return         the unique ID respective to the Light
	 */
	public int addLight (Light light) {
		this.lightId++;
		this.lights.put(this.lightId, light);
		return this.lightId;
	}
	
	/**
	 * Removes a shape that correspond to the shape ID specified.
	 * @param shapeId    the unique shape id
	 */
	public void removeShape (int shapeId) {
		this.shapes.remove(shapeId);
	}
	
	/**
	 * Removes a light that correspond to the light ID specified.
	 * @param lightId    the unique light id
	 */
	public void removeLight (int lightId) {
		this.lights.remove(lightId);
	}
	
	/**
	 * Retrieves all the shapes in the scene.
	 * @return    a list of shapes in the scene
	 */
	public List<Shape> getShapes () {
		ArrayList<Shape> output = new ArrayList<Shape>();
		for (Map.Entry<Integer, Shape> entry : this.shapes.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}
	
	/**
	 * Retrieves all the lights in the scene
	 * @return    a list of the lights in the scene.
	 */
	public List<Light> getLights () {
		ArrayList<Light> output = new ArrayList<Light>();
		for (Map.Entry<Integer, Light> entry : this.lights.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}
}
