import { pool } from '../../db.js';
import express from 'express';

export const router = express.Router();

router.post('/filtros', async (req, res) => {
  const valor = req.query.q;
  await pool.query('INSERT INTO filtros (id, valor) VALUES (1, $1)', [valor]);
  res.status(201).end();
});

router.get('/polizas', async (req, res) => {
  const fila = await pool.query('SELECT valor FROM filtros WHERE id = 1');
  const valor = fila.rows[0].valor;
  const r = await pool.query("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'");
  res.json(r.rows);
});
