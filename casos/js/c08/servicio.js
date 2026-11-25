import { consultarRepo } from './repositorio.js';

const PERMITIDOS = new Set(['nombre', 'fecha']);

export async function procesar(valor) {
  const v = String(valor).trim();
  if (!PERMITIDOS.has(v)) {
    throw new Error('valor no permitido');
  }
  return consultarRepo(v);
}
