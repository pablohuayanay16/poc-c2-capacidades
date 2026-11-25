package casos.c03;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ServicioC03 {
    private final RepositorioC03 repositorio;

    public ServicioC03(RepositorioC03 repositorio) {
        this.repositorio = repositorio;
    }

    public List<Map<String, Object>> procesar(String valor) {
        String v = valor.trim();
        return repositorio.consultar(v);
    }
}
