package vizsgaremek.coordinate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateDto {

    private String name;
    private double latitude;
    private double longitude;
}
