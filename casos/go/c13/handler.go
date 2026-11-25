package c13

import (
    "database/sql"
    "os"
    "path/filepath"
    "github.com/gofiber/fiber/v2"
)

const baseDir = "/srv/documentos"

func Buscar(db *sql.DB) fiber.Handler {
    return func(c *fiber.Ctx) error {
        valor := c.Query("archivo")
        data, err := os.ReadFile(filepath.Join(baseDir, valor))
        if err != nil {
            return err
        }
        _ = data
        return c.SendStatus(fiber.StatusOK)
    }
}
