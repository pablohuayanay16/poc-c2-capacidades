import { pool } from '../../db.js';
import express from 'express';

export const router = express.Router();

router.post('/polizas/buscar', express.json(), async (req, res) => {
  const filtro = req.body;
  const r = await pool.query("SELECT id, nombre FROM polizas WHERE nombre = '" + filtro.nombre + "'");
  res.json(r.rows);
});
