import express from 'express';
import { procesar } from './servicio.js';

export const router = express.Router();

router.get('/polizas', async (req, res) => {
  const valor = req.query.archivo;
  res.json(await procesar(valor));
});
