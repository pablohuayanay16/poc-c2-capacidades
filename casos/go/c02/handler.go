package c02

import (
    "database/sql"
    "net/http"
)

func Buscar(db *sql.DB) http.HandlerFunc {
    return func(w http.ResponseWriter, r *http.Request) {
        valor := r.URL.Query().Get("q")
        if err := consultar(db, valor); err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        w.WriteHeader(http.StatusOK)
    }
}

func consultar(db *sql.DB, valor string) error {
    rows, err := db.Query("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'")
    if err != nil {
        return err
    }
    defer rows.Close()
    return nil
}
