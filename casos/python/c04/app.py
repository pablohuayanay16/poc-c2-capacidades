import sqlite3
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()
DB = "polizas.db"


class Filtro(BaseModel):
    nombre: str


@app.post("/polizas/buscar")
def buscar(filtro: Filtro):
    con = sqlite3.connect(DB)
    filas = con.execute(f"SELECT id, nombre FROM polizas WHERE nombre = '{filtro.nombre}'").fetchall()
    return {"resultado": filas}
