package casos.c16;

import java.util.Set;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class ServicioC16 {
    private static final Set<String> PERMITIDOS = Set.of("condiciones.pdf", "tarifario.pdf");
    private final RepositorioC16 repositorio;

    public ServicioC16(RepositorioC16 repositorio) {
        this.repositorio = repositorio;
    }

    public byte[] procesar(String valor) throws IOException {
        String v = valor.trim();
        if (!PERMITIDOS.contains(v)) {
            throw new IllegalArgumentException("valor no permitido");
        }
        return repositorio.consultar(v);
    }
}
