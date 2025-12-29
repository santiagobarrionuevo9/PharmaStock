# PharmaStock 🏥
**Backend de gestión de stock farmacéutico (lotes, vencimientos y ubicaciones)**

PharmaStock es un backend desarrollado en **Java + Spring Boot** para gestionar stock farmacéutico con **trazabilidad por movimientos (kardex)**. Está pensado para **uso real** y como **proyecto de portfolio**.

---

## 🚀 Features
- ABM de **Productos**
- Control de stock por **Lote** y **Vencimiento**
- **Depósitos** (Warehouses) y **Ubicaciones** (Locations)
- Ubicación **opcional (NULL permitido)** para stock “pendiente de ubicar”
- Movimientos de stock: **IN / OUT / ADJUSTMENT / RELOCATION / TRANSFERS**
- Auditoría: usuario, fecha y motivo
- Roles: **ADMIN / OPERATOR / VIEWER**
- Documentación automática con **Swagger / OpenAPI**

---

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 (DEV)
- PostgreSQL (PROD - Neon)
- Flyway (migraciones en PROD)
- Swagger (springdoc-openapi)

---

## ▶️ Run (DEV - H2)

```bash
mvn spring-boot:run
