/**
 * Representa a una persona registrada en el sistema postal, la cual puede actuar
 * como remitente o como destinatario dentro de una guia de envio.
 *  * 
 * @author Sofia Lopez Castro
 * @version 1.0
 */
public class Persona 
{


    // 1. ATRIBUTOS

    /*
     PARTE 2 (DISENO ABIERTO):
     Define los atributos privados, constructores, getters/setters y metodos necesarios
     para modelar a una persona considerando al menos:
     - Un identificador corto unico
     - Nombre completo.
     - Ubicacion (ciudad, alcaldia o codigo postal) para distinguir envios locales de foraneos.
     */

    // POR HACER: Declara los atributos que consideres necesarios
    // para representar a la persona (identificador unico, nombre, ubicacion, etc.).
    private String nombre;
    private String id;
    private String ubicacion;

    // 2. CONSTRUCTORES 

    // POR HACER: Implementa al menos un constructor por omision 
    public Persona ()
    {
        
        this.nombre = "Sofia Lopez Castro";
        this.id = "PER-00";
        this.ubicacion = "44800";
    }
    /**
    * Constructor con parametros (aplicando validaciones basicas para evitar cadenas nulas o vacias).
    *
    * @param nombre Nombre completo de la persona
    * @param id Identificador unico de la persona
    * @param ubicacion Codigo postal de la persona
    */
    public Persona (String nombre, String id, String ubicacion)
    {
        this.nombre = (nombre != null && !nombre.equals("")) ? nombre : "SIN NOMBRE";
        this.id = (id != null && !id.equals("")) ? id : "SIN IDENTIFICADOR";
        this.ubicacion = (ubicacion != null && !ubicacion.equals("")) ? ubicacion : "SIN CODIGO POSTAL";

    }   

    // 3. GETTERS, SETTERS Y COLABORACION 
    //getters
    /** @return El nombre completo de la persona */
    public String getNombre ()
    {
        return nombre;
    }
    /** @return El identificador unico de la persona */
    public String getId ()
    {
        return id;
    }
    /** @return El codigo postal de la persona */
    public String getUbicacion ()
    {
        return ubicacion;
    }

    //setters
    /** @param nombre El nuevo nombre (completo) de la persona */
    public void setNombre(String nombre) 
    {
        if (nombre != null && !nombre.equals("")) 
        {
            this.nombre = nombre;
        }
    }
    /** @param id El nuevo identificador de la persona. */
    public void setId(String id) 
    {
        if (id != null && !id.equals("")) 
        {
            this.id = id;
        }
    }
    /** @param ubicacion El nuevo codigo postal de la persona */
    public void setUbicacion(String ubicacion) 
    {
        if (ubicacion != null && !ubicacion.equals("")) 
        {
            this.ubicacion = ubicacion;
        }
    }
    /**
     * Determina si esta persona se encuentra en la misma ubicacion (ciudad o codigo postal)
     * que otra persona recibida como parametro, para saber si un envio entre ambas
     * es local o foraneo.
     * 
     * @param otra La otra persona con quien comparar la ubicacion.
     * @return true si otra no es null y ambas comparten la misma ubicacion; false en caso contrario.
     */
    public boolean mismaUbicacionQue(Persona otra) 
    {
        if (otra == null)
        {
            return false;
        }
        return this.ubicacion.equalsIgnoreCase(otra.ubicacion);
    }

    /**
     * Determina si este objeto Persona y el recibido como parametro representan
     * a la misma persona comparando su identificador unico.
     * 
     * @param otra La otra persona a comparar.
     * @return true si otra no es null y ambas tienen el mismo identificador; false en caso contrario.
     */
    public boolean esLaMismaPersona(Persona otra) 
    {
        if (otra == null)
        {
            return false;
        }
        return this.id.equals(otra.id);    
    }

    // 4. REPRESENTACION TEXTUAL

    /**
     * Devuelve una representacion legible de la persona con sus datos principales.
     * 
     * @return Cadena con el identificador, nombre y ubicacion de la persona.
     */
    public String toString() 
    {
        return  "==== Datos de la persona ====\n" +
                "Nombre: " + this.nombre + "\n" +
                "ID: " + this.id + "\n" +
                "Ubicacion: " + this.ubicacion;
    }
}
