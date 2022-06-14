package vizsgaremek.trackpoint;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/track")
public class TrackPointController {

    private TrackPointService service;

    public TrackPointController(TrackPointService service) {
        this.service = service;
    }

    @GetMapping
    public List<TrackPointDto> listAllTrackPoint(@RequestParam Optional<Double> elevation){
        return service.listAllTrackpoint(elevation);
    }

    @GetMapping("/{id}")
    public TrackPointDto findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TrackPointDto createTrackpoint(@Valid @RequestBody TrackPointCommand command){
        return service.createTrackpoint(command);
    }

    @PutMapping("/name/{id}")
    public TrackPointDto updateTrackByName(@PathVariable("id") Long id, @Valid UpdateTrackPointByNameCommand command){
        return service.updateTrackPoint(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrackPoint(@PathVariable("id") Long id){
        service.deleteTrack(id);
    }
}
