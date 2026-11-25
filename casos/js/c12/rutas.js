import fs from 'node:fs';
import path from 'node:path';
import express from 'express';

const BASE_DIR = '/srv/documentos';

export const router = express.Router();

router.post('/polizas/buscar', express.json(), async (req, res) => {
  const filtro = req.body;
  const r = fs.readFileSync(path.join(BASE_DIR, filtro.archivo));
  res.json(r);
});
