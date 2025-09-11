# FrontClinica

Este proyecto fue generado con [Angular CLI](https://github.com/angular/angular-cli) versión 20.2.2.

## Descripción

FrontClinica es la interfaz de usuario para un sistema de gestión de clínicas. Permite a los usuarios interactuar con el sistema para gestionar pacientes, citas y otros aspectos de la clínica.

## Requisitos Previos

Asegúrate de tener instaladas las siguientes herramientas:

*   [Node.js](https://nodejs.org/) (que incluye npm)
*   [Angular CLI](https://cli.angular.io/)

## Instalación

1.  Clona el repositorio:
    ```sh
    git clone <URL_DEL_REPOSITORIO>
    ```
2.  Navega al directorio del frontend:
    ```sh
    cd frontend
    ```
3.  Instala las dependencias del proyecto:
    ```sh
    npm install
    ```

## Servidor de Desarrollo

Ejecuta `ng serve` para iniciar el servidor de desarrollo. Navega a `http://localhost:4200/`. La aplicación se recargará automáticamente si cambias alguno de los archivos de origen.

## Compilación

Ejecuta `ng build` para compilar el proyecto. Los artefactos de la compilación se almacenarán en el directorio `dist/`.

## Estructura del Proyecto

La estructura del código fuente del frontend es la siguiente:

```
src/
├── app/
│   ├── components/         # Componentes reutilizables
│   ├── guards/             # Guardianes de rutas
│   ├── models/             # Interfaces y modelos de datos
│   ├── services/           # Servicios de la aplicación
│   ├── app.component.css
│   ├── app.component.html
│   ├── app.component.ts
│   ├── app.config.ts
│   └── app.routes.ts       # Definición de rutas
├── assets/                 # Archivos estáticos (imágenes, fuentes)
├── environments/           # Configuración de entornos
├── index.html              # Página principal
├── main.ts                 # Punto de entrada de la aplicación
└── styles.css              # Estilos globales
```

### Rutas Principales

Las rutas de la aplicación están definidas en `app.routes.ts`:

*   `/`: Pantalla de inicio de sesión.
*   `/salir`: Cierra la sesión del usuario.
*   `/inicio`: Página principal después de iniciar sesión.
*   `/registrar`: Formulario para registrar un nuevo paciente (protegido por guardia de autenticación).
*   `/editar/:id`: Formulario para editar un paciente existente (protegido por guardia de autenticación).

### Servicios

Los servicios principales de la aplicación se encuentran en la carpeta `src/app/services`:

*   **`api.service.ts`**: Gestiona las URL de la API.
*   **`auth.service.ts`**: Lógica de autenticación.
*   **`especialidad.service.ts`**: Gestiona los datos de las especialidades.
*   **`imc.service.ts`**: Lógica para calcular el IMC.
*   **`jwt-decoder.service.ts`**: Decodifica los tokens JWT.
*   **`login.service.ts`**: Gestiona el inicio de sesión.
*   **`paciente.service.ts`**: Gestiona los datos de los pacientes.
*   **`role.service.ts`**: Gestiona los roles de usuario.
*   **`ui.service.ts`**: Servicios relacionados con la interfaz de usuario.
*   **`user.service.ts`**: Gestiona los datos de los usuarios.

### Componentes

Los componentes principales de la aplicación son:

*   **`login`**: Componente para el inicio de sesión.
*   **`logout`**: Componente para cerrar sesión.
*   **`inicio`**: Componente de la página de inicio.
*   **`formulario-paciente`**: Componente para crear y editar pacientes.
*   **`confirmar-dialog`**: Componente de diálogo de confirmación.

## Ayuda Adicional

Para obtener más ayuda sobre Angular CLI, usa `ng help` o consulta la [Referencia de Comandos de Angular CLI](https://angular.io/cli).