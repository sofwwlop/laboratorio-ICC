# Práctica 9: Agregación, Clonación de Objetos y Guías de Envío
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Descripción de la práctica y decisiones de diseño en los métodos y clases

Describe brevemente los atributos, constructores y métodos que decidiste diseñar para `Persona.java`, así como tu implementación de `Envio.java`:

>Persona.java: Sus atributos fueron privados y de tipo String: nombre, id y ubicacion; los constructores fueron con parametro y por omision; los metodos que use fueron de acceso (getters y setters), metodos de comparacion como mismaUbicacionQue(Persona), esLaMismaPersona(Persnona), y toString().

>Envio.java: Sus atributos fueron un public static final double CARGO_FORANEO = 80.0 el cual es el cargo que se le aplica a paquetes foraneos, un private static int contadorGuias inicializado en 0, y por agregacion estan el remitente y destinatario d etipo persona y el paquete de tipo paquete; para los constructores son con parametros, una era una copia del anterior; los metodos que use fueron de acceso (getters y setters), y otros metodos como esEnvioForaneo, esAutoEnvio, calcularCostoTotal, cambiarDestinatario(Persona), generarGuiaRetorno().
---

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta (`practica09/`):

### 1. Compilación
```bash
<javac -d bin src/*.java>
```

### 2. Ejecución de pruebas y simulación (`PruebaEnvio`)
```bash
<java -cp bin PruebaEnvio>
```

### 3. Ejecución del menú interactivo (`MenuPostal`)
```bash
<java -cp bin MenuPostal>
```

### 4. Generación de documentación Javadoc
```bash
<javadoc -d doc -author -version src /*. java>
```

---

## Evidencia de ejecución

### 1. Salida de `PruebaEnvio`
Copia y pega aquí la salida final que mostró tu terminal al ejecutar `PruebaEnvio`:

```text
[
================================================================================
  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO
================================================================================

>>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE
  [OK]    Paquete.toString() incluye el codigo de rastreo
  [OK]    Constructor por copia de Paquete crea instancia independiente en memoria
  [OK]    Modificar el codigo del paquete clonado no altera el paquete plantilla original
  [OK]    Constructor por copia con null asigna valores predeterminados validos

>>> PARTE 2: VERIFICACION DE LA CLASE PERSONA
  [OK]    mismaUbicacionQue() devuelve true entre personaX y personaY
  [OK]    mismaUbicacionQue() devuelve false con personaZ
  [OK]    esLaMismaPersona() devuelve true para el mismo  identificador unico
  [OK]    esLaMismaPersona() devuelve false para distinto o null
  [OK]    Persona.toString() devuelve una cadena legible con sus datos

>>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS
  [OK]    Al inicio se han emitido 0 guias
  [OK]    Ambas guias tienen folios no nulos, distintos y con numeracion consecutiva (1 y 2)
  [OK]    El total de guias emitidas ahora es 2
  [OK]    Verifica que esEnvioForaneo()
  [OK]    Verifica que esAutoEnvio()
  [OK]    Verifica calcularCostoTotal() (confirmando el cargo foraneo)
  [OK]    Verifica que cambiarDestinatario() rechace null
  [OK]    Verifica que cambiarDestinatario() acepta a otra persona (o a si misma)

>>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO

a) Guia generada (Persona X a Persona Y): 
------------------------------------------
---- Comprobante ----
Remitente: ==== Datos de la persona ====
Nombre: Diego Morales Flores
ID: PER-01
Ubicacion: 62800
Destinatario ==== Datos de la persona ====
Nombre: Emiliano Gomez Reyes
ID: PER-02
Ubicacion: 62800
Paquete: ==== Ficha tecnica textual del paquete ====
Codigo de rastreo: KIT-101
Peso: 4.0
Peso volumetrico: 1.6
Peso cobrable: 4.0
Dimensiones:
Largo: 20.0
Ancho: 20.0
Alto: 20.0
Valor declarado: 500.0
Es envio express: false
------------------------------------------
Folio: GUIA-EWK-3
Tipo de ruta: LOCAL
Envio personal: false
Costo total: $120.00
------------------------------------------


b) Guia clonada (Con nuevo paquete): 
------------------------------------------
---- Comprobante ----
Remitente: ==== Datos de la persona ====
Nombre: Diego Morales Flores
ID: PER-01
Ubicacion: 62800
Destinatario ==== Datos de la persona ====
Nombre: Emiliano Gomez Reyes
ID: PER-02
Ubicacion: 62800
Paquete: ==== Ficha tecnica textual del paquete ====
Codigo de rastreo: PKG-202
Peso: 12.0
Peso volumetrico: 7.2
Peso cobrable: 12.0
Dimensiones:
Largo: 30.0
Ancho: 30.0
Alto: 40.0
Valor declarado: 1500.0
Es envio express: false
------------------------------------------
Folio: GUIA-SXE-4
Tipo de ruta: LOCAL
Envio personal: false
Costo total: $246.00
------------------------------------------

  [OK]    verifica que conserva remitente y destinatario pero tiene el nuevo paquete y un nuevo folio consecutivo

c) Guia retorno: 
------------------------------------------
---- Comprobante ----
Remitente: ==== Datos de la persona ====
Nombre: Emiliano Gomez Reyes
ID: PER-02
Ubicacion: 62800
Destinatario ==== Datos de la persona ====
Nombre: Diego Morales Flores
ID: PER-01
Ubicacion: 62800
Paquete: ==== Ficha tecnica textual del paquete ====
Codigo de rastreo: RET-KIT-101
Peso: 4.0
Peso volumetrico: 1.6
Peso cobrable: 4.0
Dimensiones:
Largo: 20.0
Ancho: 20.0
Alto: 20.0
Valor declarado: 500.0
Es envio express: false
------------------------------------------
Folio: GUIA-GLT-5
Tipo de ruta: LOCAL
Envio personal: false
Costo total: $120.00
------------------------------------------

  [OK]    Verifica que en la guia de retorno el remitente es Y, el destinatario es X, el paquete es una copiaindependiente con prefijo RET- y cuenta con un nuevo folio consecutivo
Total acumulado de guias emitidas en el sistema: 5

================================================================================
  RESUMEN DE PRUEBAS: 19 / 19 pruebas superadas con exito
================================================================================
]
```

### 2. Ejemplo de ejecución interactiva (`MenuPostal`)
Copia y pega aquí un ejemplo sencillo de interacción en terminal ejecutando `MenuPostal`:

```text
[
--- MENU PRINCIPAL ---
1. Emitir nueva guia de envio
2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)
3. Clonar paquete de la guia activa para enviarlo a otro destinatario
4. Generar guia de retorno (devolucion al remitente)
5. Mostrar detalle y costo de la guia activa
0. Salir
Seleccione una opcion: 1

--- Captura de datos del REMITENTE ---
Introduce tu nombre completo: 
Sofia Lopez Castro
Introduce tu ID (ej. PER-01): 
PER-00
Introduce tu codigo postal (ej. 62800)
43200

--- Captura de datos del DESTINATARIO ---
Introduce tu nombre completo: 
Luis Hernandez Cruz
Introduce tu ID (ej. PER-01): 
PER-01
Introduce tu codigo postal (ej. 62800)
44700}

--- Captura de datos del Paquete ---
  Codigo de rastreo (ej. PKG-500): PKG-001
  Peso fisico en kg (ej. 3.5): 40
  Alto en cm (ej. 20): 45
  Ancho en cm (ej. 20): 30
  Largo en cm (ej. 30): 28
  Valor declarado en MXN (ej. 800): 950
  ¿Es envio express? (s/n): s

Guia emitida con exito:
------------------------------------------
---- Comprobante ----
Remitente: ==== Datos de la persona ====
Nombre: Sofia Lopez Castro
ID: PER-00
Ubicacion: 43200
Destinatario ==== Datos de la persona ====
Nombre: Luis Hernandez Cruz
ID: PER-01
Ubicacion: 44700}
Paquete: ==== Ficha tecnica textual del paquete ====
Codigo de rastreo: PKG-001
Peso: 40.0
Peso volumetrico: 7.56
Peso cobrable: 40.0
Dimensiones:
Largo: 28.0
Ancho: 30.0
Alto: 45.0
Valor declarado: 950.0
Es envio express: true
------------------------------------------
Folio: GUIA-QRE-1
Tipo de ruta: FORANEO
Envio personal: false
Costo total: $1005.00
------------------------------------------
]
```

---

## Preguntas de reflexión 

1. **¿En qué se diferencia clonar un `Paquete` (`new Paquete(kitBase)`) de clonar una guía de `Envio` (`new Envio(guiaBase, nuevoPaquete)`) respecto a qué objetos se comparten y cuáles se duplican en memoria?**
   > [Al momento de clonar un paquete se crea una copia nueva e independiente del paquete, asi que si modificamos la copia pues no afectara en nada al paquete ademas de que no comparte el objeto original. Por otro lado, al clonar un envio se crea una nueva guia con distinto folio y nuevo paquete pwero comparten los objetos de tipo Persona de la guia original.]

2. **Para generar el `folioGuia` con un número consecutivo global y consultar cuántas guías se han emitido en total, ¿qué modificador tuviste que utilizar en ese atributo y en su método de consulta? ¿Por qué no funcionaría si el contador fuera un atributo normal de instancia?**
   > [El modificador que use fue el static en el atributo contador y en el metodo de consulta. Si el contador fuera un atributo normal de instancia no funcionaria porque acda objeto de tipo Envio tendria su propia copia independiente del contador inicnializada en 0, por lo que se repetirian los folios y ni se podria llevar una cuenta.]

3. **Si una guía `envio1` se descarta (`envio1 = null;`), ¿qué ocurre en memoria con los objetos `Persona` (remitente/destinatario) y `Paquete` que estaban asociados a ella?**
   > [La memoria elimina la referencia hacia esa guia pero los objetos persona y paquete siguen existiendo.]
