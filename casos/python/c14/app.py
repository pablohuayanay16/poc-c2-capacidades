import os
import sqlite3
from fastapi import FastAPI

app = FastAPI()
BASE_DIR = "/srv/documentos"
DB = "polizas.db"


@app.post("/filtros")
def guardar(archivo: str):
    con = sqlite3.connect(DB)
    con.execute("INSERT INTO filtros (id, valor) VALUES (1, ?)", (archivo,))
    con.commit()
    return {"ok": True}


@app.get("/polizas")
def usar():
    con = sqlite3.connect(DB)
    valor = con.execute("SELECT valor FROM filtros WHERE id = 1").fetchone()[0]
    with open(os.path.join(BASE_DIR, valor), "rb") as fh:
        datos = fh.read()
    return {"resultado": len(datos)}
