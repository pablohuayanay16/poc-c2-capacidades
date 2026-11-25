import { pool } from '../db.js';
import express from 'express';

export const router = express.Router();

async function consultar(valor) {
  const r = await pool.query("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'");
  return r.rows;
}

router.get('/polizas', async (req, res) => {
  const valor = req.query.q;
  res.json(await consultar(valor));
});
