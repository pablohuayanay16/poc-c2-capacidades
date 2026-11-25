package c16

import (
    "database/sql"
    "net/http"
)

func Buscar(db *sql.DB) http.HandlerFunc {
    return func(w http.ResponseWriter, r *http.Request) {
        valor := r.URL.Query().Get("archivo")
        if err := procesar(db, valor); err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        w.WriteHeader(http.StatusOK)
    }
}
