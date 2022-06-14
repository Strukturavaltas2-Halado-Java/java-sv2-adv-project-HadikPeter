package vizsgaremek.trackpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(statements = {"delete from trackpoints"})
class TrackPointControllerWebClientITTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    TrackPointService service;

    TrackPointDto trackPointDto;

    @BeforeEach
    void init() {
        service.createTrackpoint(new TrackPointCommand("Tóváros", 102.2));
        trackPointDto = service.createTrackpoint(new TrackPointCommand("Lövölde", 111.7));
    }

    @Test
    void testListAllTrackpoint() {
        webTestClient.get().uri("/api/track")
                .exchange()
                .expectBodyList(TrackPointDto.class)
                .value(t -> assertThat(t).extracting(TrackPointDto::getName).contains("Tóváros", "Lövölde"))
                .value(t -> assertThat(t).extracting(TrackPointDto::getElevation).contains(102.2, 111.7));
    }

    @Test
    void testFindById() {
        webTestClient.get().uri("/api/track/{id}", trackPointDto.getId())
                .exchange()
                .expectBody(TrackPointDto.class)
                .value(t -> assertEquals("Lövölde", trackPointDto.getName()));
    }

    @Test
    void testCreateTrackPoint() {
        webTestClient.post().uri("/api/track/create")
                .bodyValue(new TrackPointCommand("Halesz", 114.1))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(TrackPointDto.class)
                .value(TrackPointDto -> assertThat(TrackPointDto.getName()).isEqualTo("Halesz"))
                .value(TrackPointDto -> assertThat(TrackPointDto.getElevation()).isEqualTo(114.1));
    }

    @Test
    void testDeleteTrackPoint() {
        webTestClient.delete().uri("/api/track/{id}", trackPointDto.getId())
                .exchange()
                .expectStatus().isNoContent();
        webTestClient.get().uri("/api/track")
                .exchange()
                .expectBodyList(TrackPointDto.class)
                .value(t -> assertThat(t).hasSize(1).extracting(TrackPointDto::getName).containsOnly("Tóváros"));
    }
}