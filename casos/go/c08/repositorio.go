package c08

import (
    "database/sql"
)

func consultarRepo(db *sql.DB, valor string) error {
    rows, err := db.Query("SELECT id, nombre FROM polizas ORDER BY " + valor)
    if err != nil {
        return err
    }
    defer rows.Close()
    return nil
}
