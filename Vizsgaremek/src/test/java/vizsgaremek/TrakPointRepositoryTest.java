package vizsgaremek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vizsgaremek.coordinate.Coordinate;
import vizsgaremek.trackpoint.TrackPoint;
import vizsgaremek.trackpoint.TrackPointRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrakPointRepositoryTest {

    @Autowired
    TrackPointRepository repository;

    TrackPoint trackPoint = new TrackPoint(new Coordinate(12.5, 34.89), 123);
    TrackPoint trackPoint2 = new TrackPoint(new Coordinate(12.6, 34.123), 200);

    @Test
    void test() {

        repository.save(trackPoint);
    }

}