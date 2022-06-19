package vizsgaremek.trackpoint;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import vizsgaremek.coordinate.Coordinate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackPointCommand {

    @NotBlank
    @Schema(description = "name of the trackpoint", example = "Berényi út eleje")
    private String name;

    @PositiveOrZero
    @Schema(description = "value of elevation", example = "111.3")
    private double elevation;

    @Schema(hidden = true)
    private Coordinate coordinate;

    public TrackPointCommand(String name, double elevation) {
        this.name = name;
        this.elevation = elevation;
    }
}
