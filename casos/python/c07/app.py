from fastapi import FastAPI

from .servicio import procesar

app = FastAPI()


@app.get("/polizas")
def buscar(q: str):
    return {"resultado": procesar(q)}
