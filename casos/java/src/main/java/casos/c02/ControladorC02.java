package casos.c02;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC02 {
    private final JdbcTemplate jdbc;

    public ControladorC02(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/c02/polizas")
    public List<Map<String, Object>> buscar(@RequestParam String q) {
        return consultar(q);
    }

    private List<Map<String, Object>> consultar(String valor) {
        return jdbc.queryForList("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'");
    }
}
