package vizsgaremek.coordinate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coordinates")
public class CoordinateController {

    private CoordinateService service;

    public CoordinateController(CoordinateService service) {
        this.service = service;
    }

    @GetMapping
    public List<CoordinateDto> listAllCoordinate(){
        return service.listAllCoordinate();
    }
}
