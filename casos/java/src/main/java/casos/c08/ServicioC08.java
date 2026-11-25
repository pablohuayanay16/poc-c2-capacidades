package casos.c08;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class ServicioC08 {
    private static final Set<String> PERMITIDOS = Set.of("nombre", "fecha");
    private final RepositorioC08 repositorio;

    public ServicioC08(RepositorioC08 repositorio) {
        this.repositorio = repositorio;
    }

    public List<Map<String, Object>> procesar(String valor) {
        String v = valor.trim();
        if (!PERMITIDOS.contains(v)) {
            throw new IllegalArgumentException("valor no permitido");
        }
        return repositorio.consultar(v);
    }
}
