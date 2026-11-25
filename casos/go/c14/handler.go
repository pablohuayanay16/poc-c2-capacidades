package c14

import (
    "database/sql"
    "net/http"
    "os"
    "path/filepath"
)

const baseDir = "/srv/documentos"

func Guardar(db *sql.DB) http.HandlerFunc {
    return func(w http.ResponseWriter, r *http.Request) {
        valor := r.URL.Query().Get("archivo")
        if _, err := db.Exec("INSERT INTO filtros (id, valor) VALUES (1, $1)", valor); err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        w.WriteHeader(http.StatusCreated)
    }
}

func Usar(db *sql.DB) http.HandlerFunc {
    return func(w http.ResponseWriter, r *http.Request) {
        var valor string
        if err := db.QueryRow("SELECT valor FROM filtros WHERE id = 1").Scan(&valor); err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        data, err := os.ReadFile(filepath.Join(baseDir, valor))
        if err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        _ = data
        w.WriteHeader(http.StatusOK)
    }
}
