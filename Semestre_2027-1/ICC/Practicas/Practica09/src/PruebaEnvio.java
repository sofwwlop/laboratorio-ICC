/**
 * Programa de pruebas y simulacion para las Guias de Envios
 * Ejecuta pruebas automatizadas.
 * 
 * @author Sofia Lopez Castro
 * @version 1.0
 */
public class PruebaEnvio 
{

    /*
    * - Incluye las secciones guiadas para que agregues las pruebas de tu diseno
    *   de Persona (Parte 2), Envio y generacion de folios consecutivos (Parte 3),
    *   asi como la simulacion integral de envios, clones y devolucion (Parte 4).
    */

    private static int pruebasExitosas = 0;
    private static int totalPruebas = 0;

    /**
     * Metodo principal de verificacion y simulacion no interactiva.
     * 
     * @param args Argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO");
        System.out.println("================================================================================\n");

        // ---------------------------------------------------------------------
        // PARTE 1: PAQUETES ESTANDARIZADOS (CONSTRUCTOR POR COPIA Y TOSTRING)
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE");
        Paquete kitBase = new Paquete("KIT-101", 4.0, 20.0, 20.0, 20.0, 500.0, false);
        Paquete otroPaquete = new Paquete("PKG-202", 12.0, 40.0, 30.0, 30.0, 1500.0, false);

        String txtKit = kitBase.toString();
        verificar("Paquete.toString() incluye el codigo de rastreo",
                  txtKit != null && txtKit.contains("KIT-101") && !txtKit.contains("Paquete@"));

        Paquete kitClon = new Paquete(kitBase);
        double pesoOriginal = kitBase.getPeso();
        kitBase.setPeso(99.0);
        verificar("Constructor por copia de Paquete crea instancia independiente en memoria",
                  kitClon != kitBase && Math.abs(kitClon.getPeso() - pesoOriginal) < 1e-6);
        kitBase.setPeso(pesoOriginal);

        kitClon.setCodigoRastreo("KIT-102"); // Nuevo codigo para envio en serie
        verificar("Modificar el codigo del paquete clonado no altera el paquete plantilla original",
                  "KIT-101".equals(kitBase.getCodigoRastreo()) && "KIT-102".equals(kitClon.getCodigoRastreo()));

        Paquete clonNulo = new Paquete(null);
        verificar("Constructor por copia con null asigna valores predeterminados validos",
                  clonNulo.getCodigoRastreo() != null && clonNulo.getPeso() > 0.0);
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 2: PRUEBAS DE TU DISENO DE LA CLASE PERSONA
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 2: VERIFICACION DE LA CLASE PERSONA");
        Persona personaX = new Persona("Diego Morales Flores", "PER-01", "62800");
        Persona personaY = new Persona("Emiliano Gomez Reyes", "PER-02", "62800");
        Persona personaZ = new Persona("Valeria Rodriguez Mendoza", "PER-03","33500");
        Persona personaXCopia = new Persona("Diego Morales Flores", "PER-01", "62800");

        verificar("mismaUbicacionQue() devuelve true entre personaX y personaY",
                personaX.mismaUbicacionQue(personaY));
        verificar("mismaUbicacionQue() devuelve false con personaZ",
                !personaX.mismaUbicacionQue(personaZ)); 
        verificar("esLaMismaPersona() devuelve true para el mismo  identificador unico",
                personaX.esLaMismaPersona(personaXCopia));
        verificar("esLaMismaPersona() devuelve false para distinto o null",
                !personaX.esLaMismaPersona(personaY) && !personaX.esLaMismaPersona( null));
        String txtPersona = personaX.toString();
        verificar("Persona.toString() devuelve una cadena legible con sus datos",
                txtPersona != null && txtPersona.contains("Diego Morales Flores") && txtPersona.contains("PER-01")
                && txtPersona.contains("62800"));
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 3: PRUEBAS DE AGREGACION, FOLIOS CONSECUTIVOS Y OPERACIONES EN ENVIO
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS");
        verificar("Al inicio se han emitido 0 guias",
                Envio.getContadorGuias() == 0);
        Envio guiaLocal = new Envio(personaX, personaY, kitBase);
        Envio guiaForanea = new Envio(personaX, personaZ, kitClon);
        verificar("Ambas guias tienen folios no nulos, distintos y con numeracion consecutiva (1 y 2)",
                guiaLocal.getFolioGuia() != null && guiaForanea.getFolioGuia() != null
                && !guiaLocal.getFolioGuia().equals(guiaForanea.getFolioGuia())
                && guiaLocal.getFolioGuia().contains("-1")
                && guiaForanea.getFolioGuia().contains("-2"));
        verificar("El total de guias emitidas ahora es 2",
                Envio.getContadorGuias() == 2);
        verificar("Verifica que esEnvioForaneo()",
                !guiaLocal.esEnvioForaneo() && guiaForanea.esEnvioForaneo());
        verificar("Verifica que esAutoEnvio()",
                !guiaForanea.esAutoEnvio() && !guiaLocal.esAutoEnvio());
        verificar("Verifica calcularCostoTotal() (confirmando el cargo foraneo)",
                Math.abs(guiaLocal.calcularCostoTotal() - 120.0) < 1e-6
                && Math.abs(guiaForanea.calcularCostoTotal() - 200.0) < 1e-6);
        verificar("Verifica que cambiarDestinatario() rechace null",
                !guiaLocal.cambiarDestinatario(null));
        verificar("Verifica que cambiarDestinatario() acepta a otra persona (o a si misma)",
                guiaLocal.cambiarDestinatario(personaX) && guiaLocal.esAutoEnvio());
        guiaLocal.cambiarDestinatario(personaY);
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 4: SIMULACION INTEGRAL (CLONACION DE GUIA Y DEVOLUCION / RETORNO)
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO");
        // Modela e imprime en consola el siguiente escenario completo:
        // a) Persona X envia 'kitBase' a Persona Y (imprime la guia generada).
        Envio guia1 = new Envio(personaX, personaY, kitBase);
        System.out.println("\na) Guia generada (Persona X a Persona Y): ");
        System.out.println(guia1);
        // b) Persona X necesita enviar un segundo paquete ('otroPaquete') a la misma Persona Y
        //    clonando la guia anterior; verifica que conserva remitente y destinatario
        //    pero tiene el nuevo paquete y un nuevo folio consecutivo.
        Envio guia2 = new Envio(guia1, otroPaquete);
        System.out.println("\nb) Guia clonada (Con nuevo paquete): ");
        System.out.println(guia2);
        verificar("verifica que conserva remitente y destinatario pero tiene el nuevo paquete y un nuevo folio consecutivo",
                guia2.getRemitente() == personaX && guia2.getDestinatario() == personaY &&
                guia2.getPaquete() == otroPaquete && !guia2.getFolioGuia().equals(guia1.getFolioGuia()));
        // c) Persona Y solicita devolver el primer paquete a Persona X generando una guia de retorno;
        //    verifica con verificar(...) que en la guia de retorno el remitente es Y, el destinatario es X,
        //    el paquete es una copia independiente con prefijo "RET-" y cuenta con un nuevo folio consecutivo.
        //    Imprime la guia de retorno y el total acumulado de guias emitidas en el sistema.
        Envio guiaRetorno = guia1.generarGuiaRetorno();
        System.out.println("\nc) Guia retorno: ");
        System.out.println(guiaRetorno);
        verificar ("Verifica que en la guia de retorno el remitente es Y, el destinatario es X, el paquete es una copia" +
                "independiente con prefijo RET- y cuenta con un nuevo folio consecutivo",
                guiaRetorno.getRemitente() == personaY &&
                guiaRetorno.getDestinatario() == personaX &&
                guiaRetorno.getPaquete() != guia1.getPaquete() &&
                "RET-KIT-101".equals(guiaRetorno.getPaquete().getCodigoRastreo()) &&
                !guiaRetorno.getFolioGuia().equals(guia2.getFolioGuia()));
        System.out.println("Total acumulado de guias emitidas en el sistema: " + Envio.getContadorGuias());
        System.out.println("\n================================================================================");
        System.out.println("  RESUMEN DE PRUEBAS: " + pruebasExitosas + " / " + totalPruebas + " pruebas superadas con exito");
        System.out.println("================================================================================");
    }

    /**
     * Evalua una condicion booleana e imprime [OK] o [FALLO].
     * 
     * @param nombrePrueba Descripcion breve del caso evaluado.
     * @param condicion Resultado booleano esperado (true si paso).
     */
    private static void verificar(String nombrePrueba, boolean condicion) 
    {
        totalPruebas++;
        if (condicion) 
        {
        pruebasExitosas++;
        System.out.println("  [OK]    " + nombrePrueba);
        } 
        else 
        {
        System.out.println("  [FALLO] " + nombrePrueba);
        }
    }
}
