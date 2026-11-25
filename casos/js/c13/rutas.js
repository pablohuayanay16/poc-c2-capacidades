import fs from 'node:fs';
import path from 'node:path';

const BASE_DIR = '/srv/documentos';

export const ruta = {
  method: 'GET',
  path: '/polizas',
  handler: async (request, h) => {
    const valor = request.query.archivo;
    const r = fs.readFileSync(path.join(BASE_DIR, valor));
    return h.response(r);
  }
};
