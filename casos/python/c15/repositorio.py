import os

BASE_DIR = "/srv/documentos"


def consultar_repo(valor):
    with open(os.path.join(BASE_DIR, os.path.basename(valor)), "rb") as fh:
        datos = fh.read()
    return len(datos)
