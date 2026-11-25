import { consultarRepo } from './repositorio.js';

export async function procesar(valor) {
  const v = String(valor).trim();
  return consultarRepo(v);
}
