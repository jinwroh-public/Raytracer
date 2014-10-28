package com.jinwroh.raytracer.graphics;

/**
 * The Window class represents the actual pixel dimensions in which the 
 * raytracer should output its final image. The width and the height
 * of the Window class are the pixel width and height dimensions, and thus
 * defines the sampling size of the raytracer. Each sampled point will
 * correspond to a pixel. Therefore, the total sampling size of the raytracer
 * will be given by the number: width x height. For example, a 200 by 200 pixel
 * Window will generate 40000 sample, each corresponding to a pixel in the Window.
 * 
 * @author	Jin W. Roh
 * @version	1.0.0
 */
public class Window {
	
	/**
	 * The width and the height of the Window.
	 */
	private int width;
	private int height;
	
	
	/**
	 * Constructs a Window class with the given dimensions.
	 * @param width    the width of the Window
	 * @param height   the height of the Window
	 */
	public Window (int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	
	/**
	 * Gets the width of the Window.
	 * @return    the width of the Window
	 */
	public int getWidth () {
		return this.width;
	}
	
	/**
	 * Get the height of the Window.
	 * @return    the height of the Window
	 */
	public int getHeight () {
		return this.height;
	}
	
	/**
	 * Sets the width of the Window
	 * @param width    the new width of the Window
	 */
	public void setWidth (int width) {
		this.width = width;
	}
	
	/**
	 * Sets the height of the Window
	 * @param height    the new height of the Window
	 */
	public void setHeight (int height) {
		this.height = height;
	}
}
