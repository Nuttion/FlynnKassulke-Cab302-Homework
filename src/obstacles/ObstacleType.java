package obstacles;

/**
 * Represents the different types of obstacles that can be on the map.
 */

// Week 2.4
    //The obstacle type enum allows for an enum type to determine different obstacles.
    //From this we set an argumentName as well as the symbol for the obstacle.

// Week 4.1
    //Add the rest of the obstacle types
public enum ObstacleType {
    GUARD("g", 'g'),
    FENCE("f", 'f'),
    SENSOR("s", 's'),
    CAMERA("c", 'c');

    private final String argumentName;
    private final char symbol;

    /**
     * Constructs a new ObstacleType object with the given argument name and flag.
     * @param argumentName The argument name of the obstacle type
     * @param symbol The flag of the obstacle type
     */
    ObstacleType(String argumentName, char symbol) {
        this.argumentName = argumentName;
        this.symbol = symbol;
    }

    /**
     * Returns the argument name of the obstacle type.
     * @return The argument name of the obstacle type
     */
    public String getArgumentName() {
        return argumentName;
    }

    /**
     * Returns the symbol of the obstacle type.
     * @return The symbol of the obstacle type
     */
    public char getSymbol() {
        return symbol;
    }
}