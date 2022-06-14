package vizsgaremek.trackpoint;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TrackPointService {

    private TrackPointRepository repository;
    private ModelMapper modelMapper;

    public List<TrackPointDto> listAllTrackpoint(Optional<Double> elevation) {
        List<TrackPoint> trackpoints = repository.findAll();
        //Type targetListType = new TypeToken<List<TrackPointDto>>() {}.getType();
        return trackpoints.stream().map(t -> modelMapper.map(t, TrackPointDto.class)).collect(Collectors.toList());
    }

    public TrackPointDto findById(Long id) {
        TrackPoint trackPoint = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Can't find trackpoint!"));
        return modelMapper.map(trackPoint, TrackPointDto.class);
    }

    public TrackPointDto createTrackpoint(TrackPointCommand command) {
        TrackPoint trackPoint = new TrackPoint(command.getName(), command.getElevation());
        repository.save(trackPoint);
        return modelMapper.map(trackPoint, TrackPointDto.class);
    }

    public TrackPointDto updateTrackPoint(Long id, UpdateTrackPointByNameCommand command) {
        TrackPoint findTrackPoint = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Can't find trackpoint!"));
        findTrackPoint.setName(command.getName());
        return modelMapper.map(findTrackPoint, TrackPointDto.class);
    }

    public void deleteTrack(Long id) {
        repository.deleteById(id);
    }
}
