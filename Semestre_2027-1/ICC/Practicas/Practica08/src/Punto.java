/**
 * Modela un punto en el plano cartesiano bidimensional (2D).
 * 
 * @author [Tu Nombre Completo]
 * @version 1.0
 */
public class Punto {

    // Practica 8 (Mini-Lab): Metodos, Mensajes y Objetos como Parametros.
    // Completa las partes marcados con comentarios 'POR HACER'.

    // ATRIBUTOS PRIVADOS
    private double x;
    private double y;

    // CONSTRUCTORES
    public Punto() 
    {
        this.x = 0.0;
        this.y = 0.0;
    }

    /** 
     * @param x Coordenada en el eje X.
     * @param y Coordenada en el eje Y.
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // METODOS DE CONSULTA Y ASIGNACION (GETTERS Y SETTERS)
    // get
    public double getX ()
    {
        return x;
    }
    public double getY ()
    {
        return y;
    }
    //set
    public void setX ()
    {
        this.x = x;
    }
    public void setY ()
    {
        this.y = y;
    }

    // METODOS CALCULADORES [ OPERACIONES GEOMETRICAS ]
    // =========================================================================

    /**
     * Desplaza el punto sumando desplazamientos (deltas) a sus coordenadas actuales.
     * 
     * @param deltaX Desplazamiento horizontal.
     * @param deltaY Desplazamiento vertical.
     */
    public void desplazar(double deltaX, double deltaY) 
    {
        this.x += deltaXx;
        this.y += deltaY;
    }

    /**
     * Calcula la distancia euclidiana entre este punto y otro punto recibido.
     * Formula: sqrt((x2 - x1)^2 + (y2 - y1)^2)
     * 
     * @param otroPunto El punto destino respecto al cual se calculara la distancia.
     * @return La distancia euclidiana entre ambos puntos. Si 'otroPunto' es null, regresa -1.0.
     */
    public double distancia(Punto otroPunto) 
    {
        if (otroPunto == null)
        {
            return -1.0;
        }
        return Math.sqrt((otroPunto.x - this.x) * (otroPunto.x - this.x) + (otroPunto.y - this.y) * (otroPunto.y - this.y));
    }

    /**
     * Calcula y retorna el punto medio entre este punto y otro punto recibido.
     * Formula de coordenadas medias: xm = (x1 + x2) / 2, ym = (y1 + y2) / 2.
     * 
     * @param otro El otro punto para calcular el punto medio.
     * @return Una nueva instancia de Punto situada en las coordenadas medias. Si 'otro' es null, regresa null.
     */
    public Punto puntoMedio(Punto otro) 
    {
        if (otro == null)
        {
            return null;
        }
        xm = (punto.x + this.x)/2.0;
        ym = (punto.y + this.y)/2.0;
        return new Punto(xm, ym);
    }

    /**
     * Determina el cuadrante del plano cartesiano en el que se ubica el punto.
     * 
     * @return 1 (I Cuadrante: x &gt; 0, y &gt; 0),
     *         2 (II Cuadrante: x &lt; 0, y &gt; 0),
     *         3 (III Cuadrante: x &lt; 0, y &lt; 0),
     *         4 (IV Cuadrante: x &gt; 0, y &lt; 0),
     *         o 0 si se ubica sobre alguno de los ejes o en el origen.
     */
    public int cuadrante() 
    {
        if (this.x > 0 && this.y > 0)
        {
            return 1;
        }
        else if(this.x < 0 && this.y > 0)
        {
            return 2;
        }
        else if(this.x < 0 && this.y < 0)
        {
            return 3;
        }
        else if(this.x > 0 && this.y < 0)
        {
            return 4;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Determina si este punto y otros dos puntos recibidos son colineales
     * (es decir, si los tres puntos pasan sobre la misma linea recta).
     * 
     * @param p2 Segundo punto a evaluar.
     * @param p3 Tercer punto a evaluar.
     * @return true si los tres puntos estan alineados; false en caso contrario (o si alguno es null).
     */
    public boolean estanAlineados(Punto p2, Punto p3) {
        // POR HACER: Valida que p2 y p3 no sean null.
        // Evalua la condicion de colinealidad
    }

    /**
     * Representacion textual del punto en formato estandar de par ordenado: (x, y).
     * 
     * @return Cadena con el formato "(x, y)".
     */
    public String toString() {
    }

    /**
     * Compara si este punto es equivalente a otro objeto recibido.
     * Dos puntos se consideran iguales si la distancia entre ellos o la diferencia absoluta
     * de sus coordenadas es menor a una tolerancia pequena (ej. 1e-6).
     * 
     * @param obj El objeto a comparar.
     * @return true si el objeto es un Punto con coordenadas equivalentes; false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        // POR HACER: Verifica si obj es null o si no es una instancia de Punto.
        // Compara por distancia o diferencia absoluta de coordenadas con tolerancia.
    }
}
