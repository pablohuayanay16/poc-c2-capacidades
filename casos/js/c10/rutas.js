import fs from 'node:fs';
import path from 'node:path';
import express from 'express';

const BASE_DIR = '/srv/documentos';

export const router = express.Router();

async function consultar(valor) {
  const r = fs.readFileSync(path.join(BASE_DIR, valor));
  return r;
}

router.get('/polizas', async (req, res) => {
  const valor = req.query.archivo;
  res.json(await consultar(valor));
});
