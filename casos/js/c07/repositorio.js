import { pool } from '../../db.js';

export async function consultarRepo(valor) {
  const r = await pool.query('SELECT id, nombre FROM polizas WHERE nombre = $1', [valor]);
  return r.rows;
}
