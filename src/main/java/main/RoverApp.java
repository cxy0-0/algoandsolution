package main;

import appUtils.AppUtils;
import java.util.List;
import dto.RoverDTO;
import dto.ParameterDTO;
import imp.DirectionController;

public class RoverApp {
    public static void main(String[] args) {
        System.out.println("******* Start Testing **********\n");

        String pathName = "src/main/resources/input.txt";
        if (args.length == 1) {
            pathName = args[0];
        }

        List<String> lines = AppUtils.readFileInput(pathName);

        System.out.println("Test Input: \n");

        System.out.println("File's Content " + lines + "\n"); // [5 5, 1 2 N, LMLMLMLMM, 3 3 E, MMRMMRMRRM]
        ParameterDTO parameter = new ParameterDTO(lines);
        System.out.println("Coordinates of the plateau : " + parameter.getGridDTO()); // [x=5, y=5]
        System.out.println("The first rover's position : " + parameter.getFirstRoverDTO());//  [x=1, y=2, orientation=N]
        System.out.println("The first rover's instructions : " + parameter.getFirstRoverCommand() + "\n");// [L, M, L, M, L, M, L, M, M]
        System.out.println("The second rover's position : " + parameter.getSecondRoverDTO()); // [x=3, y=3, orientation=E]
        System.out.println("The second rover's instructions : " + parameter.getSecondRoverCommand() + "\n"); // [M, M, R, M, M, R, M, R, R, M]

        System.out.println("Output for two rovers : \n");
        RoverDTO firstRoverPosition = DirectionController.getRoverPosition(parameter.getGridDTO(), parameter.getFirstRoverDTO(),
                parameter.getFirstRoverCommand());
        System.out.println("The first rover's final position " + firstRoverPosition); // [x=1, y=3, orientation=N]

        RoverDTO secondRoverPosition = DirectionController.getRoverPosition(parameter.getGridDTO(), parameter.getSecondRoverDTO(),
                parameter.getSecondRoverCommand());
        System.out.println("The second rover's final position" + secondRoverPosition); // [x=5, y=1, orientation=E]

        System.out.println("******* End Testing ********");
    }
}
