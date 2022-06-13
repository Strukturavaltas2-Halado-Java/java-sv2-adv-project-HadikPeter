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

    public List<TrackPointDto> listAllTrackpoint() {
        List<TrackPoint> trackpoints = repository.findAll();
        //Type targetListType = new TypeToken<List<TrackPointDto>>() {}.getType();
        return trackpoints.stream().map(t -> modelMapper.map(t, TrackPointDto.class)).collect(Collectors.toList());
    }
}
