package vizsgaremek.trackpoint;


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
    private String name; //type is lehet NotBlank

    @PositiveOrZero
    private double elevation;

    private Coordinate coordinate;

    public TrackPointCommand(String name, double elevation) {
        this.name = name;
        this.elevation = elevation;
    }
}
