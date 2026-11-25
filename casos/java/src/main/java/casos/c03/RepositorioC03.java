package casos.c03;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioC03 {
    private final JdbcTemplate jdbc;

    public RepositorioC03(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Map<String, Object>> consultar(String valor) {
        return jdbc.queryForList("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'");
    }
}
