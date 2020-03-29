package imp;

import directionEnum.CommandEnum;
import dto.RoverDTO;
import dto.GridDTO;

import java.util.List;

public class DirectionController {

    private static final int DISTANCE = 1;

    /**
     *
     * @param grid  the upper-right coordinates of the plateau
     * @param roverDTO  the rover's position
     * @param commandList a series of instructions
     * @return set Rover's position
     * N = X, Y+1
     * S = X, Y-1
     * E = X+1, Y
     * W = X-1, Y
     */
    public static RoverDTO getRoverPosition(GridDTO grid, RoverDTO roverDTO, List<CommandEnum> commandList) {

        for ( CommandEnum commandEnum : commandList) {
            switch ( commandEnum ) {
                case M -> {
                    switch ( roverDTO.getOrientation() ) {
                        case 0 -> {
                            roverDTO.setY(roverDTO.getY() + DISTANCE);
                            break;
                        }
                        case 1 -> {
                            roverDTO.setX(roverDTO.getX() + DISTANCE);
                            break;
                        }
                        case 2 -> {
                            roverDTO.setY(roverDTO.getY() - DISTANCE);
                            break;
                        }
                        case 3 -> {
                            roverDTO.setX(roverDTO.getX() - DISTANCE);
                            break;
                        }
                    }
                    checkBorderLimit(grid, roverDTO);
                    break;
                }
                case L -> {
                    roverDTO.setOrientationAndCommand(3 + roverDTO.getOrientation());
                    break;
                }
                case R -> {
                    roverDTO.setOrientationAndCommand(1 + roverDTO.getOrientation());
                    break;
                }
                default -> {
                    throw new IllegalArgumentException("Unexpected value: " + commandEnum);
                }
            }
        }
        return roverDTO;
    }

    /**
     *
     * @param grid  the upper-right coordinates of the plateau
     * @param roverDTO  the rover's position
     * To check if the direction of rover is out of the grid
     */
    public static void checkBorderLimit(GridDTO grid, RoverDTO roverDTO) {
        if ( roverDTO.getY() > grid.getHeight() || roverDTO.getX() > grid.getWidth()) {
            System.out.println("The direction of rover is out of the grid !!!!");
            System.exit(0);
        }
    }
}
