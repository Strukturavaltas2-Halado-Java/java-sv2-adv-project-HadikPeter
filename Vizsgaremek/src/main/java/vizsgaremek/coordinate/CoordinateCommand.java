package vizsgaremek.coordinate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateCommand {

    @NotBlank
    private String name;

    @Min(value = 40, message = "The latitude must be greater then 40")
    @Max(value = 50, message = "The latitude must be smaller than 50")
    private double latitude;

    @Min(15)
    @Max(25)
    private double longitude;
}
