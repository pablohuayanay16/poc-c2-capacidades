import fs from 'node:fs';
import path from 'node:path';

const BASE_DIR = '/srv/documentos';

export async function consultarRepo(valor) {
  const r = fs.readFileSync(path.join(BASE_DIR, valor));
  return r;
}
