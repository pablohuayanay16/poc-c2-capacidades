import sqlite3
from fastapi import FastAPI

app = FastAPI()
DB = "polizas.db"


@app.post("/filtros")
def guardar(q: str):
    con = sqlite3.connect(DB)
    con.execute("INSERT INTO filtros (id, valor) VALUES (1, ?)", (q,))
    con.commit()
    return {"ok": True}


@app.get("/polizas")
def usar():
    con = sqlite3.connect(DB)
    valor = con.execute("SELECT valor FROM filtros WHERE id = 1").fetchone()[0]
    filas = con.execute(f"SELECT id, nombre FROM polizas WHERE nombre = '{valor}'").fetchall()
    return {"resultado": filas}
