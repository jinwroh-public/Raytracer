package com.jinwroh.raytracer.graphics;

import java.util.Iterator;

import com.jinwroh.raytracer.geometric.Point;


/**
 * The Sampler class is responsible for creating samples from a given Viewport.
 * The Sample implements the Iterable interface to allow the Sampler to iterate
 * through the generated samples in the Viewport.
 * 
 * @author Roh
 * @version 1.0.0
 */
public class Sampler implements Iterable<Sample> {

	/**
	 * The viewport and the sampling dimensions.
	 */
	private Viewport viewport;
	private int widthSampleSize;
	private int heightSampleSize;
	
	/**
	 * The deltas represent the space between each sample points, in the 3d Cartesian
	 * System.
	 */
	private double widthSampleDelta;
	private double heightSampleDelta;
		
	
	/**
	 * Constructs a sampler with the given Viewport, and the specified sampling size
	 * in width and height.
	 * @param viewport           the given viewport
	 * @param widthSampleSize    the given width sample size
	 * @param heightSampleSize   the given height sample size
	 */
	public Sampler (Viewport viewport, int widthSampleSize, int heightSampleSize) {
		this.viewport = viewport;
		this.widthSampleSize = widthSampleSize;
		this.heightSampleSize = heightSampleSize;
		
		this.widthSampleDelta = viewport.getWidth() / widthSampleSize;
		this.heightSampleDelta = viewport.getHeight() / heightSampleSize;
	}
	
	
	@Override
	public Iterator<Sample> iterator () {
		return new SamplerIterator(this);
	}
	
	/**
	 * Gets the viewport of this sampler.
	 * @return    the viewport of this sampler
	 */
	public Viewport getViewport () {
		return this.viewport;
	}
	
	/**
	 * Gets the sample size along the width of the Viewport.
	 * @return    the width sample size
	 */
	public int getWidthSampleSize () {
		return this.widthSampleSize;
	}
	
	/**
	 * Gets the sample size along the height of the Viewport.
	 * @return    the height sample size
	 */
	public int getHeightSampleSize () {
		return this.heightSampleSize;
	}
	
	/**
	 * Gets the width sample delta.
	 * @return    the width sample delta
	 */
	public double getWidthSampleDelta () {
		return this.widthSampleDelta;
	}
	
	/**
	 * Gets the height sample delta
	 * @return    the height sample delta
	 */
	public double getHeightSampleDelta () {
		return this.heightSampleDelta;
	}
	
	
	/**
	 * The SamplerIterator is a private static inner class within the Sampler class.
	 * Implements the standard Iterator interface, EXCEPT the remove() operation.
	 * This class allows the caller to iterate through the Sampler's samples.
	 * 
	 * @author Roh
	 * @Version 1.0.0
	 */
	private static final class SamplerIterator implements Iterator<Sample> {
		
		/**
		 * The iterator maintains a reference to the outer class, and the counts
		 * of the width and the height indices.
		 */
		private Sampler sampler;
		private int widthSampleCounter;
		private int heightSampleCounter;
		
		
		/**
		 * Constructs a Sampler Iterator with the outer Sampler class reference.
		 * 
		 * @param sampler    the outer Sampler class reference.
		 */
		public SamplerIterator (Sampler sampler) {
			this.sampler = sampler;
			this.widthSampleCounter = 0;
			this.heightSampleCounter = 0;
		}
		
		@Override
		public boolean hasNext () {
			// 
			return this.heightSampleCounter < this.sampler.getHeightSampleSize();
		}

		@Override
		public Sample next () {
			
			// Guard clause: preemptive check.
			if ( !hasNext() ) {
				throw new IllegalStateException();
			}
			
			// Find the point of reference, or the 'starting point' of the Sampler
			double xOrigin = this.sampler.getViewport().getUpperLeft().getX();
			double yOrigin = this.sampler.getViewport().getUpperLeft().getY();
			double zOrigin = this.sampler.getViewport().getUpperLeft().getZ();
			
			// For the current sampling point, lets find the offset from the starting point
			// Note that since the viewport is perpendicular to the x-y plane, the z-offset
			// will be zero
			double xOffset = (this.sampler.getWidthSampleDelta() * this.widthSampleCounter);
			double yOffset = (this.sampler.getHeightSampleDelta() * this.heightSampleCounter);
			double zOffset = 0.0;
					
			// We are starting from the upper left corner - moving to the right and down-
			// ward direction
			double xCoordinate = xOrigin + xOffset;
			double yCoordinate = yOrigin - yOffset;
			double zCoordinate = zOrigin + zOffset;
			
			// Create the Sample object with the point calculated
			Point point = new Point(xCoordinate, yCoordinate, zCoordinate);
			Sample sample = new Sample(point, widthSampleCounter, heightSampleCounter);
			
			// Increment the width sample counter, but we should reset it to 0
			// if it goes over the maximum size allowed.
			this.widthSampleCounter++;
			if ( this.widthSampleCounter >= this.sampler.getWidthSampleSize() ) {
				this.widthSampleCounter = 0;
				this.heightSampleCounter++;
			}
			
			return sample;
		}

		@Override
		public void remove () {
			// Can't remove samples from a viewport - doesn't really make sense, does it?
			throw new UnsupportedOperationException();
		}
	}
}
