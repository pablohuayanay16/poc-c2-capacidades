import { pool } from '../db.js';

export async function consultarRepo(valor) {
  const r = await pool.query("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'");
  return r.rows;
}
