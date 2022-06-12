package vizsgaremek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vizsgaremek.coordinate.Coordinate;
import vizsgaremek.coordinate.CoordinateRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoordinateRepositoryTest {

    @Autowired
    CoordinateRepository repository;

    @Test
    void testCreateAndFind() {
        Coordinate coordinate = new Coordinate("lovolde1C", 47.190135, 18.421741);
        repository.save(coordinate);
        Coordinate savedCoordinate = repository.findById(coordinate.getId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find coordinate!"));
        assertAll(
                () -> assertEquals("lovolde1C", savedCoordinate.getName()),
                () -> assertEquals(47.190135, savedCoordinate.getLatitude()),
                () -> assertEquals(18.421741, savedCoordinate.getLongitude())
        );
    }
}