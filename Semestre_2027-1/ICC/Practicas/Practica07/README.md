Práctica 07
Autora: Sofía López Castro  
Versión: 1.0  

Descripción de la práctica:
Programa para modelar paquetes postales, calcular su peso volumétrico y determinar el peso cobrable final,
cotizar tarifas escalonadas de envío y evaluar si requieren póliza de seguro obligatorio.

Estructura de clases (src)
Paquete.java: Modela un paquete con su código alfanumérico, peso físico, dimensiones (alto, ancho, largo) y
valor declarado. Incluye el cálculo de peso volumétrico, peso cobrable y el método personalizado
`calcularDescuentoAltoValor()` el cual otorga un descuento promocional de \$399.00 cuando el valor declarado 
supera los \$5,000.00.
CotizadorEnvio.java: Clase de con métodos estáticos para validar la integridad de un paquete (`esPaqueteValido`), 
calcular el costo del envío por rangos de peso (`cotizarEnvio`) y verificar si es obligatorio el  seguro por monto
o sobredimensionamiento (`requiereSeguro`).
PruebaPaqueteria.java: Clase ejecutable con el método `main` que verifica los distintos escenarios de prueba y 
el funcionamiento del método personalizado.

Estructura del directorio
Practica07
├── README.md
├── src/        # Archivos fuente (.java)
├── bin/        # Archivos compilados (.class)
└── doc/        # Documentación HTML generada con Javadoc
