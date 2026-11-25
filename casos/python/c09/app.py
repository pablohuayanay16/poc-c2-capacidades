import os
from fastapi import FastAPI

app = FastAPI()
BASE_DIR = "/srv/documentos"


@app.get("/polizas")
def buscar(archivo: str):
    with open(os.path.join(BASE_DIR, archivo), "rb") as fh:
        datos = fh.read()
    return {"resultado": len(datos)}
