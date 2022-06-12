package vizsgaremek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void testCreated(){
        Coordinate lovoldeC = new Coordinate("lovolde1C", 47.190135, 18.421741);
        Coordinate haleszC = new Coordinate("Halesz", 47.194164, 18.431535);
        TrackPoint lovolde = new TrackPoint("lövölde Tpoint", lovoldeC, 2.3);
        TrackPoint halesz = new TrackPoint("Halesz Tpoint", haleszC, 3.3);

        Training futas = new Training("futás", "Mai hosszú futás", LocalDate.of(2022, 02, 13));
        futas.addTrackpoint(lovolde);
        futas.addTrackpoint(halesz);

        User user = new User("Péter", "peter@gmail.com", "passpass1234");
        user.addTraining(futas);
        repository.save(user);

    }
}