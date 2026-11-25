package c08

import (
    "errors"
    "database/sql"
    "strings"
)

var permitidos = map[string]bool{"nombre": true, "fecha": true}

func procesar(db *sql.DB, valor string) error {
    v := strings.TrimSpace(valor)
    if !permitidos[v] {
        return errors.New("valor no permitido")
    }
    return consultarRepo(db, v)
}
