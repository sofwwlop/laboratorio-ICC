import java.util.Scanner;
public class PiInteractivo
{
	public static void main (String[] args)
	{
		Scanner entrada = new Scanner (System.in);

		int dardosLanzados= 0;
		int dardosDentro = 0;
		int contadorDardos = 0;
		boolean datoNoValido = true;

	    while (datoNoValido)
	    {
  	    System.out.print("\n Ingresa el número de dardos que quieres que sean lanzados: ");

	    if (entrada.hasNextInt())
	    {
	    	dardosLanzados = entrada.nextInt();
	    	if (dardosLanzados>0)
	    	{
	    		datoNoValido=false;
	    	}
	    	else 
	    	{
	    		System.out.println("Error: El número debe ser positivo y mayor que 0.");
	    	}
	    }
	    else
	   	{
	 		entrada.next();
    		System.out.println("Error: El número que ingresaste no es un entero.");
    	}
    	}

		while (dardosLanzados>contadorDardos)
		{
			//coordenadas
			double x = Math.random();
			double y = Math.random();
				if ((x * x + y * y )<=1.0)
				{
					dardosDentro++;
				}
				contadorDardos++;
		}
		double estimacionPi = 4.0*dardosDentro/dardosLanzados;
		System.out.printf(" Dardos totales: %d%nDardos dentro del circulo: %d%nAproximación de PI: %.6f%n",
		dardosLanzados,dardosDentro,estimacionPi);
		entrada.close();
	}
}