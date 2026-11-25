from fastapi import FastAPI

from .servicio import procesar

app = FastAPI()


@app.get("/polizas")
def buscar(archivo: str):
    return {"resultado": procesar(archivo)}
