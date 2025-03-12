# Taller06AREP

## Descripción del Proyecto
Este proyecto implementa una aplicación basada en **Spring Boot** con una arquitectura segura y despliegue en **AWS**. La aplicación gestiona autenticación segura con contraseñas cifradas, conexión TLS y certificados de **Let's Encrypt**.

## Arquitectura de la Aplicación

### Componentes Clave

- **Cliente HTML + JavaScript**: Interfaz frontend asíncrona que se comunica con la API de Spring.
- **Spring Boot**: Back-end que maneja la autenticación y lógica.
- **Apache**: Servidor web que asegura la comunicación segura.
- **AWS**: Plataforma de despliegue con medidas de seguridad implementadas.

### Relación entre Componentes

1. El cliente envía solicitudes HTTP a Apache.
2. Apache redirige el tráfico al servicio de Spring Boot.
3. Spring Boot procesa la lógica y devuelve respuestas al cliente.
4. Todo el tráfico se cifra con TLS para mayor seguridad.

### Estrategia de Despliegue Seguro en AWS

- Configuración de **EC2**.
- Uso de **Let's Encrypt** para certificados SSL/TLS.
- Uso de **Apache** para manejar el tráfico de manera segura.

## Implementación de Seguridad

- **Conexión segura**: Uso de TLS para cifrar la comunicación.
- **Autenticación segura**: Contraseñas almacenadas como hashes con **BCrypt**.
- **Certificados Let's Encrypt**: Implementados para HTTPS.

## Instrucciones de Despliegue

### Requisitos Previos

- Java 17+
- Maven
- AWS CLI configurado
- Certbot para Let's Encrypt

### Pasos

1. Clonar el repositorio:
   ```sh
   git clone https://github.com/Andrea2511/Taller06AREP.git
   cd Taller06AREP
   ```
2. Construir el proyecto con Maven:
   ```sh
   mvn clean package
   ```
3. Ejecutar la aplicación:
   ```sh
   java -jar target/taller06arep.jar
   ```
4. Acceder a https://localhost:8443

--

## Autor

Andrea Valentina Torres Tobar


