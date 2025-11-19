# Student CRUD Demo Application

Una aplicación web completa en Spring Boot para gestionar registros de estudiantes con operaciones CRUD (Crear, Leer, Actualizar, Eliminar).

## Descripción

Esta aplicación permite administrar una base de datos de estudiantes a través de una interfaz web moderna. Cada estudiante tiene:
- **Nombre**: 2-60 caracteres
- **Email**: Validado con formato correcto
- **Calificación**: Número entre 0-100

La aplicación usa una arquitectura en capas (Controller → Service → Repository → Entity) siguiendo las mejores prácticas de Spring Boot.

## Características

 **CRUD Completo**
  - Crear nuevos estudiantes
  - Ver lista de todos los estudiantes
  - Editar información existente
  - Eliminar estudiantes

 **Validación de Datos**
  - Validación del lado del cliente (HTML5)
  - Validación del lado del servidor (Bean Validation)
  - Mensajes de error personalizados

 **Base de Datos**
  - H2 in-memory (datos temporales)
  - Datos de ejemplo precargados
  - Consola H2 para inspección directa

 **Interfaz Moderna**
  - Bootstrap 5
  - Diseño responsive
  - Font Awesome icons

## Requisitos

- **Java 21** (JDK instalado en `C:\Program Files\Java\jdk-21`)
- **Maven** NO es necesario (usa Maven Wrapper incluido)

## Cómo Ejecutar

###  Opción 1: Script de Ejecución Rápida (Recomendado)

Simplemente ejecuta:

```cmd
.\run.bat
```

Este script automáticamente:
1. Configura la variable JAVA_HOME
2. Inicia la aplicación con Maven Wrapper
3. Muestra el logo de Spring Boot

### Opción 2: Maven Wrapper Manual

Si prefieres ejecutar manualmente:

```cmd
set JAVA_HOME=C:\Program Files\Java\jdk-21
mvnw.cmd spring-boot:run
```

### Opción 3: Compilar y Ejecutar JAR

```cmd
mvnw.cmd clean package
java -jar target\crud-demo-1.0.0.jar
```

## Detener la Aplicación

Presiona `Ctrl+C` en la terminal donde está corriendo

## Acceder a la Aplicación

Una vez iniciada la aplicación (verás el mensaje "Started CrudDemoApplication"), abre tu navegador:

###  Aplicación Principal
**http://localhost:8080**

Aquí podrás:
- Ver la tabla de estudiantes
- Agregar nuevos estudiantes usando el formulario
- Editar estudiantes existentes (botón azul con lápiz)
- Eliminar estudiantes (botón rojo con basura)

###  Consola de Base de Datos H2
**http://localhost:8080/h2**

Para inspeccionar directamente la base de datos:
- **JDBC URL**: `jdbc:h2:mem:demo`
- **Username**: `sa`
- **Password**: _(dejar vacío)_

Desde aquí puedes ejecutar consultas SQL manualmente.

## Estructura del Proyecto

```
crud-demo/
├── src/
│   └── main/
│       ├── java/com/example/crud/
│       │   ├── CrudDemoApplication.java          # Clase principal (punto de entrada)
│       │   ├── controller/
│       │   │   ├── HomeController.java           # Redirección de /
│       │   │   └── StudentController.java        # Endpoints CRUD (/students)
│       │   ├── entity/
│       │   │   └── Student.java                  # Entidad JPA (modelo)
│       │   ├── repository/
│       │   │   └── StudentRepository.java        # Acceso a datos (JPA)
│       │   └── service/
│       │       ├── StudentService.java           # Interface del servicio
│       │       └── impl/
│       │           └── StudentServiceImpl.java   # Lógica de negocio
│       └── resources/
│           ├── application.properties            # Configuración de Spring
│           ├── data.sql                          # Datos de ejemplo (3 estudiantes)
│           └── templates/
│               ├── layout.html                   # Layout base (no usado actualmente)
│               └── students.html                 # Interfaz web principal
├── pom.xml                                       # Dependencias Maven
├── mvnw.cmd                                      # Maven Wrapper (Windows)
└── run.bat                                       # Script de ejecución rápida
```

## Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Spring Boot** | 3.2.5 | Framework principal |
| **Spring Data JPA** | - | Persistencia de datos |
| **Hibernate** | 6.4.4 | ORM (implementación JPA) |
| **Thymeleaf** | - | Motor de plantillas (HTML dinámico) |
| **H2 Database** | 2.2.224 | Base de datos en memoria |
| **Bootstrap** | 5.3.3 | Framework CSS |
| **Font Awesome** | 6.5.0 | Iconos |
| **Lombok** | 1.18.30 | Reduce código boilerplate |
| **Bean Validation** | - | Validación de datos |

## Arquitectura

La aplicación sigue el patrón **MVC** (Model-View-Controller) con capas adicionales:

```
┌─────────────┐
│  Browser    │  ← Vista (Thymeleaf + Bootstrap)
└──────┬──────┘
       │ HTTP
┌──────▼──────┐
│ Controller  │  ← Maneja peticiones HTTP
└──────┬──────┘
       │
┌──────▼──────┐
│  Service    │  ← Lógica de negocio
└──────┬──────┘
       │
┌──────▼──────┐
│ Repository  │  ← Acceso a datos (JPA)
└──────┬──────┘
       │
┌──────▼──────┐
│  Database   │  ← H2 in-memory
└─────────────┘
```

## Datos de Ejemplo

Al iniciar, la aplicación carga automáticamente 3 estudiantes desde [data.sql](src/main/resources/data.sql):

1. **Alice Johnson** - alice@example.com - Calificación: 95
2. **Bruno Díaz** - bruno@example.com - Calificación: 88
3. **Carla Ruiz** - carla@example.com - Calificación: 72

## Notas Importantes

-  **Base de datos temporal**: Los datos se pierden al detener la aplicación (H2 in-memory)
-  **LiveReload**: La aplicación se recarga automáticamente al cambiar archivos (puerto 35729)
-  **DevTools**: Spring Boot DevTools está activo para desarrollo
-  **Logs SQL**: Todas las consultas SQL se muestran en la consola (`spring.jpa.show-sql=true`)

## Solución de Problemas

### Error: "JAVA_HOME not found"
Usa el script `run.bat` que configura JAVA_HOME automáticamente.

### Puerto 8080 ya en uso
Cambia el puerto en [application.properties](src/main/resources/application.properties):
```properties
server.port=8081
```

### La aplicación no muestra los estudiantes
1. Verifica que `data.sql` esté en `src/main/resources/`
2. Revisa la consola para ver si hay errores SQL
3. Accede a http://localhost:8080/h2 y verifica que la tabla STUDENT exista

## Autor

Proyecto de demostración CRUD con Spring Boot
