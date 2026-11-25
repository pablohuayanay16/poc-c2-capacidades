import sqlite3
from fastapi import FastAPI

app = FastAPI()
DB = "polizas.db"


def consultar(valor):
    con = sqlite3.connect(DB)
    filas = con.execute(f"SELECT id, nombre FROM polizas WHERE nombre = '{valor}'").fetchall()
    return filas


@app.get("/polizas")
def buscar(q: str):
    return {"resultado": consultar(q)}
