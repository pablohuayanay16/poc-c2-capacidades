import os
from fastapi import FastAPI

app = FastAPI()
BASE_DIR = "/srv/documentos"


def consultar(valor):
    with open(os.path.join(BASE_DIR, valor), "rb") as fh:
        datos = fh.read()
    return len(datos)


@app.get("/polizas")
def buscar(archivo: str):
    return {"resultado": consultar(archivo)}
