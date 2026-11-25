package c15

import (
    "database/sql"
    "strings"
)

func procesar(db *sql.DB, valor string) error {
    v := strings.TrimSpace(valor)
    return consultarRepo(db, v)
}
