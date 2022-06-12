package vizsgaremek.coordinate;

import org.springframework.data.jpa.repository.JpaRepository;
import vizsgaremek.coordinate.Coordinate;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {

}
