Raytracer
=========

v 1.0.0 Simple Raytracer

#Introduction

Ray tracing is the technique in computer graphics to generate an image by - as the name implies - tracing rays. The traced paths of light through pixels in an image plane simulates the effects of its encounters with virtual objects.

If the aforementioned explanation is a bit hazy, perhaps a diagram might make it a clearer.
Take a look at: http://en.wikipedia.org/wiki/Ray_tracing_(graphics)#mediaviewer/File:Ray_trace_diagram.svg

In the above diagram, the camera generates the view rays that go through the image plane. If the view rays 'hits' the sphere object, it calculates the color with respect to the light source. After calculating the color, it records the color with the position that passed through the image plane. By collecting all the calculation, the image will be complete.


#Explanation of Code
This codebase is a simple implementation of a raytracer written in Java. The code is divided into three packages: 
STRATEGY (com.jinwroh.raytracer.strategy)
GEOMETRIC (com.jinwroh.raytracer.geometric)
GRAPHICS (com.jinwroh.raytracer.graphics)

The STRATEGY package contains the strategy design pattern (or Policy design pattern) for different shading algorithms. For example, an object in the scene can be shaded realistically, cartoonishly, with a glass-like shading, metallically, etc...
Currently, only a 'realistic' shading (Blinn-phong shading method) has been implemented. (Since it's v 1.0)
ShadingStrategy.java (Strategy interface for shading algorithms)
BlinnPhongShadingStrategy (Concrete implementation of a Shading strategy).

The GEOMETRIC package contains all the classes that represent the primitive geometric elements:
Point.java (3 Dimensional cartesian plane)
Vector.java (Direction and a magnitude)
Ray.java (Composition of Vector and origin Point)
Shape.java (Abstrac class that represents a shape)
Sphere.java (Concrete implementaiton of a Shape)
The Shape class has two important methods that calculate if a ray hits the shape, and if so, calculate the color at that point. The coloring is done by the shading strategies - a Shape object has a reference to a concrete shading strategy implementation

The GRAPHICS package contain classes that are related to the actual raytracer scene and implementation, and related to the general category of graphics.
Color.java (Encapsulates r, g, b value)
Pixel.java (Encapuslates x, y position & a Color)
Light.java (Represents a light direction, and the color of the light)
Scene.java (Represent the raytracing scene - the scene to be traced with rays!)
Viewport.java (The image plane from the diagram)
Sample.java (An individual 'sampling' from the image plane, or viewport)
Sampler.java (Responsible for splitting up the Viewport into samples, where the rays can pass through)
Window.java (Encapsulates the actual output window sizes)
Camera.java (Generates rays)


