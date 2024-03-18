import java.util.ArrayList;
import java.util.HashMap;
import obstacles.*;
import common.*;

class Main {

    public static void main(String[] args) {
        // Parse the command line arguments into obstacles
        // and create a map with those obstacles
        HashMap<String, ArrayList<String>> parsedArgs = parseArgs(args);
        ArrayList<Obstacle> obstacles = parseObstacles(parsedArgs);
        Map map = new Map(obstacles);

        // Parse the start and target locations
        String startArg = stripParentheses(parsedArgs.get("-start").get(0));
        String targetArg = stripParentheses(parsedArgs.get("-target").get(0));
        Location start = Location.parse(startArg);
        Location target = Location.parse(targetArg);

        // Show the map
        System.out.println(map.getSolvedMap(start, target));
    }

    /**
     * Parses the command line arguments into a HashMap of arguments
     * @param args The command line arguments
     * @return A HashMap of arguments
     */

    /*
        Week 1 Homework
        With each parsed argument, it gets the values of the argument and puts it in its own string array list. It also c
     */
    private static HashMap<String, ArrayList<String>> parseArgs(String[] args) {
        HashMap<String, ArrayList<String>> parsedArgs = new HashMap<>();
        ArrayList<String> argValues = null;
        for (String arg : args) {
            if (arg.startsWith("-")) {
                argValues = new ArrayList<>();
                parsedArgs.put(arg, argValues);
                continue;
            }
            if (argValues != null) {
                argValues.add(arg);
            }
        }
        return parsedArgs;
    }

    /**
     * Strips the parentheses from the argument
     * @param arg The argument to strip
     * @return The argument without parentheses
     */
    private static String stripParentheses(String arg) {
        return arg.substring(1, arg.length() - 1);
    }

    /**
     * Parses the obstacles from the command line arguments
     * @param parsedArgs The parsed arguments
     */
    public static ArrayList<Obstacle> parseObstacles(HashMap<String, ArrayList<String>> parsedArgs) {
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        for (ObstacleType type : ObstacleType.values()) {
            String key = "-" + type.getArgumentName();
            ArrayList<String> args = parsedArgs.get(key);
            if (args == null) {
                continue;
            }
            for (String arg : args) {
                // Remove the parentheses from the argument
                String cleanedArg = stripParentheses(arg);
                Obstacle obstacle = switch (type) {
                    case GUARD -> Guard.parse(cleanedArg);
                    case FENCE -> Fence.parse(cleanedArg);
                    case SENSOR -> Sensor.parse(cleanedArg);
                    case CAMERA -> Camera.parse(cleanedArg);
                };
                obstacles.add(obstacle);
            }
        }
        return obstacles;
    }
}