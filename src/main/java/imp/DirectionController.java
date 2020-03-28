package imp;

import dto.RoverDTO;
import dto.GridDTO;
import dto.CommandEnum;

import java.util.List;

public class DirectionController {

    private static final int DISTANCE = 1;

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

    public static void checkBorderLimit(GridDTO grid, RoverDTO roverDTO) {
        if ( roverDTO.getY() > grid.getHeight() || roverDTO.getX() > grid.getWidth()) {
            System.out.println("The direction of rover is out of the grid !!!!");
            System.exit(0);
        }
    }
}
