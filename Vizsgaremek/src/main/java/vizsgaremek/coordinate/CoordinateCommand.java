package vizsgaremek.coordinate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateCommand {

    @NotBlank
    private String name;
    private double latitude;
    private double longitude;
}
