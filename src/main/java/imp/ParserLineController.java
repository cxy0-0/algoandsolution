package imp;

import directionEnum.CommandEnum;
import directionEnum.OrientationEnum;
import dto.RoverDTO;
import dto.GridDTO;

import java.util.ArrayList;
import java.util.List;

public class ParserLineController {
    private static final String SEPARATOR = " ";

    /**
     *
     * @param line give Coordinates of the plateau  (ex 5 5)
     * @return Coordinates of the plateau
     */
    public static GridDTO parseGridDTO(String line) {
        int x = 0;
        int y = 0;
        if (line.contains(SEPARATOR)) {
            x = Integer.valueOf(line.split(SEPARATOR)[0]);
            y = Integer.valueOf(line.split(SEPARATOR)[1]);
        }
        return new GridDTO(x, y);
    }

    /**
     *
     * @param line give the rover's position (ex 1 3 N)
     * @return the rover's position
     */
    public static RoverDTO parseRoverDTO(String line) {
        int x = 0;
        int y = 0;
        OrientationEnum command = null;

        if (line.contains(SEPARATOR)) {
            x = Integer.valueOf(line.split(SEPARATOR)[0]);
            y = Integer.valueOf(line.split(SEPARATOR)[1]);
            command = OrientationEnum.valueOf(line.split(SEPARATOR)[2]);
        }
        return new RoverDTO(x, y, command);
    }

    /**
     *
     * @param line give the rover's instructions (ex  [L, M, L, M, L, M, L, M, M])
     * return a list of instructions
     */
    public static List<CommandEnum> parseCommand (String line) {
        List<CommandEnum> orders = new ArrayList<>();
        char[] chars = line.toCharArray();
        for (char myChar : chars) {
            orders.add(CommandEnum.valueOf(Character.toString(myChar)));
        }
        return orders;
    }
}
