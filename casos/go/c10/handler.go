package c10

import (
    "database/sql"
    "net/http"
    "os"
    "path/filepath"
)

const baseDir = "/srv/documentos"

func Buscar(db *sql.DB) http.HandlerFunc {
    return func(w http.ResponseWriter, r *http.Request) {
        valor := r.URL.Query().Get("archivo")
        if err := consultar(db, valor); err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        w.WriteHeader(http.StatusOK)
    }
}

func consultar(db *sql.DB, valor string) error {
    data, err := os.ReadFile(filepath.Join(baseDir, valor))
    if err != nil {
        return err
    }
    _ = data
    return nil
}
