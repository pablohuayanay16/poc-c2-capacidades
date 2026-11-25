package casos.c15;

import java.io.IOException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC15 {
    private final ServicioC15 servicio;

    public ControladorC15(ServicioC15 servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/c15/polizas")
    public byte[] buscar(@RequestParam String archivo) throws IOException {
        return servicio.procesar(archivo);
    }
}
