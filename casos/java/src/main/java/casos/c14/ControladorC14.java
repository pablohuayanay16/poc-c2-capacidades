package casos.c14;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC14 {
    private static final String BASE_DIR = "/srv/documentos";
    private final JdbcTemplate jdbc;

    public ControladorC14(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @PostMapping("/c14/filtros")
    public void guardar(@RequestParam String archivo) {
        jdbc.update("INSERT INTO filtros (id, valor) VALUES (1, ?)", archivo);
    }

    @GetMapping("/c14/polizas")
    public byte[] usar() throws IOException {
        String valor = jdbc.queryForObject("SELECT valor FROM filtros WHERE id = 1", String.class);
        return Files.readAllBytes(Paths.get(BASE_DIR, valor));
    }
}
