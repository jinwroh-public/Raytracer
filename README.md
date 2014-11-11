Raytracer
=========

v 1.0.0 Simple Raytracer

#Introduction

Ray tracing is the technique in computer graphics to generate an image by - as the name implies - tracing rays. The traced paths of light through pixels in an image plane simulates the effects of its encounters with virtual objects.

If the aforementioned explanation is a bit hazy, perhaps a diagram might make it a clearer.
Take a look at: http://en.wikipedia.org/wiki/Ray_tracing_(graphics)#mediaviewer/File:Ray_trace_diagram.svg

In the above diagram, the camera generates the view rays that go through the image plane. If the view rays 'hits' the sphere object, it calculates the color with respect to the light source. After calculating the color, it records the color with the position that passed through the image plane. By collecting all the calculation, the image will be complete.


#Explanation of Code
This codebase is a simple implementation of a raytracer written in JAVA. The code is divided into three packages: 

