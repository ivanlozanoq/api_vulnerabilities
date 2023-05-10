# api_vulnerabilities

framework: springboot
language: java

# Esta aplicación es un servicio web que ofrece una API para la integración y gestión de vulnerabilidades NIST

# Dentro del repositorio se encuentra una carpeta con los diagramas correspondientes a la documentación del proyecto

# Se debe correr el script sql para probarlo de forma local

# La aplicación cuenta con diferentes end points que pueden ser probados desde la colección de postman

## Casos de uso

# actualizar base de datos: A partir de un post se consume una api externa de NIST, se extraen las vulnerabilidades y las traemos a nuestra base de datos.
Las demás características del servicio trabajan en base a esta información. Se recomienda ejecutar este endpoint en un principio.


GET
# listar: se lista todas las vulnerabilidades desde nuestra base de datos

# marcar como resuelta: es un método post que recibe un id, busca la vulnerabilidad asociada y la marca como resuelta

# listar no resueltas: se realiza un listado de las vulnerabilidades pendientes por resolver

# sumarizado: devuelte la cantidad de vulnerabilidades por severidad