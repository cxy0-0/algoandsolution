package dto;

import directionEnum.CommandEnum;
import imp.ParserLineController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParameterDTO {
    private GridDTO gridDTO;
    private RoverDTO firstRoverDTO;
    private List<CommandEnum> firstRoverCommand = new ArrayList<>();
    private RoverDTO secondRoverDTO;
    private List<CommandEnum> secondRoverCommand = new ArrayList<>();

    public ParameterDTO(List<String> lines) {
        if (lines.size() < 3) {
            return;
        }
        this.gridDTO = ParserLineController.parseGridDTO(lines.get(0));
        this.firstRoverDTO = ParserLineController.parseRoverDTO(lines.get(1));
        this.firstRoverCommand = ParserLineController.parseCommand(lines.get(2));

        if(lines.size() == 5){
            this.secondRoverDTO = ParserLineController.parseRoverDTO(lines.get(3));
            this.secondRoverCommand = ParserLineController.parseCommand(lines.get(4));
        }
    }
}
