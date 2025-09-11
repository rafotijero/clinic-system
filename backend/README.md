# Sistema Clínica - Backend API

API REST para sistema de gestión de clínica médica desarrollada con Spring Boot siguiendo principios SOLID y Clean Architecture.

## Tecnologías

- **Java 17+**
- **Spring Boot 3.4.0**
- **Spring Security 6.4.1** - Autenticación JWT
- **Spring Data JPA** - Persistencia de datos
- **MySQL** - Base de datos
- **Maven** - Gestión de dependencias
- **Swagger/OpenAPI 3** - Documentación de API

## Arquitectura

El proyecto sigue **Clean Architecture** con principios **SOLID**:

```
com.clinica/
├── application/          # Capa de aplicación
│   ├── dto/             # Data Transfer Objects
│   ├── port/            # Interfaces (contratos)
│   └── usecase/         # Casos de uso (lógica de negocio)
├── infrastructure/      # Capa de infraestructura
│   ├── adapter/         # Implementaciones de ports
│   ├── persistence/     # Entidades JPA y repositorios
│   ├── security/        # Configuración de seguridad
│   ├── mapper/          # Conversores de objetos
│   └── util/            # Utilidades
└── presentation/        # Capa de presentación
    └── controller/      # Controladores REST
```

### Principios SOLID Aplicados

- **Single Responsibility**: Cada UseCase tiene una responsabilidad específica
- **Open/Closed**: Extensible mediante nuevas implementaciones de ports
- **Liskov Substitution**: Implementaciones intercambiables de interfaces
- **Interface Segregation**: Interfaces específicas y focalizadas
- **Dependency Inversion**: Dependencias hacia abstracciones

## Configuración

### Requisitos

- Java 17 o superior
- Maven 3.6+
- MySQL 8.0+
- Puerto 8080 disponible

### Base de Datos

1. Crear base de datos en MySQL:
```sql
CREATE DATABASE bdClinica;
```

2. Configurar en `application.properties`:
```properties
spring.application.name=BackClinica
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/bdClinica?useSSL=false&serverTimeZone=UTC
spring.datasource.username=root
spring.datasource.password=mysql
```

### Instalación

1. Clonar el repositorio
2. Instalar dependencias:
```bash
mvn clean install
```

3. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

## Documentación API

### Swagger UI
Accede a la documentación interactiva en:
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API Docs**: http://localhost:8080/api-docs

### Endpoints Principales

#### Autenticación
```http
POST /api/usuario/login
Content-Type: application/json

{
    "usuario": "admin",
    "clave": "password123"
}
```

#### Pacientes
```http
GET    /api/paciente/listar              # Listar pacientes activos
GET    /api/paciente/obtener/{id}        # Obtener por ID
POST   /api/paciente/registrar           # Crear paciente
PUT    /api/paciente/actualizar/{id}     # Actualizar paciente
DELETE /api/paciente/eliminar/{id}       # Eliminar paciente (soft delete)
```

#### Especialidades
```http
GET    /api/especialidad/listar          # Listar especialidades
```

## Autenticación

El sistema utiliza **JWT (JSON Web Tokens)** para autenticación:

1. **Login**: Envía credenciales a `/api/usuario/login`
2. **Response**: Recibe token JWT válido por 1 hora
3. **Uso**: Incluye token en header: `Authorization: Bearer <token>`

### Roles y Permisos

- **ADMIN**: Acceso completo
- **MEDICO**: Gestión de pacientes y consulta de especialidades
- **ASISTENTE**: Solo consulta de pacientes

## Estructura de Datos

### Usuario
```json
{
    "id": 1,
    "usuario": "admin",
    "nombres": "Administrador",
    "apellidoPaterno": "Sistema",
    "correo": "admin@clinica.com",
    "roles": [{"id": 1, "nombre": "ADMIN"}]
}
```

### Paciente
```json
{
    "id": 1,
    "apellidoPaterno": "Miyagui",
    "apellidoMaterno": "Ogata",
    "nombres": "Hiro",
    "dni": "41681837",
    "peso": 80,
    "talla": 2,
    "imc": 20,
    "estado": 1,
    "especialidad": {
        "id": 1,
        "nombre": "Nutrición"
    }
}
```

### Especialidad
```json
{
    "id": 1,
    "nombre": "Nutrición"
}
```

## Casos de Uso Implementados

### Autenticación
- `LoginUseCaseImpl`: Proceso completo de autenticación

### Gestión de Pacientes
- `ListPacientesUseCaseImpl`: Listar pacientes activos
- `FindPacienteUseCaseImpl`: Buscar paciente por ID
- `CreatePacienteUseCaseImpl`: Crear nuevo paciente
- `UpdatePacienteUseCaseImpl`: Actualizar datos de paciente
- `DeletePacienteUseCaseImpl`: Eliminar paciente (soft delete)

### Especialidades
- `ListEspecialidadesUseCaseImpl`: Listar todas las especialidades

## Seguridad

### Configuración JWT
- **Algoritmo**: HS512
- **Duración**: 1 hora (3600000 ms)
- **Header**: `Authorization: Bearer <token>`

### Endpoints Protegidos
- Todos los endpoints excepto `/api/usuario/login` requieren autenticación
- Swagger UI y documentación son públicos para desarrollo

### CORS
Configurado para permitir requests desde:
- `http://localhost:4200` (Angular frontend)

## Desarrollo

### Agregar Nuevo Endpoint

1. **Crear UseCase**:
```java
@Component
public class NuevoUseCaseImpl implements NuevoUseCase {
    // Implementación
}
```

2. **Crear Port (Interface)**:
```java
public interface NuevoUseCase {
    ResponseDTO execute(RequestDTO request);
}
```

3. **Agregar al Controller**:
```java
@PostMapping("/nuevo")
public ResponseEntity<ResponseDTO> nuevo(@RequestBody RequestDTO request) {
    return ResponseEntity.ok(nuevoUseCase.execute(request));
}
```

### Principios de Desarrollo

- **Un UseCase por operación**: Mantener Single Responsibility
- **Interfaces para dependencias**: Aplicar Dependency Inversion
- **DTOs para comunicación**: Separar representación interna de externa
- **Adapters para implementaciones**: Aislar detalles técnicos

## Dependencias Principales

```xml
<dependencies>
    <!-- Spring Boot Starters -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    
    <!-- JWT -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.12.6</version>
    </dependency>
    
    <!-- MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    
    <!-- Swagger -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.6.0</version>
    </dependency>
    
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

## Contribución

1. Fork el proyecto
2. Crear feature branch (`git checkout -b feature/nueva-funcionalidad`)
3. Commit cambios (`git commit -am 'Agregar nueva funcionalidad'`)
4. Push al branch (`git push origin feature/nueva-funcionalidad`)
5. Crear Pull Request

### Estándares de Código

- Seguir principios SOLID
- Un UseCase por funcionalidad
- Interfaces para todas las dependencias
- Tests unitarios para UseCases
- Documentar endpoints en Swagger