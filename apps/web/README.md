# 🚀 Control Total - Frontend

Frontend oficial de **Control Total**, una plataforma ERP/POS multiempresa desarrollada con **Angular 22**, basada en una arquitectura moderna, escalable y mantenible.

                    Control Total

          ┌────────────────────────────┐
          │        Angular 22          │
          │         Frontend           │
          └─────────────┬──────────────┘
                        │ REST API
                        ▼
          ┌────────────────────────────┐
          │      Spring Boot API       │
          │ Hexagonal + DDD + Clean    │
          └─────────────┬──────────────┘
                        │
                        ▼
                PostgreSQL + Docker

---

# 📌 Tecnologías

- Angular 22
- TypeScript 6
- Angular Material
- Standalone Components
- RxJS
- CSS
- REST API
- JWT Authentication (próximamente)

---

# 📂 Estructura del proyecto

```
apps/web
│
├── public/
│
├── src/
│   ├── app/
│   │
│   ├── core/
│   │
│   ├── layout/
│   │
│   ├── shared/
│   │
│   ├── features/
│   │
│   ├── assets/
│   │
│   ├── styles/
│   │
│   ├── app.config.ts
│   ├── app.routes.ts
│   └── app.ts
│
├── angular.json
├── package.json
└── README.md
```

---

# 🏛 Arquitectura

El frontend sigue una arquitectura basada en responsabilidades.

```
Page
   │
   ▼
Component
   │
   ▼
Service
   │
   ▼
REST API
```

La lógica de negocio nunca se implementa en los componentes visuales.

---

# 📦 Organización

## Core

Contiene componentes globales de la aplicación.

Ejemplo:

- Authentication
- JWT
- Guards
- HTTP Interceptors
- Configuración
- Servicios globales

---

## Layout

Define la estructura visual.

```
Shell
│
├── Header
├── Sidebar
├── Footer
└── RouterOutlet
```

---

## Shared

Componentes reutilizables.

Ejemplo:

- Tabla
- Dialog
- Card
- Loader
- Confirm Dialog
- Botones
- Pipes

---

## Features

Cada módulo del ERP vive de forma independiente.

Ejemplo:

```
empresas
│
├── pages
├── components
├── services
├── models
└── empresa.routes.ts
```

---

# 🎯 Convenciones

## Componentes

```
empresa-list.component.ts
empresa-form.component.ts
dashboard.component.ts
```

## Servicios

```
empresa.service.ts
usuario.service.ts
```

## Modelos

```
empresa.ts
usuario.ts
```

## Requests

```
create-empresa.request.ts
update-empresa.request.ts
```

## Responses

```
empresa.response.ts
```

---

# 🖥 Layout principal

```
┌───────────────────────────────────────────────────────────────┐
│ Header                                                        │
├───────────────┬───────────────────────────────────────────────┤
│               │                                               │
│   Sidebar     │              Router Outlet                    │
│               │                                               │
├───────────────┴───────────────────────────────────────────────┤
│ Footer                                                        │
└───────────────────────────────────────────────────────────────┘
```

---

# 🎨 UI

El proyecto utiliza Angular Material para:

- Toolbar
- Sidenav
- Tables
- Dialogs
- Inputs
- Menus
- Snackbar
- Cards

Los estilos propios se implementan mediante CSS.

---

# 🔒 Autenticación

Próximamente:

- JWT
- Refresh Token
- Route Guards
- HTTP Interceptor

---

# 📈 Roadmap

## Sprint 1

- [x] Bootstrap Angular
- [x] Angular Material
- [ ] Shell
- [ ] Header
- [ ] Sidebar
- [ ] Dashboard

## Sprint 2

- [ ] Login
- [ ] JWT
- [ ] Guards
- [ ] Interceptor

## Sprint 3

- [ ] Empresas

## Sprint 4

- [ ] Sucursales

## Sprint 5

- [ ] Productos

## Sprint 6

- [ ] Inventario

## Sprint 7

- [ ] Ventas

---

# ▶️ Instalación

Instalar dependencias

```bash
npm install
```

Ejecutar la aplicación

```bash
ng serve
```

Abrir

```
http://localhost:4200
```

---

# 📖 Buenas prácticas

- Utilizar Standalone Components.
- Mantener componentes pequeños.
- No implementar lógica de negocio en componentes visuales.
- Consumir la API exclusivamente mediante Services.
- Mantener los módulos desacoplados.
- Seguir la estructura definida en este documento.

---

# 👨‍💻 Proyecto

**Control Total**

Plataforma ERP/POS Multiempresa desarrollada con:

- Angular 22
- Spring Boot
- PostgreSQL
- Docker
- Arquitectura Hexagonal
- DDD
- Clean Architecture