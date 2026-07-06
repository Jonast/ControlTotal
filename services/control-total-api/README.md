# 🚀 Control Total API

> Backend del sistema **Control Total**, una plataforma ERP/POS multiempresa desarrollada con **Spring Boot**, siguiendo principios de **DDD (Domain Driven Design)**, **Arquitectura Hexagonal** y **Clean Architecture**.

---

## 📖 Descripción

Control Total es una plataforma diseñada para administrar distintos tipos de negocios desde un único sistema.

El objetivo es proporcionar una solución escalable, mantenible y modular para la gestión de:

- 🏢 Empresas
- 🏬 Sucursales
- 👥 Usuarios
- 🔐 Roles y permisos
- 📦 Productos
- 🏷 Categorías
- 📊 Inventario
- 🧾 Ventas
- 💰 Caja
- 👤 Clientes
- 🚚 Proveedores
- 📈 Reportes

---

# 🎯 Objetivos

- Arquitectura limpia y desacoplada.
- Diseño orientado al dominio (DDD).
- Arquitectura Hexagonal (Ports & Adapters).
- API REST profesional.
- Seguridad mediante JWT.
- Auditoría automática.
- Documentación OpenAPI.
- Base para aplicaciones Web y Mobile.

---

# 🏗 Arquitectura

El proyecto implementa una combinación de:

- Domain Driven Design (DDD)
- Arquitectura Hexagonal
- Clean Architecture

### Flujo de una petición

```text
Cliente

↓

Controller

↓

Use Case

↓

Domain

↓

Repository (Puerto)

↓

Repository Adapter

↓

Spring Data JPA

↓

PostgreSQL
```

---

# 🛠 Stack Tecnológico

| Tecnología | Versión |
|------------|----------|
| Java | 21 |
| Spring Boot | 3.5 |
| Maven | 3.9+ |
| PostgreSQL | 17 |
| Docker | Latest |
| Flyway | Última |
| MapStruct | 1.6 |
| Lombok | ✔ |
| Spring Security | ✔ |
| Swagger / OpenAPI | ✔ |

---

# 📂 Arquitectura del Proyecto

```text
src/main/java/com/controltotal

├── application
│   ├── dto
│   ├── mapper
│   └── usecase
│
├── domain
│   ├── model
│   ├── repository
│   ├── service
│   ├── valueobject
│   └── exception
│
├── infrastructure
│   ├── config
│   ├── controller
│   ├── persistence
│   │   ├── adapter
│   │   ├── audit
│   │   ├── entity
│   │   ├── mapper
│   │   └── repository
│   └── security
│
└── shared
    ├── exception
    ├── response
    ├── util
    └── constant
```

---

# 📦 Capas

## Application

Contiene la lógica de aplicación.

- DTO
- Casos de uso
- Mappers

---

## Domain

Representa el núcleo del negocio.

- Entidades
- Interfaces de repositorio
- Servicios de dominio
- Value Objects

No depende de Spring.

---

## Infrastructure

Implementación de tecnologías.

- Controllers REST
- JPA
- PostgreSQL
- Spring Security
- Configuración
- Adaptadores

---

## Shared

Componentes reutilizables.

- ApiResponse
- Excepciones
- Utilidades

---

# ⚙ Requisitos

- Java 21
- Maven 3.9+
- Docker Desktop
- Git

---

# 🐳 Docker

Levantar PostgreSQL

```bash
docker start controltotal-postgres
```

Levantar pgAdmin

```bash
docker start controltotal-pgadmin
```

---

# 🗄 Base de Datos

Motor

```
PostgreSQL
```

Base de datos

```
control_total
```

Usuario

```
controltotal
```

Las migraciones son administradas mediante Flyway.

---

# 🛫 Flyway

Las migraciones se encuentran en:

```text
src/main/resources/db/migration
```

Ejemplo:

```
V1__create_empresa_table.sql
```

```
V2__update_empresa_table.sql
```

Regla del proyecto:

> Nunca modificar una migración ejecutada.

Siempre crear una nueva versión.

---

# 📚 Swagger

Una vez iniciada la aplicación:

```
http://localhost:8080/swagger-ui/index.html
```

Documentación OpenAPI:

```
http://localhost:8080/v3/api-docs
```

---

# ▶ Ejecutar el proyecto

Compilar

```bash
mvn clean install
```

Ejecutar

```bash
mvn spring-boot:run
```

---

# 📡 Endpoints Implementados

## Empresas

| Método | Endpoint | Estado |
|---------|----------|--------|
| POST | /api/v1/empresas | ✅ |

---

# 🗺 Roadmap

## Infraestructura

- ✅ Arquitectura
- ✅ Docker
- ✅ PostgreSQL
- ✅ Flyway
- ✅ Swagger
- ✅ Auditoría Automática

## Empresa

- ✅ Crear Empresa

## Próximos módulos

- ⬜ Sucursal
- ⬜ Usuario
- ⬜ Roles
- ⬜ Autenticación JWT
- ⬜ Productos
- ⬜ Categorías
- ⬜ Inventario
- ⬜ Clientes
- ⬜ Proveedores
- ⬜ Ventas
- ⬜ Caja
- ⬜ Reportes

---

# 📏 Convenciones del Proyecto

- Arquitectura Hexagonal.
- DDD.
- DTO separados del dominio.
- Casos de uso por funcionalidad.
- Validaciones mediante Bean Validation.
- Manejo global de excepciones.
- Auditoría automática mediante Spring Data Auditing.
- Migraciones con Flyway.
- Documentación con Swagger/OpenAPI.

---

# 📌 Estado del Proyecto

Versión actual

```
0.1.0
```

Estado

```
En desarrollo 🚧
```

---

# 👨‍💻 Autor

**Jonathan Tapia**

Proyecto personal desarrollado como una plataforma ERP/POS moderna, escalable y orientada a múltiples tipos de negocio.

---

# 📄 Licencia

Este proyecto es de uso privado y no puede ser distribuido sin autorización del autor.