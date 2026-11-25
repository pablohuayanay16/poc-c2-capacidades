package casos.c11;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioC11 {
    private static final String BASE_DIR = "/srv/documentos";
    private final JdbcTemplate jdbc;

    public RepositorioC11(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public byte[] consultar(String valor) throws IOException {
        return Files.readAllBytes(Paths.get(BASE_DIR, valor));
    }
}
