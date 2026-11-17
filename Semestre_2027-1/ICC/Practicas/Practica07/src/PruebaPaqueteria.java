/**
 * Programa de prueba para verificar el correcto funcionamiento de las clases
 * {@link Paquete} y {@link CotizadorEnvio}.
 * 
 * @author Sofia Lopez Castro
 * @version 1.0
 */
public class PruebaPaqueteria {
    /**
     * Punto de entrada principal que ejecuta los casos de prueba unitarios
     * para validar calculos de peso, cotizacion, seguro y descuentos.
     * 
     * @param args Argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("  PRUEBAS DEL SISTEMA DE ENVIOS POSTALES (PRACTICA 7) ");
        System.out.println("======================================================\n");

        // ---------------------------------------------------------------------
        // CASO 1: Paquete estandar pequeno (peso fisico domina)
        // Datos requeridos: codigo "PK-001", peso 3.5 kg, dimensiones 20x15x10 cm,
        // valor declarado $800.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 1: Paquete pequeno estandar ---");
        Paquete p1 = new Paquete("PK-001", 3.5, 20.0, 15.0, 10.0, 800.0);
        mostrarDetallePaquete(p1);
        System.out.println("Es valido?: " + CotizadorEnvio.esPaqueteValido(p1));
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $120.00)\n", CotizadorEnvio.cotizarEnvio(p1));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p1));
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 2: Paquete liviano pero voluminoso (peso volumetrico domina)
        // Datos requeridos: codigo "PK-002", peso 2.0 kg, dimensiones 50x40x50 cm,
        // valor declarado $1500.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 2: Paquete voluminoso (volumen predomina) ---");
        Paquete p2 = new Paquete("PK-002", 2.0, 50.0, 40.0, 50.0, 1500.0);
        mostrarDetallePaquete(p2);
        if (CotizadorEnvio.esPaqueteValido(p2)) {
            System.out.printf("Peso volumetrico calculado: %.2f kg\n", p2.calculaPesoVolumetrico());
            System.out.printf("Peso cobrable final: %.2f kg\n", p2.obtenerPesoCobrable());
        }
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $425.00)\n", CotizadorEnvio.cotizarEnvio(p2));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p2));
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 3: Paquete de alto valor comercial (requiere seguro por monto)
        // Datos requeridos: codigo "PK-003", peso 4.0 kg, dimensiones 30x25x20 cm,
        // valor declarado $6500.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 3: Paquete de alto valor monetario ---");
        Paquete p3 = new Paquete("PK-003", 4.0, 30.0, 25.0, 20.0, 6500.0);
        mostrarDetallePaquete(p3);
        System.out.printf("Costo de envio: $%.2f\n", CotizadorEnvio.cotizarEnvio(p3));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p3) + " (Esperado: true)");
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 4: Paquete sobredimensionado (arista > 60 cm o suma > 150 cm)
        // Datos requeridos: codigo "PK-004", peso 5.0 kg, dimensiones 70x30x20 cm,
        // valor declarado $1200.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 4: Paquete sobredimensionado ---");
        Paquete p4 = new Paquete("PK-004", 5.0, 70.0, 30.0, 20.0, 1200.0);
        mostrarDetallePaquete(p4);
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p4) + " (Esperado: true por dimensiones)");
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 5: Validacion de referencia nula (null)
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 5: Validacion de referencia nula (null) ---");
        Paquete pNulo = null;
        System.out.println("Es valido un paquete null?: " + CotizadorEnvio.esPaqueteValido(pNulo) + " (Esperado: false)");
        System.out.printf("Cotizacion de un paquete null: $%.2f (Esperado: -1.00)\n", CotizadorEnvio.cotizarEnvio(pNulo));
        System.out.println("Requiere seguro un paquete null?: " + CotizadorEnvio.requiereSeguro(pNulo) + " (Esperado: false)");
        System.out.println();

        // =====================================================================
        // CASO 6: PRUEBAS DE TU METODO PERSONAL (PARTE 2)
        // =====================================================================
        System.out.println("======================================================");
        System.out.println("        PRUEBAS DE TU PROPUESTA PERSONAL              ");
        System.out.println("======================================================");

        // Prueba en la que no se aplica descuento
        Paquete pSinDescuento = new Paquete("PK-DESC-1", 20.0, 30.0, 30.0, 30.0, 2000.0);
        System.out.println("--- Prueba 1: Paquete con valor estandar ($2,000.00) ---");
        mostrarDetallePaquete(pSinDescuento);
        System.out.printf("Descuento aplicado: $%.2f (Esperado: $0.00)\n", pSinDescuento.calcularDescuentoAltoValor());
        System.out.printf("Costo de envio con descuento: $%.2f\n", CotizadorEnvio.cotizarEnvio(pSinDescuento) - pSinDescuento.calcularDescuentoAltoValor());
        System.out.println();

        // Prueba en la que se aplica descuento
        Paquete pConDescuento = new Paquete("PK-DESC-2", 20.0, 30.0, 30.0, 30.0, 6500.0);
        System.out.println("--- Prueba 2: Paquete con valor alto ($6,500.00) ---");
        mostrarDetallePaquete(pConDescuento);
        System.out.printf("Descuento aplicado: $%.2f (Esperado: $399.00)\n", pConDescuento.calcularDescuentoAltoValor());
        System.out.printf("Costo de envio con descuento: $%.2f\n", CotizadorEnvio.cotizarEnvio(pConDescuento) - pConDescuento.calcularDescuentoAltoValor());
        System.out.println();
    }

    /**
     * Metodo auxiliar para imprimir en consola los datos basicos de un paquete.
     * Utiliza los metodos de acceso (getters) implementados en la clase Paquete.
     * 
     * @param p Paquete a imprimir.
     */
    private static void mostrarDetallePaquete(Paquete p) {
        if (!CotizadorEnvio.esPaqueteValido(p)) {
            System.out.println("  [Paquete no valido o no instanciado]");
            return;
        }
        System.out.println("  [Codigo: " + p.getCodigoAlfanumerico() + 
                           " | Medidas: " + p.getAlto() + "x" + p.getAncho() + "x" + p.getLargo() + " cm" +
                           " | Peso: " + p.getPeso() + " kg" +
                           " | Valor Declarado: $" + p.getValorMonetario() + "]");
    }
}