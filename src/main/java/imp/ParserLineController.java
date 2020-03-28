package imp;

import dto.RoverDTO;
import dto.OrientationEnum;
import dto.GridDTO;
import dto.CommandEnum;

import java.util.ArrayList;
import java.util.List;

public class ParserLineController {
    private static final String SEPARATOR = " ";

    public static GridDTO parseGridDTO(String line) {
        int x = 0;
        int y = 0;
        if (line.contains(SEPARATOR)) {
            x = Integer.valueOf(line.split(SEPARATOR)[0]);
            y = Integer.valueOf(line.split(SEPARATOR)[1]);
        }
        return new GridDTO(x, y);
    }

    public static RoverDTO parseAspiratorDTO(String line) {
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

    public static List<CommandEnum> parseCommand (String line) {
        List<CommandEnum> orders = new ArrayList<>();
        char[] chars = line.toCharArray();
        for (char myChar : chars) {
            orders.add(CommandEnum.valueOf(Character.toString(myChar)));
        }
        return orders;
    }
}
