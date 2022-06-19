package vizsgaremek.coordinate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/coordinate")
@Tag(name = "Operations the coordinates")
public class CoordinateController {

    private CoordinateService service;

    public CoordinateController(CoordinateService service) {
        this.service = service;
    }

    @GetMapping
    public List<CoordinateDto> listAllCoordinate(){
        return service.listAllCoordinate();
    }

    @GetMapping("/{id}")
    public CoordinateDto findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "creates a coordinate")
    @ApiResponse(responseCode = "201", description = "coordinates has been created")
    public CoordinateDto createCoordinate(@Valid @RequestBody CoordinateCommand command){
        return service.createCoordinate(command);
    }

    @PutMapping("/lat/{id}")
    public CoordinateDto updateCoordinateLatitude(@PathVariable("id") Long id, UpdateCoordinateLatitude command){
        return service.updateCoordinateLatitude(id, command);
    }

    @PutMapping("/long/{id}")
    public CoordinateDto updateCoordinateLongitude(@PathVariable("id") Long id, UpdateCoordinateLongitude command){
        return service.updateCoordinateLongitude(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoordinate(@PathVariable("id") Long id){
        service.deleteCoordinate(id);
    }
}
