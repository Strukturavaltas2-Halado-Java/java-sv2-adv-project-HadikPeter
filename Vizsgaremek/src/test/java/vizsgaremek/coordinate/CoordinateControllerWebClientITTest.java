package vizsgaremek.coordinate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(statements = "delete from coordinates")
class CoordinateControllerWebClientITTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    CoordinateService service;

    CoordinateDto coordinateDto;

    @BeforeEach
    void init(){
        service.createCoordinate(new CoordinateCommand("tovarosC", 47.182193, 18.410582));
        coordinateDto = service.createCoordinate(new CoordinateCommand("lovolde1C", 47.190135, 18.421741));
    }

    @Test
    void testListAllCoordinate() {
        webTestClient.get().uri("/api/coordinates")
                .exchange()
                .expectBodyList(CoordinateDto.class)
                .value(c -> assertThat(c).extracting(CoordinateDto::getName).contains("tovarosC", "lovolde1C"));
    }

    @Test
    void testFindById(){
        webTestClient.get().uri("/api/coordinates/{id}", coordinateDto.getId())
                .exchange()
                .expectBody(CoordinateDto.class)
                .value(c -> assertEquals("lovolde1C", coordinateDto.getName()))
                .value(c -> assertEquals(47.190135, coordinateDto.getLatitude()))
                .value(c -> assertEquals(18.421741, coordinateDto.getLongitude()));
    }

    @Test
    void testCreateCoordinate(){
        webTestClient.post().uri("/api/coordinates/create")
                .bodyValue(new CoordinateCommand("haleszC", 47.194164, 18.431535))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(CoordinateDto.class)
                .value(CoordinateDto -> assertThat(CoordinateDto.getName()).isEqualTo("haleszC"))
                .value(CoordinateDto -> assertThat(CoordinateDto.getLatitude()).isEqualTo(47.194164))
                .value(CoordinateDto -> assertThat(CoordinateDto.getLongitude()).isEqualTo(18.431535));
    }

    @Test
    void testDeleteCoordinate(){
        webTestClient.delete().uri("/api/coordinates/{id}", coordinateDto.getId())
                .exchange().expectStatus().isNoContent();
        webTestClient.get().uri("/api/coordinates")
                .exchange()
                .expectBodyList(CoordinateDto.class)
                .value(c -> assertThat(c).hasSize(1).extracting(CoordinateDto::getName).containsOnly("tovarosC"));
    }

}