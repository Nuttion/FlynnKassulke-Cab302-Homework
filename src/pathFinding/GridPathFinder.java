package pathFinding;

import common.Location;

public interface GridPathFinder {
    /**
     * Returns the path from the start location to the end location.
     * @param startLocation The start location
     * @param endLocation The end location
     * @return The path from the start location to the end location
     */

    //Week 3.3
        //this interface represents the findPath and getNeighbors algorithms
    Path findPath(Location startLocation, Location endLocation);

    /**
     * Returns the traversable neighbors of the given location.
     * @param location The location to get the neighbors of
     * @return The traversable neighbors of the given location
     */
    Iterable<Location> getNeighbors(Location location);
}