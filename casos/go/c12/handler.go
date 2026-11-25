package c12

import (
    "encoding/json"
    "database/sql"
    "net/http"
    "os"
    "path/filepath"
)

const baseDir = "/srv/documentos"

type Filtro struct {
    Archivo string `json:"archivo"`
}

func Buscar(db *sql.DB) http.HandlerFunc {
    return func(w http.ResponseWriter, r *http.Request) {
        var f Filtro
        if err := json.NewDecoder(r.Body).Decode(&f); err != nil {
            http.Error(w, "error", http.StatusBadRequest)
            return
        }
        data, err := os.ReadFile(filepath.Join(baseDir, f.Archivo))
        if err != nil {
            http.Error(w, "error", http.StatusInternalServerError)
            return
        }
        _ = data
        w.WriteHeader(http.StatusOK)
    }
}
