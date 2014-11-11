Raytracer
=========

v 1.0.0 Simple Raytracer

Created to provide a sample code base to anyone that may be interested.

#Introduction

Ray tracing is the technique in computer graphics to generate an image by - as the name implies - tracing rays. The traced paths of light through pixels in an image plane simulates the effects of its encounters with virtual objects.

If the aforementioned explanation is a bit hazy, perhaps a diagram might make it a clearer.
Take a look at: http://en.wikipedia.org/wiki/Ray_tracing_(graphics)#mediaviewer/File:Ray_trace_diagram.svg

In the above diagram, the camera generates the view rays that go through the image plane. If the view rays 'hits' the sphere object, it calculates the color with respect to the light source. After calculating the color, it records the color with the position that passed through the image plane. By collecting all the calculation, the image will be complete.


#Explanation of Code

###Package overview:
This codebase is a simple implementation of a raytracer written in Java. The code is divided into three packages: 
- STRATEGY (com.jinwroh.raytracer.strategy)
- GEOMETRIC (com.jinwroh.raytracer.geometric)
- GRAPHICS (com.jinwroh.raytracer.graphics)


The STRATEGY package contains the strategy design pattern (or Policy design pattern) for different shading algorithms. For example, an object in the scene can be shaded realistically, cartoonishly, with a glass-like shading, metallically, etc...
Currently, only a 'realistic' shading (Blinn-phong shading method) has been implemented. (Since it's v 1.0)
- ShadingStrategy.java (Strategy interface for shading algorithms)
- BlinnPhongShadingStrategy (Concrete implementation of a Shading strategy).


The GEOMETRIC package contains all the classes that represent the primitive geometric elements:
- Point.java (3 Dimensional cartesian plane)
- Vector.java (Direction and a magnitude)
- Ray.java (Composition of Vector and origin Point)
- Shape.java (Abstrac class that represents a shape)
- Sphere.java (Concrete implementaiton of a Shape)
The Shape class has two important methods that calculate if a ray hits the shape, and if so, calculate the color at that point. The coloring is done by the shading strategies - a Shape object has a reference to a concrete shading strategy implementation


The GRAPHICS package contain classes that are related to the actual raytracer scene and implementation, and related to the general category of graphics.
- Color.java (Encapsulates r, g, b value)
- Pixel.java (Encapuslates x, y position & a Color)
- Light.java (Represents a light direction, and the color of the light)
- Scene.java (Represent the raytracing scene - the scene to be traced with rays!)
- Viewport.java (The image plane from the diagram)
- Sample.java (An individual 'sampling' from the image plane, or viewport)
- Sampler.java (Responsible for splitting up the Viewport into samples, where the rays can pass through)
- Window.java (Encapsulates the actual output window sizes)
- Camera.java (Generates rays)


###Implementation explanation
With the package overview, let's go over setting up the raytracer. Everything is done in the 3 dimensional cartesian coordinate plane (x, y, z coordinates).

1. Set up an eye point.
2. Set up a viewport (the image plane in the diagram) 'some' distance away of the said eye point.
3. Create a scene with Shape(s) and Light(s) 'some' distance away from the viewport.
4. Determine the output size of the image, and create a Window class to encapsulate it.
5. Create a Camera object that will takes in the eye, viewport, and the Window.
6. The Camera is responsible for generating the rays, using the sampler.
7. By iterating through the sampler, we can find each pixels that correspond to the samples generated.
8. For each ray that pass through the sample from the viewport, calculate if it hits any shapes in the scene.
9. Store all coloring and position data, and output it out!

This is the high level overview of v 1.0 Simple Raytracer.
See Driver.java for a simple set up and to run the program. (Written with Eclipse IDE)

#Version 2.0 Todos:
- Add Triangle to Shapes
- Add Additional Shading Strategies
- Add Additional Output Strategies (png, json, swing?)
- Add reflection rays using recursion
- Add Shadowing functionality
- Add Glass refraction properties to shapes
- Setup Maven or Ant
