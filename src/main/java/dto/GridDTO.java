package dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GridDTO implements Serializable {
    private static final long serialVersionUID = -6076140769859928305L;
    private int height;
    private int width;

    @Override
    public String toString() {
        return " [x=" + height + ", y=" + width + "]\n";
    }
}
