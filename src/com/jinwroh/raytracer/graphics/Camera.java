package com.jinwroh.raytracer.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.jinwroh.raytracer.geometric.Point;
import com.jinwroh.raytracer.geometric.Ray;
import com.jinwroh.raytracer.geometric.Shape;
import com.jinwroh.raytracer.geometric.Vector;


/**
 * The Camera class is the primary object responsible for managing the rays.
 * This class generates and traces the rays with respect to the raytracing 
 * scene. The Camera class is directly responsible for the output of the
 * raytracer.
 * 
 * @author Jin W. Roh
 * @Version 1.0.0
 */
public class Camera {
	
	/**
	 * The eye is the origin point for all the rays generated, and passes
	 * through the viewport in the 3d Cartesian coordinate space.
	 * 
	 * The window is related to the actual output of the camera - it contains
	 * information for the sample size.
	 * 
	 * The pixels list serve as a buffer for all the computed pixels.
	 */
	private Point eye;
	private Viewport viewport;
	private Window window;
	
	private ArrayList<Pixel> pixels = new ArrayList<Pixel>();
	
	
	/**
	 * Constructs a Camera with the given eye, viewport, and window
	 * 
	 * @param eye          the eyepoint of the camera
	 * @param viewport     the viewport of the camera
	 * @param window       the window of the camera
	 */
	public Camera (Point eye, Viewport viewport, Window window) {
		this.eye = eye;
		this.viewport = viewport;
		this.window = window;
	}
	
	/**
	 * Generates rays directed towards the raytracing scene. The computed
	 * pixels are stored in the pixels buffer list.
	 * 
	 * @param scene    the scene to which all rays are directed.
	 */
	public void shoot (Scene scene) {
		
		Sampler sampler = new Sampler(this.viewport, this.window.getWidth(), this.window.getHeight());
		
		// for each sampled point in the viewport, we will generate rays and trace it
		for (Sample sample : sampler) {
			
			Vector direction = new Vector(this.eye, sample.getPoint());
			Ray ray = new Ray(this.eye, direction);
			Color color = this.trace(ray, scene);
			Pixel pixel = new Pixel(sample.getXOrdering(), sample.getYOrdering(), color);
			
			pixels.add(pixel);
		}
	}
	
	
	/**
	 * Traces an individual ray directed towards a given scene. If the ray hits an object,
	 * an appropriate color is returned. If not, the default color, black, is returned.
	 * 
	 * @param ray      the ray to be traced
	 * @param scene    the scene to which the ray is directed
	 * @return         the computed color, resulting from the traced ray.
	 */
	private Color trace (Ray ray, Scene scene) {
		
		// We should only consider the first object that the ray hits, since
		// that first object is the object seen through the viewport.
		// We will thus have to iterate through all the shapes in the raytracing
		// scene and find the first hit point, and take the color from that point.
		
		List<Shape> shapes = scene.getShapes();
		
		double bestTimeHit = Double.MAX_VALUE;
		Shape bestShape = null;	// is in your twenties
		Shape.LocalCalculations bestCalculation = null;
		Ray bestRay = null;
		
		for (Shape shape : shapes) {
			Shape.LocalCalculations calculation = shape.calculateIntersection(ray);
			if ((calculation.hits) && (bestTimeHit > calculation.timeHit)) {
				bestRay = ray;
				bestShape = shape;
				bestCalculation = calculation;
			}
		}
		
		return (bestShape == null) ? 
				new Color() : 
				bestShape.shade(bestRay, bestCalculation, scene);
	}
	
	
	/**
	 * Prints the pixels appropriately. Refactor out later on.
	 */
	public void print() {
		try {
		
			BufferedImage bi = new BufferedImage(this.window.getWidth(), 
					this.window.getHeight(), BufferedImage.TYPE_INT_RGB);
		  
			for (Pixel p : pixels) {
				int r = (int) (p.getColor().getR() * 255);
				int g = (int) (p.getColor().getG() * 255);
				int b = (int) (p.getColor().getB() * 255);
				int col = (r << 16) | (g << 8) | b;
				bi.setRGB(p.getX(), p.getY(), col);
			}
		
			ImageIO.write(bi, "png", new File("output.png"));
		} 
		catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
