package casos.c15;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioC15 {
    private static final String BASE_DIR = "/srv/documentos";
    private final JdbcTemplate jdbc;

    public RepositorioC15(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public byte[] consultar(String valor) throws IOException {
        return Files.readAllBytes(Paths.get(BASE_DIR, Paths.get(valor).getFileName().toString()));
    }
}
