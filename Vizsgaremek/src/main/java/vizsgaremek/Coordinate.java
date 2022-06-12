package vizsgaremek;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coordinates")
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coordinate_name")
    private String name;
    private double latitude;
    private double longitude;

    @OneToOne(mappedBy = "coordinate")
    private TrackPoint trackPoint;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinate(String name, double latitude, double longitude) {
        this(latitude, longitude);
        this.name = name;
    }
}
