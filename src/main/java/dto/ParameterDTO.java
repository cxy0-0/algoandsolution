package dto;

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
    private RoverDTO roverDTO;
    private List<CommandEnum> command = new ArrayList<>();

    public ParameterDTO(List<String> lines) {
        if (lines.size() < 3) {
            return;
        }
        this.gridDTO = ParserLineController.parseGridDTO(lines.get(0));
        this.roverDTO = ParserLineController.parseAspiratorDTO(lines.get(1));
        this.command = ParserLineController.parseCommand(lines.get(2));
    }
}
