package vizsgaremek.trackpoint;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTrackPointByNameCommand {

    @NotBlank
    @Schema(example = "Berényi út 1.C")
    private String name;
}
