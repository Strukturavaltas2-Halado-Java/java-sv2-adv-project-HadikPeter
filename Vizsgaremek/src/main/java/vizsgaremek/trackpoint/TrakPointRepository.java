package vizsgaremek.trackpoint;

import org.springframework.data.jpa.repository.JpaRepository;
import vizsgaremek.trackpoint.TrackPoint;

public interface TrakPointRepository extends JpaRepository<TrackPoint, Long> {
}
