package casos.c06;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC06 {
    private final JdbcTemplate jdbc;

    public ControladorC06(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @PostMapping("/c06/filtros")
    public void guardar(@RequestParam String q) {
        jdbc.update("INSERT INTO filtros (id, valor) VALUES (1, ?)", q);
    }

    @GetMapping("/c06/polizas")
    public List<Map<String, Object>> usar() {
        String valor = jdbc.queryForObject("SELECT valor FROM filtros WHERE id = 1", String.class);
        return jdbc.queryForList("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'");
    }
}
