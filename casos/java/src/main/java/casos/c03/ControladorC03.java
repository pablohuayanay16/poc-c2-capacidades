package casos.c03;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC03 {
    private final ServicioC03 servicio;

    public ControladorC03(ServicioC03 servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/c03/polizas")
    public List<Map<String, Object>> buscar(@RequestParam String q) {
        return servicio.procesar(q);
    }
}
