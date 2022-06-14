package vizsgaremek.coordinate;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    public CoordinateDto findById(Long id) {
        Coordinate coordinate = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Can't find coordinate!"));
        return modelMapper.map(coordinate, CoordinateDto.class);
    }

    public CoordinateDto createCoordinate(CoordinateCommand command) {
        Coordinate coordinate = new Coordinate(command.getName(), command.getLatitude(), command.getLongitude());
        repository.save(coordinate);
        return modelMapper.map(coordinate, CoordinateDto.class);
    }

    public CoordinateDto updateCoordinateLatitude(Long id, UpdateCoordinateLatitude command) {
        Coordinate findCoordinate = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Can't find coordinate!"));
        //findCoordinate.setName(command.getName());
        return modelMapper.map(findCoordinate, CoordinateDto.class);
    }

    public CoordinateDto updateCoordinateLongitude(Long id, UpdateCoordinateLongitude command) {
        Coordinate findCoordinate = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Can't find coordinate!"));
        //findCoordinate.setName(command.getName());
        return modelMapper.map(findCoordinate, CoordinateDto.class);
    }

    public void deleteCoordinate(Long id) {
        repository.deleteById(id);
    }
}
