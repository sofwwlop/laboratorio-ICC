/**
 * Modela una Guia de Envio posiciontal relacionando a una Persona remitente, 
 * una Persona destinatario y un objeto Paquete.
 * 
 * Cada guia recibe automaticamente un folio unico al momento de crearse
 * (compuesto por caracteres aleatorios y un numero consecutivo global).
 * 
 * @author Sofia Lopez Castro
 * @version 1.0
 */
public class Envio 
{

    // 1. ATRIBUTOS

    /** Cargo adicional fijo en pesos para envios foraneos (entre distintas ubicaciones). */
    public static final double CARGO_FORANEO = 80.0;
    private String folioGuia;
    private Persona remitente;
    private Persona destinatario;
    private Paquete paquete;
    //atributo para folio
    private static int contadorGuias = 0;

    // 2. CONSTRUCTORES 

    /**
     * Constructor principal para emitir una nueva guia de envio.
     * Genera automaticamente el folioGuia (2 o 3 letras/digitos aleatorios + consecutivo).
     * Valida que ninguna referencia recibida sea invalida; si se envia a la misma
     * persona se permite (envio personal o mudanza).
     * 
     * @param remitente Persona que envia el paquete.
     * @param destinatario Persona que recibe el paquete.
     * @param paquete Paquete fisico amparado por esta guia.
     */
    public Envio(Persona remitente, Persona destinatario, Paquete paquete) 
    {
        if (remitente == null)
        {
            this.remitente = new Persona();
        }
        else 
        {
            this.remitente = remitente;
        }
        if (destinatario == null)
        {
            this.destinatario = new Persona();
        }
        else
        {
            this.destinatario = destinatario;
        }
        if (paquete == null || !CotizadorEnvio.esPaqueteValido(paquete))
        {
            this.paquete = new Paquete();
        }
        else
        {
            this.paquete = paquete;
        }

        this.folioGuia = generarFolio();

    }

    /**
     * Constructor para copiar una guia existente cuando el mismo remitente envia
     * un nuevo paquete al mismo destinatario.
     * Conserva las referencias a remitente y destinatario de guiaBase, asocia el
     * nuevoPaquete y genera un NUEVO folioGuia consecutivo para esta guia.
     * 
     * @param guiaBase Guia original de la cual se toman remitente y destinatario.
     * @param nuevoPaquete El nuevo paquete que viajara bajo esta nueva guia.
     */
    public Envio(Envio guiaBase, Paquete nuevoPaquete) 
    {
        if (guiaBase == null)
        {
            this.remitente = new Persona();
            this.destinatario = new Persona();
        }
        else
        {
            this.remitente = guiaBase.remitente;
            this.destinatario = guiaBase.destinatario;
        }
        if (nuevoPaquete == null || !CotizadorEnvio.esPaqueteValido(nuevoPaquete))
        {
            this.paquete = new Paquete();
        }
        else
        {
            this.paquete = nuevoPaquete;
        }

        this.folioGuia = generarFolio();
    }

    // 3. METODOS DE ACCESO (GETTERS) Y CONSULTA DE GUIAS EMITIDAS
    //getters
    /** @return El folio unico generado para esta guia. */
    public String getFolioGuia() 
    {
        return this.folioGuia;
    }
    /** @return La persona remitente */
    public Persona getRemitente()
    {
        return this.remitente;
    }
    /** @return La persona destinataria */
    public Persona getDestinatario()
    {
        return this.destinatario;
    }
    /** @return El paquete */
    public Paquete getPaquete()
    {
        return this.paquete;
    }
    /** @return Total de guias creadas */
    public static int getContadorGuias()
    {
        return contadorGuias;
    }
    /** @return Metodo auxiliar */
    private String generarFolio() 
    {
        char letra1 = (char) ('A' + (int) (Math.random() * 26));
        char letra2 = (char) ('A' + (int) (Math.random() * 26));
        char letra3 = (char) ('A' + (int) (Math.random() * 26));

        contadorGuias++;
        return "GUIA-" + letra1 + letra2 + letra3 + "-" + contadorGuias;
    }

    // 4. METODOS DE OPERACION SOBRE LOS OBJETOS AGREGADOS  

    /**
     * Determina si el envio es foraneo verificando si el remitente y el destinatario
     * se encuentran en distinta ubicacion.
     * 
     * @return true si viaja entre distintas ubicaciones; false si es un envio local.
     */
    public boolean esEnvioForaneo() 
    {
        if (this.remitente.mismaUbicacionQue(destinatario))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * Determina si el remitente y el destinatario representan a la misma persona
     * (por ejemplo, un envio personal o mudanza).
     * 
     * @return true si remitente y destinatario son la misma persona; false en caso contrario.
     */
    public boolean esAutoEnvio() 
    {
        if (this.remitente.esLaMismaPersona(this.destinatario))
        {
            return true;
        }
        return false;
    }

    /**
     * Calcula el costo total del envio:
     * Obtiene la tarifa base del paquete y, si es un envio foraneo,
     * suma el cargo adicional correspondiente.
     * 
     * @return El costo total de la guia en pesos (MXN), o -1.0 si el paquete es invalido.
     */
    public double calcularCostoTotal() 
    {
        double tarifaBase = CotizadorEnvio.cotizarEnvio(this.paquete);
        if (tarifaBase < 0.0)
        {
            return -1.0;
        }
        else
        {
            if (esEnvioForaneo())
            {
                return tarifaBase+CARGO_FORANEO;
            }
            else
            {
                return tarifaBase;
            }
        }
    }

    /**
     * Redirige el envio a un nuevo destinatario antes de su despacho.
     * Verifica unicamente que nuevoDestinatario no sea null.
     * 
     * @param nuevoDestinatario Nueva persona destinataria.
     * @return true si el cambio fue valido y aplicado; false si nuevoDestinatario es null.
     */
    public boolean cambiarDestinatario(Persona nuevoDestinatario) 
    {
        if (nuevoDestinatario == null)
        {
            return false;
        }
        else
        {
            this.destinatario = nuevoDestinatario;
            return true;
        }
    }

    /**
     * Genera y devuelve una NUEVA guia de envio para devolver la mercancia al origen:
     * 1. Invierte los roles entre remitente y destinatario.
     * 2. Crea una copia independiente del paquete en memoria y actualiza su codigo
     *    de rastreo anteponiendo el prefijo "RET-".
     * 3. La nueva guia recibe automaticamente su propio folioGuia consecutivo.
     * 
     * @return Nuevo objeto Envio configurado para el retorno al remitente original.
     */
    public Envio generarGuiaRetorno() 
    {
        Paquete copiaPaquete = new Paquete(this.paquete);
        copiaPaquete.setCodigoRastreo("RET-" + copiaPaquete.getCodigoRastreo());
        return new Envio(this.destinatario, this.remitente, copiaPaquete);
    }

    /**
     * Emite el comprobante textual de la guia de envio delegando en toString()
     * de remitente, destinatario y paquete, e indicando el folio, tipo de ruta
     * (LOCAL o FORANEO) y el costo total.
     * 
     * @return Cadena con el formato completo de la guia de envio.
     */
    @Override
    public String toString() 
    {
        String ruta = "LOCAL";
        if (esEnvioForaneo())
        {
            ruta = "FORANEO";
        }
        return  "------------------------------------------\n" +
                "---- Comprobante ----\n" +
                "Remitente: " + this.remitente + "\n" +
                "Destinatario " + this.destinatario + "\n" +
                "Paquete: " + this.paquete + "\n" +
                "------------------------------------------\n" +
                "Folio: " + this.folioGuia + "\n" +
                "Tipo de ruta: " + ruta + "\n" +
                "Envio personal: " + esAutoEnvio() + "\n" +
                "Costo total: $" + String.format("%.2f", calcularCostoTotal()) + "\n" +
                "------------------------------------------\n";
    }
}
