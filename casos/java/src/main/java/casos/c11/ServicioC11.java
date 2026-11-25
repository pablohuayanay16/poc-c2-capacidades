package casos.c11;

import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class ServicioC11 {
    private final RepositorioC11 repositorio;

    public ServicioC11(RepositorioC11 repositorio) {
        this.repositorio = repositorio;
    }

    public byte[] procesar(String valor) throws IOException {
        String v = valor.trim();
        return repositorio.consultar(v);
    }
}
