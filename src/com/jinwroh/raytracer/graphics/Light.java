package com.jinwroh.raytracer.graphics;

import com.jinwroh.raytracer.geometric.Vector;


/**
 * The Light class represents a directional light in the raytracing scene.
 * A directional light can be seen as a light source infinitely far away
 * (i.e. light rays from the sun), and thus every point in the scene will 
 * have the same light rays hitting the said point.
 * 
 * @author	Jin W. Roh
 * @version	1.0.0
 */
public class Light {

	/**
	 * The direction vector denotes the light ray TOWARDS a given point.
	 * The boolean on represent if the light is on or off.
	 */
	private Vector direction;
	private Color color;
	private boolean on;
	
	
	/**
	 * Constructs a Light that shines in a given Vector direction and with 
	 * the color.
	 * @param direction    the light direction
	 * @param color        the color of the light
	 */
	public Light (Vector direction, Color color) {
		this.direction = direction;
		this.color = color;
		this.on = true;
	}
	
	
	/* Accessors */
	/**
	 * Gets the Vector direction of this Light TOWARDS the scene
	 * @return    The Vector direction of this light Towards the scene
	 */
	public Vector getDirection () {
		return this.direction;
	}
	
	/**
	 * Gets the color of this Light.
	 * @return    the color of this Light.
	 */
	public Color getColor () {
		return this.color;
	}

	/**
	 * Turns this Light on - i.e. this Light should be considered.
	 */
	public void turnOn () {
		this.on = true;
	}
	
	/**
	 * Turns this Light off - i.e this Light should not be considered.
	 */
	public void turnOff () {
		this.on = false;
	}
	
	/**
	 * Flicks this Light on and off, like a switch. If the Light is on, the
	 * Light will now be off, and vice versa.
	 */
	public void flick () {
		this.on = !this.on;
	}
	
	/**
	 * Gets the light on status.
	 * @return   true if the light is on, false otherwise
	 */
	public boolean isOn () {
		return this.on;
	}
	
	
	/* Mutators */
	/**
	 * Sets the Vector direction of this Light, TOWARDS the scene.
	 * @param direction    the new Vector direction of this Light, TOWARDS the scene
	 */
	public void setDirection (Vector direction) {
		this.direction = direction;
	}
	
	/**
	 * Sets the Color of this light.
	 * @param color    the Color of this light
	 */
	public void setColor (Color color) {
		this.color = color;
	}
}
