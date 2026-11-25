import os
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()
BASE_DIR = "/srv/documentos"


class Filtro(BaseModel):
    archivo: str


@app.post("/polizas/buscar")
def buscar(filtro: Filtro):
    with open(os.path.join(BASE_DIR, filtro.archivo), "rb") as fh:
        datos = fh.read()
    return {"resultado": len(datos)}
