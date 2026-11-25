package c04

import (
    "encoding/json"
    "database/sql"
    "net/http"
)

type Filtro struct {
    Nombre string `json:"nombre"`
}

func Buscar(db *sql.DB) http.HandlerFunc {
    return func(w http.ResponseWriter, r *http.Request) {
        var f Filtro
        if err := json.NewDecoder(r.Body).Decode(&f); err != nil {
            http.Error(w, "error", http.StatusBadRequest)
            return
        }
        rows, err := db.Query("SELECT id, nombre FROM polizas WHERE nombre = '" + f.Nombre + "'")
        if err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        defer rows.Close()
        w.WriteHeader(http.StatusOK)
    }
}
