package casos.c11;

import java.io.IOException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC11 {
    private final ServicioC11 servicio;

    public ControladorC11(ServicioC11 servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/c11/polizas")
    public byte[] buscar(@RequestParam String archivo) throws IOException {
        return servicio.procesar(archivo);
    }
}
