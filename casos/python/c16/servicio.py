from .repositorio import consultar_repo

PERMITIDOS = {"condiciones.pdf", "tarifario.pdf"}


def procesar(valor):
    v = valor.strip()
    if v not in PERMITIDOS:
        raise ValueError("valor no permitido")
    return consultar_repo(v)
