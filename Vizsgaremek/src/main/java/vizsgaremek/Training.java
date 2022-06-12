package vizsgaremek;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Column(name = "training_date")
    private LocalDate date;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "training", cascade = CascadeType.PERSIST)
    private List<TrackPoint> trackpoints = new ArrayList<>();

    public Training(String name, String description, LocalDate date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public void addTrackpoint(TrackPoint trackPoint) {
        trackpoints.add(trackPoint);
        trackPoint.setTraining(this);
    }

    public double getTrainingAllDistance() {
        double sum = 0;
        for (int i = 0; i < trackpoints.size(); i++) {
            double distance = trackpoints.get(i).getDistanceFrom(trackpoints.get(1+1));
            sum += distance;
            System.out.println(sum);
        }
        return sum;
    }
}
