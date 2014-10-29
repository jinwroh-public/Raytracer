package com.jinwroh.raytracer.graphics;

import com.jinwroh.raytracer.geometric.Point;


/**
 * The Viewport class represents a rectangle 'viewing window' in the 3 dimensional
 * Cartesian coordinate space to which the scene (image) will be mapped, or projected.
 * The Viewport is perpendicular to the x-y plane (stands 'upright') in the space.
 * Only the view rays (originating from the eye point) that pass through this
 * viewport will be considered and traced. The Viewport acts like the 'bounding-box'
 * of the final image. The four corner points represent the 4 vertices of the square
 * Viewport. It is important to note that the Viewport size does not dictate the final
 * pixel size of the final image output. For a given Viewport, there may be different sample
 * sizes, resulting in different resolution. For example, a single Viewport class
 * can be used to generate 200 by 200 pixel output, or 400 by 400 pixel output, depending
 * on the number of rays that passes through the Viewport (e.g. 40000 rays that pass through 
 * the Viewport will have a higher sampling and resolution compared to 20000 rays). 
 * The sampling size is dictated by the Window Class (See Window.java). 
 * 
 * @author  Jin W. Roh
 * @version 1.0.0
 */
public class Viewport {

	/**
	 * The width and the height of the Viewport. Note that this is NOT
	 * the pixel width and height of the final image, but represent the
	 * width and height in the 3d coordinate system where the raytracing
	 * will happen.
	 */
	private double width;
	private double height;
	
	/**
	 * The four corner Point of the Viewport.
	 */
	private Point upperLeft;
	private Point upperRight;
	private Point lowerLeft;
	private Point lowerRight;
	
	/**
	 * The center of the Viewport.
	 */
	private Point center;

	
	/**
	 * Constructs a Viewport with the given width and height, relative to the
	 * center point.
	 * 
	 * @param width    the width of the Viewport
	 * @param height   the height of the Viewport
	 * @param center   the center of the Viewport
	 */
	public Viewport (double width, double height, Point center) {
		this.setDimensions(width, height, center);
	}
	
	/**
	 * Constructs a Viewport by providing the four corner points of the Viewport.
	 * 
	 * @param upperLeft    the upper left corner point
	 * @param upperRight   the upper right corner point
	 * @param lowerLeft    the lower left corner point
	 * @param lowerRight   the lower right corner point
	 */
	public Viewport (Point upperLeft, Point upperRight, Point lowerLeft, Point lowerRight) {
		this.setCornerPoints(upperLeft, upperRight, lowerLeft, lowerRight);
	}
	
	
	/* Mutators */
	/**
	 * Sets the dimensions of this Viewport from the given width, height, and the
	 * relative center point.
	 * 
	 * @param width    the width of the Viewport
	 * @param height   the height of the Viewport
	 * @param center   the center of the Viewport
	 */
	public void setDimensions (double width, double height, Point center) {
		this.width = width;
		this.height = height;
		this.center = center;
		
		// Calculate the four corners of this viewport.
		double right = (width / 2.0) + center.getX();
		double left = center.getX() - (width / 2.0);
		double up = (height / 2.0) + center.getY();
		double down = center.getY() - (height / 2.0);
		
		this.upperLeft = new Point(left, up, center.getZ());
		this.upperRight = new Point(right, up, center.getZ());
		this.lowerLeft = new Point(left, down, center.getZ());
		this.lowerRight = new Point(right, down, center.getZ());
	}
	
	/**
	 * Sets the four corner points of the Viewport.
	 * @param upperLeft    the upper left corner point
	 * @param upperRight   the upper right corner point
	 * @param lowerLeft    the lower left corner point
	 * @param lowerRight   the lower right corner point
	 */
	public void setCornerPoints (Point upperLeft, Point upperRight, Point lowerLeft, Point lowerRight) {
		this.upperLeft = upperLeft;
		this.upperRight = upperRight;
		this.lowerLeft = lowerLeft;
		this.lowerRight = lowerRight;
		
		this.width = upperRight.getX() - upperLeft.getX();
		this.height = upperLeft.getY() - lowerLeft.getY();
		this.center = new Point(this.width / 2.0, this.height / 2.0, upperLeft.getZ());
	}
	
	
	/* Accessors */
	/**
	 * Gets the width of this Viewport.
	 * @return    the width of this Viewport
	 */
	public double getWidth () {
		return this.width;
	}
	
	/**
	 * Gets the height of this Viewport.
	 * @return    the height of this Viewport
	 */
	public double getHeight () {
		return this.height;
	}
	
	/**
	 * Gets the center point of this Viewport.
	 * @return    the center point of this Viewport
	 */
	public Point getCenter () {
		return this.center;
	}

	/**
	 * Gets the upper left corner of this Viewport.
	 * @return    the upper left corner of this Viewport
	 */
	public Point getUpperLeft () {
		return this.upperLeft;
	}

	/**
	 * Gets the upper right corner of this Viewport.
	 * @return    the upper right corner of this Viewport
	 */
	public Point getUpperRight () {
		return this.upperRight;
	}

	/**
	 * Gets the lower left corner of this Viewport.
	 * @return    the lower left corner of this Viewport
	 */
	public Point getLowerLeft () {
		return this.lowerLeft;
	}

	/**
	 * Gets the lower right corner of this Viewport.
	 * @return    the lower right corner of this Viewport
	 */
	public Point getLowerRight () {
		return this.lowerRight;
	}
	
	
	@Override
	public String toString () {
		String output = "Viewport: ";
		
		output += "\n\tWidth: " + this.width + " height: " + this.height;
		output += "\n\tCenter: " + this.center;
		output += "\n\tUpper left coordinates: " + this.upperLeft;
		output += "\n\tUpper right coordinates: " + this.upperRight;
		output += "\n\tLower left coordinates: " + this.lowerLeft;
		output += "\n\tUpper right coordinates: " + this.lowerRight;

		return output;
	}
}
