import sqlite3

DB = "polizas.db"


def consultar_repo(valor):
    con = sqlite3.connect(DB)
    filas = con.execute(f"SELECT id, nombre FROM polizas WHERE nombre = '{valor}'").fetchall()
    return filas
