import os
from starlette.applications import Starlette
from starlette.responses import JSONResponse
from starlette.routing import Route

BASE_DIR = "/srv/documentos"


async def buscar(request):
    valor = request.query_params["archivo"]
    with open(os.path.join(BASE_DIR, valor), "rb") as fh:
        datos = fh.read()
    return JSONResponse({"resultado": len(datos)})


app = Starlette(routes=[Route("/polizas", buscar)])
