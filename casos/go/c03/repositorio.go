package c03

import (
    "database/sql"
)

func consultarRepo(db *sql.DB, valor string) error {
    rows, err := db.Query("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'")
    if err != nil {
        return err
    }
    defer rows.Close()
    return nil
}
