import sqlite3

DB = "polizas.db"


def consultar_repo(valor):
    con = sqlite3.connect(DB)
    filas = con.execute(f"SELECT id, nombre FROM polizas ORDER BY {valor}").fetchall()
    return filas
