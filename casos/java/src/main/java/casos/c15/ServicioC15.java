package casos.c15;

import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class ServicioC15 {
    private final RepositorioC15 repositorio;

    public ServicioC15(RepositorioC15 repositorio) {
        this.repositorio = repositorio;
    }

    public byte[] procesar(String valor) throws IOException {
        String v = valor.trim();
        return repositorio.consultar(v);
    }
}
