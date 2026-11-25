import sqlite3
from starlette.applications import Starlette
from starlette.responses import JSONResponse
from starlette.routing import Route

DB = "polizas.db"


async def buscar(request):
    valor = request.query_params["q"]
    con = sqlite3.connect(DB)
    filas = con.execute(f"SELECT id, nombre FROM polizas WHERE nombre = '{valor}'").fetchall()
    return JSONResponse({"resultado": filas})


app = Starlette(routes=[Route("/polizas", buscar)])
