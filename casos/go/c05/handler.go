package c05

import (
    "database/sql"
    "github.com/gofiber/fiber/v2"
)

func Buscar(db *sql.DB) fiber.Handler {
    return func(c *fiber.Ctx) error {
        valor := c.Query("q")
        rows, err := db.Query("SELECT id, nombre FROM polizas WHERE nombre = '" + valor + "'")
        if err != nil {
            return err
        }
        defer rows.Close()
        return c.SendStatus(fiber.StatusOK)
    }
}
