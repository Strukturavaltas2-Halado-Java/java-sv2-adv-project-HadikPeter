package vizsgaremek.training;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCommand {

    @Schema(description = "name of the training", example = "futás")
    private String name;
    @Schema(description = "description of the training", example = "Kora reggeli futás")
    private String description;

    @Schema(example = "2022-05-11")
    private LocalDate date;
}
