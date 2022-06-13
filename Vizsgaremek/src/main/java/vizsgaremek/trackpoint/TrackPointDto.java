package vizsgaremek.trackpoint;

import lombok.*;
import vizsgaremek.coordinate.Coordinate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackPointDto {

    private Long id;
    private String name;
    private double elevation;
    //private Coordinate coordinate;
}
