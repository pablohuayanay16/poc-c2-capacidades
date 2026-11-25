package casos.c08;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC08 {
    private final ServicioC08 servicio;

    public ControladorC08(ServicioC08 servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/c08/polizas")
    public List<Map<String, Object>> buscar(@RequestParam String orden) {
        return servicio.procesar(orden);
    }
}
