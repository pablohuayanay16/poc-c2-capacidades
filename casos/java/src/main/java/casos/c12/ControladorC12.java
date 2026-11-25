package casos.c12;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ControladorC12 {
    private static final String BASE_DIR = "/srv/documentos";
    private final JdbcTemplate jdbc;

    public ControladorC12(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public record Filtro(String archivo) {
    }

    @PostMapping("/c12/polizas/buscar")
    public byte[] buscar(@RequestBody Filtro filtro) throws IOException {
        return Files.readAllBytes(Paths.get(BASE_DIR, filtro.archivo()));
    }
}
