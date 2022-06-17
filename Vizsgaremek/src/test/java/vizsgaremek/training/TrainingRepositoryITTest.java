package vizsgaremek.training;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vizsgaremek.coordinate.Coordinate;
import vizsgaremek.trackpoint.TrackPoint;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrainingRepositoryITTest {

    @Autowired
    TrainingRepository repository;

    @Test
    void testJpaCreateTable(){ //Flyway működése esetén ne futtasd le!
        /*Coordinate tovarosC = new Coordinate("tovarosC", 47.182193, 18.410582);
        Coordinate lovoldeC = new Coordinate("lovoldeC", 47.190135, 18.421741);
        Coordinate halesC = new Coordinate("haleszC", 47.19416411, 18.43153511);
        Coordinate nagyszombati = new Coordinate("nagyszombatiC", 47.197875, 18.481305);

        TrackPoint trackPointTovaros = new TrackPoint("Tóvárosi Lakónegyed", tovarosC, 2.1);
        TrackPoint trackPointLovolde = new TrackPoint("Lövöpde út", lovoldeC, 2.3);
        TrackPoint trackPointHales = new TrackPoint("Halesz", halesC, 3.3);
        TrackPoint trackPointNagyszombati = new TrackPoint("Nagyszombati út", nagyszombati, 3.3);

        Training futas = new Training("futás", "Péter hosszú futása", LocalDate.of(2022, 05, 29));
        futas.addTrackpoint(trackPointTovaros);
        futas.addTrackpoint(trackPointLovolde);
        futas.addTrackpoint(trackPointHales);

        Training bicigli = new Training("biciglizés", "Péter rövid bicajozása", LocalDate.of(2022, 05, 30));
        bicigli.addTrackpoint(trackPointTovaros);
        bicigli.addTrackpoint(trackPointHales);
        repository.save(futas);*/
        //repository.save(bicigli);
    }
}