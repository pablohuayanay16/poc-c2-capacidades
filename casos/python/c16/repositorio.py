import os

BASE_DIR = "/srv/documentos"


def consultar_repo(valor):
    with open(os.path.join(BASE_DIR, valor), "rb") as fh:
        datos = fh.read()
    return len(datos)
