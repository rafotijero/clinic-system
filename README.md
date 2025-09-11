# Sistema de Gestión Clínica

Sistema para gestión de clínica médica con backend API REST y frontend Angular.

## Estructura del Proyecto

```
clinic-system/
├── backend/          # API REST con Spring Boot
├── frontend/         # Aplicación Angular
└── README.md         # Este archivo
```

## Tecnologías

### Backend
- **Spring Boot 3.4.0** - Framework principal
- **Spring Security** - Autenticación JWT
- **MySQL** - Base de datos
- **Swagger** - Documentación API

### Frontend
- **Angular** - Framework frontend
- **TypeScript** - Lenguaje principal
- **Bootstrap** - Estilos CSS

## Funcionalidades

- Autenticación de usuarios con JWT
- Gestión de pacientes (CRUD completo)
- Administración de especialidades médicas
- Sistema de roles (Admin, Médico, Asistente)
- API REST documentada con Swagger

## Configuración Rápida

### Backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
```
API disponible en: http://localhost:8080

### Frontend
```bash
cd frontend
npm install
ng serve
```
App disponible en: http://localhost:4200

## Documentación

- **API Backend**: http://localhost:8080/swagger-ui.html
- **Arquitectura**: Ver README.md en carpeta `/backend`
- **Frontend**: Ver README.md en carpeta `/frontend`

## Arquitectura

El proyecto sigue principios **SOLID** y **Clean Architecture**:

- Separación de responsabilidades
- Dependency Inversion
- Interfaces para abstracciones
- Casos de uso específicos
- Adapters para implementaciones

## Contribución

1. Fork el repositorio
2. Crear rama para nueva funcionalidad
3. Realizar cambios siguiendo los estándares del proyecto
4. Crear Pull Request

## Enlaces

- **Repositorio**: https://github.com/rafotijero/clinic-system