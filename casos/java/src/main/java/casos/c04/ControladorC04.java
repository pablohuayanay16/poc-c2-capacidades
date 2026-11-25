package casos.c04;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ControladorC04 {
    private final JdbcTemplate jdbc;

    public ControladorC04(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public record Filtro(String nombre) {
    }

    @PostMapping("/c04/polizas/buscar")
    public List<Map<String, Object>> buscar(@RequestBody Filtro filtro) {
        return jdbc.queryForList("SELECT id, nombre FROM polizas WHERE nombre = '" + filtro.nombre() + "'");
    }
}
