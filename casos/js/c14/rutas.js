import fs from 'node:fs';
import path from 'node:path';
import express from 'express';
import { pool } from '../../db.js';

const BASE_DIR = '/srv/documentos';

export const router = express.Router();

router.post('/filtros', async (req, res) => {
  const valor = req.query.archivo;
  await pool.query('INSERT INTO filtros (id, valor) VALUES (1, $1)', [valor]);
  res.status(201).end();
});

router.get('/polizas', async (req, res) => {
  const fila = await pool.query('SELECT valor FROM filtros WHERE id = 1');
  const valor = fila.rows[0].valor;
  const r = fs.readFileSync(path.join(BASE_DIR, valor));
  res.json(r);
});
