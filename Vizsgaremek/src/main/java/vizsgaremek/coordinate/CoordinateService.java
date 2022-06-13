package vizsgaremek.coordinate;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vizsgaremek.trackpoint.TrackPointDto;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CoordinateService {

    private CoordinateRepository repository;

    private ModelMapper modelMapper;

    public List<CoordinateDto> listAllCoordinate() {
        List<Coordinate> coordinates = repository.findAll();
        return coordinates.stream().map(t -> modelMapper.map(t, CoordinateDto.class)).collect(Collectors.toList());
    }
}
