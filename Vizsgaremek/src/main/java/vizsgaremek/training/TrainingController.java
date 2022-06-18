package vizsgaremek.training;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vizsgaremek.trackpoint.TrackPointCommand;
import vizsgaremek.trackpoint.TrackPointDto;
import vizsgaremek.trackpoint.UpdateTrackPointByNameCommand;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/training")
public class TrainingController {

    private TrainingService service;

    public TrainingController(TrainingService service) {
        this.service = service;
    }

    @GetMapping
    public List<TrainingDto> listAllTrackPoint(@RequestParam Optional<LocalDate> date){
        return service.listAllTraining(date);
    }

    @GetMapping("/{id}")
    public TrainingDto findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping("/sum/{id}")
    public double getSumKm(@PathVariable("id") Long id){
        return service.getSumKm(id);
    }

    @GetMapping("/elevation/{id}")
    public double getSumElevation(@PathVariable("id") Long id){
        return service.getSumElevation(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingDto createTraining(@Valid @RequestBody TrainingCommand command){
        return service.createTraining(command);
    }

    @PutMapping("/name/{id}")
    public TrainingDto updateTrainingByName(@PathVariable("id") Long id, @Valid UpdateTrainingName command){
        return service.updateTrainingByName(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTraining(@PathVariable("id") Long id){
        service.deleteTraining(id);
    }
}
