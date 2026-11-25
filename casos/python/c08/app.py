from fastapi import FastAPI

from .servicio import procesar

app = FastAPI()


@app.get("/polizas")
def buscar(orden: str):
    return {"resultado": procesar(orden)}
