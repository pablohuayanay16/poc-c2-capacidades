package casos.c16;

import java.io.IOException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC16 {
    private final ServicioC16 servicio;

    public ControladorC16(ServicioC16 servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/c16/polizas")
    public byte[] buscar(@RequestParam String archivo) throws IOException {
        return servicio.procesar(archivo);
    }
}
