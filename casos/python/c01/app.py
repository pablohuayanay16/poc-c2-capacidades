import sqlite3
from fastapi import FastAPI

app = FastAPI()
DB = "polizas.db"


@app.get("/polizas")
def buscar(q: str):
    con = sqlite3.connect(DB)
    filas = con.execute(f"SELECT id, nombre FROM polizas WHERE nombre = '{q}'").fetchall()
    return {"resultado": filas}
