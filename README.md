# 🗂️ Prueba Técnica - Desafío Nisum

Este proyecto Backend desarrollado en Java con Spring Boot, cuyo objetivo es realizar un registro de usuario e inicio de sesión validando expresión regular en la contraseña.


---

## Documentación
http://localhost:8080/swagger-ui/index.html
- Los End-Point estan securizados.
- Para uso mas fácil y expedito se encuentra collection de POSTMAN en RUTA: **collection_postman/Nisum.collection.json** (EN LA RAÍZ DEL PROYECTO).
---

## 🚀 Características principales

- Java 21 & Spring boot 3.4.4
- Persistencia de datos utilizando **Spring Data JPA** en una base de datos **H2**.
- Seguridad mediante **Spring Security** y **JWT**.
- Crear y Visualizar Usuario.
- Validar Cumplimiento de expresión regular en Passwords.
- Arquitectura hexagonal para una correcta aplicacion de los Principios SOLID.
- Uso del patrón **Builder** para la construcción de objetos.
- Datos insertados en la base de datos H2 para pruebas **country_codes** , **city_codes** , **users** , **security_parameters**.
- Pruebas Unitarias y de integracion con **JUnit 5** y **Mockito** con cobertura de lineas y branches al 100% en los casos de uso.

---

## 📝 Importante

- Los recursos se encuentran protegidos por un token JWT, solo el End Point /Login es público, este responde un token que debe  en Swagger para realizar las peticiones.
- Endpoint: `http://localhost:8080/login` -> POST
```json
{
  "username": "mvaldes@nisum.com",
  "password": "nisum"
}
```

---

## 🧠 Arquitectura

Este proyecto implementa una **Arquitectura Hexagonal (Ports & Adapters)**, separando claramente:

- **Dominio**: Modelos y lógica abstracta (`User`, `Phone`, `Security Parameter`)
- **Aplicación**: casos de uso (`Manejo de Lógica`)
- **Infraestructura**: controladores REST, DTOs, persistencia (`Todo lo referente al Framework, separando el framework y dependencias del dominio`)
- **Configuración**: confguraciones de dependencias.

---


### Arquitectura de paquetes:
```
com
├── nisum
│   ├── desafio
│   │   ├── application
│   │   │   ├── usecases
│   │   │   |   ├── city_code
│   │   │   |   ├── country_code
│   │   │   |   ├── parameter_security
│   │   │   |   ├── phone
│   │   │   |   ├── user
│   │   ├── domain
│   │   │   ├── exceptions
│   │   │   ├── models
│   │   │   |   ├── constants
│   │   │   ├── ports
│   │   │   |   ├── in
│   │   │   │   |   ├── city_code
│   │   │   │   |   ├── country_code
│   │   │   │   |   ├── parameter_security
│   │   │   │   |   ├── phone
│   │   │   │   |   ├── user
│   │   │   |   ├── out
│   │   │   |   |   ├── repositories
│   │   ├── infrastructure
│   │   │   ├── adapters
│   │   │   |   ├── in
│   │   │   |   |   ├── rest
│   │   │   |   |   |   ├── dtos
│   │   │   |   |   |   ├── impl
│   │   │   |   ├── out
│   │   │   |   |   ├── repositories
│   │   │   ├── config
│   │   │   ├── db
│   │   │   |   ├── jpa
│   │   │   |   |   ├── entities
│   │   │   |   |   ├── repositories
│   │   ├── exceptions
│   │   |    ├── catalog
│   │   |    ├── dto
│   │   ├── security
│   │   ├── shared
│___│___|___├── annotations
