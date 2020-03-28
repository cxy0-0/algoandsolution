package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoverDTO implements Serializable {
    private static final long serialVersionUID = -6076140769859928305L;
    private int x;
    private int y;
    private OrientationEnum orient;
    private int orientation;

    public RoverDTO(int x, int y, OrientationEnum orient) {
        this.x = x;
        this.y = y;
        this.orient = orient;
        switch ( orient ) {
            case N -> {
                this.orientation = 0;
                break;
            }
            case E -> {
                this.orientation = 1;
                break;
            }
            case S -> {
                this.orientation = 2;
                break;
            }
            case W -> {
                this.orientation = 3;
                break;
            }
        }

    }

    public void setOrientationAndCommand(int direction) {
        this.orientation = direction % 4;
        switch (this.orientation ) {
            case 0 -> {
                this.orient = OrientationEnum.N;
                break;
            }
            case 1 -> {
                this.orient = OrientationEnum.E;
                break;
            }
            case 2 -> {
                this.orient = OrientationEnum.S;
                break;
            }
            case 3 -> {
                this.orient = OrientationEnum.W;
                break;
            }
        }

    }

    @Override
    public String toString() {
        return " [x=" + x + ", y=" + y + ", orientation=" + orient + "]\n";
    }
}
