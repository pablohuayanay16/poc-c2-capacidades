import { pool } from '../../db.js';

export async function consultarRepo(valor) {
  const r = await pool.query('SELECT id, nombre FROM polizas ORDER BY ' + valor);
  return r.rows;
}
