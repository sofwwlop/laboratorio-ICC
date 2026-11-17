/**
 * Clase que modela un paquete para una empresa de envios postales y paqueteria.
 * Permite registrar sus dimensiones espaciales, peso fisico y valor declarado,
 * asi como calcular su peso volumetrico y determinar el peso cobrable final.
 * 
 * @author Sofía López Castro
 * @version 1.0
 */
public class Paquete 
{
    // *** ATRIBUTOS ***
    private double ESTANDAR_COMERCIAL = 5000.0;
    //mi propuesta personal
    private double VALOR_PARA_DESCUENTO = 5000.0;
    private double DESCUENTO = 399.0;

    private String codigoAlfanumerico;
    private double peso;
    private double alto;
    private double ancho;
    private double largo;
    private double valorMonetario;

    // *** CONSTRUCTORES ***
    //Constructor por defecto
    public Paquete ()
    {
        this.codigoAlfanumerico = "";
        this.peso = 0.0;
        this.alto = 0.0;
        this.ancho = 0.0;
        this.largo = 0.0;
        this.valorMonetario = 0.0;
    }
    /**
     * Constructor parametrizado que crea un paquete con sus datos completos,
     * validando que las dimensiones fisicas sean estrictamente positivas.
     * 
     * @param codigoAlfanumerico Identificador unico del paquete.
     * @param peso Peso fisico real del paquete en kilogramos.
     * @param alto Altura del paquete en centimetros (debe ser mayor a 0).
     * @param ancho Anchura del paquete en centimetros (debe ser mayor a 0).
     * @param largo Longitud del paquete en centimetros (debe ser mayor a 0).
     * @param valorMonetario Valor comercial declarado del contenido en pesos.
     */
    //Constructor con parametros
    public Paquete (String codigoAlfanumerico, double peso, double alto, double ancho, double largo, double valorMonetario)
    {
        this.codigoAlfanumerico = codigoAlfanumerico;
        this.peso = peso;         
        this.valorMonetario = valorMonetario;
    //Asegurar que las dimensiones sean validas
        if (alto>0)
        {
            this.alto = alto;
        }
        else 
        {
            System.out.print("La medida introducida no es valida");
        }
        if (ancho>0)
        {
            this.ancho = ancho;
        }
        else 
        {
            System.out.print("La medida introducida no es valida");
        }
        if (largo>0)
        {
            this.largo = largo;
        }
        else 
        {
            System.out.print("La medida introducida no es valida");
        }
    }

    // *** METODOS DE ACCESO Y ASIGNACION ***
    /**
     * Obtiene el codigo alfanumerico identificador del paquete.
     * 
     * @return Cadena con el codigo alfanumerico del paquete.
     */
    public String getCodigoAlfanumerico ()
    {
        return codigoAlfanumerico;
    }
    /**
     * Obtiene el peso fisico registrado del paquete.
     * 
     * @return Peso fisico en kilogramos.
     */
    public double getPeso ()
    {
        return peso;
    }
    /**
     * Obtiene la altura del paquete.
     * 
     * @return Alto en centimetros.
     */
    public double getAlto ()
    {
        return alto;
    }
    /**
     * Obtiene el ancho del paquete.
     * 
     * @return Ancho en centimetros.
     */
    public double getAncho ()
    {
        return ancho;
    }
    /**
     * Obtiene el largo del paquete.
     * 
     * @return Largo en centimetros.
     */
    public double getLargo ()
    {
        return largo;
    }
    /**
     * Obtiene el valor monetario declarado del paquete.
     * 
     * @return Valor declarado en pesos.
     */
    public double getValorMonetario ()
    {
        return valorMonetario;
    }
    /**
     * Asigna un nuevo codigo alfanumerico al paquete.
     * 
     * @param codigoAlfanumerico Nuevo identificador del paquete.
     */
    public void setCodigoAlfanumerico (String codigoAlfanumerico)
    {
        this.codigoAlfanumerico = codigoAlfanumerico;
    }
    /**
     * Actualiza el peso fisico del paquete siempre que sea mayor a cero.
     * 
     * @param peso Nuevo peso en kilogramos.
     */
    public void setPeso(double peso)
    {
        if (peso > 0)
        {
            this.peso = peso;
        }
    }
    /**
     * Actualiza la altura del paquete verificando que sea un valor positivo.
     * 
     * @param alto Nueva altura en centimetros.
     */
    public void setAlto(double alto)
    {
        if (alto > 0)
        {
            this.alto = alto;
        }
        else
        {
            System.out.println("La medida introducida no es valida.");
        }
    }
    /**
     * Actualiza el ancho del paquete verificando que sea un valor positivo.
     * 
     * @param ancho Nuevo ancho en centimetros.
     */
    public void setAncho(double ancho)
    {
        if (ancho > 0)
        {
            this.ancho = ancho;
        }
        else
        {
            System.out.println("La medida introducida no es valida.");
        }
    }
    /**
     * Actualiza el largo del paquete verificando que sea un valor positivo.
     * 
     * @param largo Nuevo largo en centimetros.
     */
    public void setLargo(double largo)
    {
        if (largo > 0)
        {
            this.largo = largo;
        }
        else
        {
            System.out.println("La medida introducida no es valida.");
        }
    }
    /**
     * Actualiza el valor monetario declarado del paquete si no es negativo.
     * 
     * @param valorMonetario Nuevo valor declarado en pesos.
     */
    public void setValorMonetario(double valorMonetario)
    {
        if (valorMonetario >= 0)
        {
            this.valorMonetario = valorMonetario;
        }
    }

    // *** METODOS CALCULADORES BASE ***

    /**
     * Calcula el peso volumetrico del paquete segun el estandar comercial (IATA):
     * (largo * ancho * alto) / 5000.
     * 
     * @return El peso volumetrico equivalente en kilogramos.
     */
    public double calculaPesoVolumetrico() 
    {
        return (largo*ancho*alto)/ESTANDAR_COMERCIAL;
    }
    /**
     * Determina el peso cobrable final para efectos de tarificacion postal,
     * el cual corresponde al valor maximo entre el peso fisico y el volumetrico.
     * 
     * @return El mayor entre el peso real y el peso volumetrico.
     */
    public double obtenerPesoCobrable() 
    {
        double pesoVolumetrico = calculaPesoVolumetrico();
        if (this.peso > pesoVolumetrico)
        {
            return this.peso;
        }
        else 
        {
            return pesoVolumetrico;
        }
    }

    // *** PROPUESTA PERSONAL ***
    /**
     * Calcula un descuento promocional fijo de $399.00 pesos cuando el valor
     * declarado del paquete supera los $5,000.00 pesos.
     * 
     * @return Monto del descuento aplicable en pesos ($399.00 o $0.00).
     */
    public double calcularDescuentoAltoValor()
    {
        if (this.valorMonetario > VALOR_PARA_DESCUENTO)
        {
            return DESCUENTO;
        }
        else
        {
            return 0.0;
        }
    }

}