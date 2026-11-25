from .repositorio import consultar_repo


def procesar(valor):
    v = valor.strip()
    return consultar_repo(v)
