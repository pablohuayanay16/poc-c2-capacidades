import { pool } from '../../db.js';
import express from 'express';

export const router = express.Router();

router.get('/polizas', async (req, res) => {
  const valor = req.query.q;
  const r = await pool.query("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'");
  res.json(r.rows);
});
