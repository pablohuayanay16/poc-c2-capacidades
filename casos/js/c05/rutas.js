import { pool } from '../../db.js';

export const ruta = {
  method: 'GET',
  path: '/polizas',
  handler: async (request, h) => {
    const valor = request.query.q;
    const r = await pool.query("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'");
    return h.response(r.rows);
  }
};
