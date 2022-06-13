package vizsgaremek.trackpoint;


import lombok.*;

import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackPointCommand {

    @NotBlank
    private String name;


    private double elevation;
}
