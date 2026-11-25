package casos.c07;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC07 {
    private final ServicioC07 servicio;

    public ControladorC07(ServicioC07 servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/c07/polizas")
    public List<Map<String, Object>> buscar(@RequestParam String q) {
        return servicio.procesar(q);
    }
}
