package casos.c07;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ServicioC07 {
    private final RepositorioC07 repositorio;

    public ServicioC07(RepositorioC07 repositorio) {
        this.repositorio = repositorio;
    }

    public List<Map<String, Object>> procesar(String valor) {
        String v = valor.trim();
        return repositorio.consultar(v);
    }
}
