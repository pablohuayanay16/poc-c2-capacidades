package c11

import (
    "database/sql"
    "os"
    "path/filepath"
)

const baseDir = "/srv/documentos"

func consultarRepo(db *sql.DB, valor string) error {
    data, err := os.ReadFile(filepath.Join(baseDir, valor))
    if err != nil {
        return err
    }
    _ = data
    return nil
}
