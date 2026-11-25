package c06

import (
    "database/sql"
    "net/http"
)

func Guardar(db *sql.DB) http.HandlerFunc {
    return func(w http.ResponseWriter, r *http.Request) {
        valor := r.URL.Query().Get("q")
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
        rows, err := db.Query("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'")
        if err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        defer rows.Close()
        w.WriteHeader(http.StatusOK)
    }
}
