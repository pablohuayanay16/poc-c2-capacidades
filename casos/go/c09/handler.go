package c09

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
        data, err := os.ReadFile(filepath.Join(baseDir, valor))
        if err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        _ = data
        w.WriteHeader(http.StatusOK)
    }
}
