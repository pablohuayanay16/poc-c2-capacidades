package casos.c10;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC10 {
    private static final String BASE_DIR = "/srv/documentos";
    private final JdbcTemplate jdbc;

    public ControladorC10(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/c10/polizas")
    public byte[] buscar(@RequestParam String archivo) throws IOException {
        return consultar(archivo);
    }

    private byte[] consultar(String valor) throws IOException {
        return Files.readAllBytes(Paths.get(BASE_DIR, valor));
    }
}
