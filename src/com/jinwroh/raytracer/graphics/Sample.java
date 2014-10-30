package com.jinwroh.raytracer.graphics;

import com.jinwroh.raytracer.geometric.Point;


/**
 * The Sample class represents a single sampled point from the viewport.
 * A single sample will be mapped to a single pixel to a single Pixel 
 * in the final output image. A Sample is a representation in the 3
 * dimensional Cartesian coordinate space - encapsulating a point with
 * a defined x, y ordering, whereas a Pixel represents a pixel in the final
 * output, encapsulating a color.
 * 
 * 
 * @author Roh
 * @version 1.0.0
 */
public class Sample {

	/**
	 * The 3d point in the system, with the x, y ordering. This raytracing
	 * program will use the ordering: x:0 y:0 starting from the upper left 
	 * corner.
	 */
	private Point point;
	private int xOrdering;
	private int yOrdering;
	
	
	/**
	 * Constructs a Sample with a given point, and the x, y ordering.
	 * @param point
	 * @param xOrdering
	 * @param yOrdering
	 */
	public Sample (Point point, int xOrdering, int yOrdering) {
		this.point = point;
		this.xOrdering = xOrdering;
		this.yOrdering = yOrdering;
	}

	
	/**
	 * Gets the point of this sample.
	 * @return    the point of this sample
	 */
	public Point getPoint () {
		return point;
	}

	/**
	 * Get the x ordering of this sample.
	 * @return    the x ordering of this sample
	 */
	public int getXOrdering () {
		return xOrdering;
	}

	/**
	 * Gets the y ordering of this sample
	 * @return    the y ordering of this sample
	 */
	public int getYOrdering () {
		return yOrdering;
	}
	
	/**
	 * Sets the x ordering of this Sample.
	 * @param xOrdering    the new x ordering
	 */
	public void setXOrdering (int xOrdering) {
		this.xOrdering = xOrdering;
	}
	
	/**
	 * Sets the y ordering of this Sample.
	 * @param yOrdering    the new y ordering
	 */
	public void setYOrdering (int yOrdering) {
		this.yOrdering = yOrdering;
	}
	
	@Override
	public String toString () {
		String output = "Sample: ";
		
		output += "\n\t" + this.point;
		output += "\n\twidthPosition: " + this.xOrdering;
		output += "\n\theightPosition: " + this.yOrdering;

		return output;
	}
}
