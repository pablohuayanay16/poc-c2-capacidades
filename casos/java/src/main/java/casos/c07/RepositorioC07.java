package casos.c07;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioC07 {
    private final JdbcTemplate jdbc;

    public RepositorioC07(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Map<String, Object>> consultar(String valor) {
        return jdbc.queryForList("SELECT id, nombre FROM polizas WHERE nombre = ?", valor);
    }
}
