# Passive Thermal Domain
This module contains all of the logic related to running the application. The following sections outline each of the java packages and what they contain

## common.util
Assorted utility classes used in the application including:

* DateDurationCalculator
* DateFormatter
* DateOffsetCalculator
* DistanceConverter
* PrefixLogger
* RoundingUtil
* SpeedConverter
* TemperatureConverter

## iit.ipro307.config
Spring configuration classes for initilizing the domain layer objects. See the spring docs for how these work.

## iit.ipro307.domain
A majority of the application logic is contained in these classes

## ThermalRouteService
Top level logic for running the application.

### RouteReducer
Breaks long routes down into fewer segments by combining short segments. This is used to prevent quering the weather at locations very close to each other.

### RouteTemperatureCalculator
Iterates over each of the segments of the route and finds the final temperature of the segment.

### SegmentTemperatureCalculator
Accepts the weather information, starting temperature conditions, and duration of each segment and finds the final temperature of the segment.

## iit.ipro307.client
Client code for invoking each of the APIs

## iit.ipro307.data
Data objects for storing domain layer data objects such as temperature or coordinates.

## iit.ipro307.exception
Custom exceptions used by the application to control various error levels of the application

## iit.ipro307.thermal.model
Model objects representing the input data contained in a form, and all data required for rendering the page.

