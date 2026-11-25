package c01

import (
    "database/sql"
    "net/http"
)

func Buscar(db *sql.DB) http.HandlerFunc {
    return func(w http.ResponseWriter, r *http.Request) {
        valor := r.URL.Query().Get("q")
        rows, err := db.Query("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'")
        if err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        defer rows.Close()
        w.WriteHeader(http.StatusOK)
    }
}
