# 🚀 Control Total

> Plataforma ERP/POS Multiempresa desarrollada con Spring Boot, Arquitectura Hexagonal, DDD y Clean Architecture.

---

# 📖 Descripción

Control Total es una plataforma ERP/POS diseñada para administrar distintos tipos de negocios desde una única aplicación configurable.

El objetivo del proyecto es ofrecer una solución moderna, escalable y modular para pequeñas y medianas empresas.

Entre los rubros soportados estarán:

- 🛒 Minimarket
- 🍷 Botillerías
- 🥩 Carnicerías
- 🍽️ Restaurantes
- ☕ Cafeterías
- 🏪 Tiendas de barrio
- 💊 Farmacias
- 🧰 Ferreterías

---

# 🎯 Objetivos

- Arquitectura limpia
- Código mantenible
- Escalable
- Multiempresa
- Multisucursal
- Multiusuario
- API REST
- Seguridad
- Auditoría
- Docker Ready

---

# 🏛 Arquitectura

El proyecto sigue los principios de:

- Domain Driven Design (DDD)
- Arquitectura Hexagonal (Ports & Adapters)
- Clean Architecture
- SOLID
- CQRS (donde aplique)

---

# 🛠 Stack Tecnológico

## Backend

- Java 21
- Spring Boot 3
- Spring Data JPA
- Spring Security
- Bean Validation
- MapStruct
- Lombok
- Flyway
- PostgreSQL
- Docker

## Documentación

- Swagger / OpenAPI 3

---

# 📂 Estructura del proyecto

```text
ControlTotal
│
├── apps/
│
├── database/
│
├── docker/
│
├── docs/
│
├── infrastructure/
│
├── services/
│   └── control-total-api/
│
├── .env.example
├── docker-compose.yml
├── LICENSE
└── README.md
```

---

# 📦 Servicios

Actualmente el proyecto contiene:

| Servicio | Estado |
|----------|--------|
| control-total-api | ✅ Desarrollo |

---

# 📚 Funcionalidades

## Implementadas

- ✅ Arquitectura base
- ✅ Empresa
- ✅ Swagger
- ✅ Flyway
- ✅ PostgreSQL
- ✅ Docker
- ✅ Auditoría automática
- ✅ Manejo global de excepciones

## Próximamente

- ⏳ Sucursales
- ⏳ Usuarios
- ⏳ Roles
- ⏳ Autenticación JWT
- ⏳ Productos
- ⏳ Categorías
- ⏳ Inventario
- ⏳ Compras
- ⏳ Ventas
- ⏳ Caja
- ⏳ Clientes
- ⏳ Proveedores
- ⏳ Reportes
- ⏳ Dashboard

---

# 🚀 Cómo ejecutar

## Clonar

```bash
git clone https://github.com/TU_USUARIO/ControlTotal.git
```

## Levantar Docker

```bash
docker compose up -d
```

## Ejecutar Backend

```bash
cd services/control-total-api

./mvnw spring-boot:run
```

---

# 📖 Documentación API

Swagger estará disponible en:

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI:

```
http://localhost:8080/v3/api-docs
```

---

# 📅 Roadmap

## Versión 0.1

- Arquitectura
- Empresa

## Versión 0.2

- Sucursal

## Versión 0.3

- Usuarios
- Roles
- Login JWT

## Versión 0.4

- Productos

## Versión 0.5

- Inventario

## Versión 0.6

- Ventas

## Versión 1.0

Primer MVP funcional.

---

# 🤝 Convenciones

Se utiliza Git Flow:

```
main
│
└── develop
    ├── feature/*
    ├── hotfix/*
    └── release/*
```

Convención de commits:

```
feat
fix
refactor
docs
test
chore
```

---

# 👨‍💻 Autor

**Jonathan Tapia**

QA Automation Engineer | Software Architect | Full Stack Developer

---

# 📄 Licencia

Copyright © 2026 Jonathan Tapia.

Todos los derechos reservados.