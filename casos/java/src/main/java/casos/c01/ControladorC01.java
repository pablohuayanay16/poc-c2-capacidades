package casos.c01;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorC01 {
    private final JdbcTemplate jdbc;

    public ControladorC01(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/c01/polizas")
    public List<Map<String, Object>> buscar(@RequestParam String q) {
        return jdbc.queryForList("SELECT id, nombre FROM polizas WHERE nombre = '" + q + "'");
    }
}
