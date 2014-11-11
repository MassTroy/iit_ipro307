# Passive Thermal

Passive Thermal is a project designed for routing shipping containers on trucks to acheive thermal effeciency in non-refridgerated containers or to choose more efficient routes for refridgerated containers.

The application is designed as a web page. Users enter the starting and ending locations, as well as the starting temperature of the container. The application then uses the Google Maps - Directions API to query several routes between the origin and destination. Then weather information is queried from the OpenWeatherMap API and fed into a thermal model which simulates the thermal effects on the container. The model takes into account the following weather factors.

* duration
* air temperature
* solar radiation
* sky cover
* air velocity

## Module breakdown

The project is split up into 4 modules to organize the code. The first two modules are 

### GoogleMaps_API and OpenWeatherMap_API
These two modules provide the plain old java objects which the jackson framework builds from the json code recieved from the api calls. These java objects are data only and provide no logic.

### PassiveThermalDomain
This module contains all of the logic for the entire application. It makes the calls to the APIs, reduces routes, and computes thermal estimates. See the detailed readme for more.

### PassiveThermalWeb
This module contains the presentation layer for the application. There are several JSP files which contain the code for generating the html. The java files provide the controllers for each page, and for accepting the form data. See the detailed readme for more.

## Hosting
The project is currently hosted on Openshift PaaS by Red Hat. It is a free PaaS that allows free accounts of up to 3 applications. It uses a git repository to push deployments. See [openshift.com](https://www.openshift.com/) for more details. Create your own account to host it yourself. Setup takes 10-15 minutes.

## References
Special thanks to the following:

* Google Maps API
* OpenWeatherMap API
* Spring Framework
* Openshift PaaS
* Bootstrap Framework

