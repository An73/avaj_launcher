# avaj_launcher
In subject of this project I had to implement an aircraft simulation program based on the class diagram that was provided
to me. All classes are required to be implemented respecting every detail provided
in the diagram. I might add more classes or include additional attributes if I considered
them to be necessary.


In this project it is necessary to implement Observer, Singleton and Factory design patterns.

![avaj_uml 4](https://user-images.githubusercontent.com/33597605/43993242-05d0b266-9d93-11e8-940a-fe9942ada84e.jpg)

This program will take one and only one argument from the command line. This argument
represents the name of a text file that will contain the scenario that needs to be
simulated.
Executing the program will generate a file simulation.txt that describes the outcome
of the simulation.

Example:

<img width="602" alt="screen shot 2018-08-11 at 6 20 51 pm" src="https://user-images.githubusercontent.com/33597605/43993269-5e08e908-9d93-11e8-9ad3-8e8fa43c5404.png">

# Scenario file

The first line of the file contains a positive integer number. This number represents the
number of times the simulation is run. In our case, this will be the number of times a
weather change is triggered.
Each following line describes an aircraft that will be part of the simulation, with this
format: TYPE NAME LONGITUDE LATITUDE HEIGHT.

#  Weather generation

There are 4 types of weather:
- RAIN
- FOG
- SUN
- SNOW

# Aircrafts

JetPlane:
- SUN - Latitude increases with 10, Height increases with 2
- RAIN - Latitude increases with 5
- FOG - Latitude increases with 1
- SNOW - Height decreases with 7

Helicopter:
- SUN - Longitude increases with 10, Height increases with 2
- RAIN - Longitude increases with 5
- FOG - Longitude increases with 1
- SNOW - Height decreases with 12

Baloon:
- SUN - Longitude increases with 2, Height increases with 4
- RAIN - Height decreases with 5
- FOG - Height decreases with 3
- SNOW - Height decreases with 15

# Simulation

- Coordinates are positive numbers.
- The height is in the 0-100 range.
- If an aircraft needs to pass the upper limit height it remains at 100.
- Each time an aircraft is created, it receives a unique ID. There can’t be 2 aircrafts
with the same ID.
- If an aircraft reaches height 0 or needs to go below it, the aircraft lands, unregisters
from the weather tower and logs its current coordinates.
- When a weather change occurs, each aircraft type needs to log a message, as seen in
the example. The message format is: TYPE#NAME(UNIQUE_ID): SPECIFIC_MESSAGE.
A funny message will be appreciated during the correction.
- Each time an aircraft registers or unregisters to/from the weather tower, a message
will be logged.
