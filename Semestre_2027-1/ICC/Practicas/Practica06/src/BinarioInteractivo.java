import java.util.Scanner;
public class BinarioInteractivo
{
	public static void main (String[] args)
	{
		Scanner entrada = new Scanner (System.in);
		char respuesta;

		do
		{
			int numero = 0;
			int cociente = 0;
			String valorBinario = "";
			boolean datoNoValido = true;

		    while (datoNoValido)
		    {
	  	    System.out.print("\n Ingresa el número que quieras convertir a binario: ");

		    if (entrada.hasNextInt())
		    {
		    	numero = entrada.nextInt();
		    	if (numero>=0)
		    	{
		    		datoNoValido=false;
		    	}
		    	else 
		    	{
		    		System.out.println("Error: El número debe ser positivo.");

		    	}
		    }

		    else
		   	{
		 		entrada.next();
	    		System.out.println("Error: El número que ingresaste no es un entero.");
	    	}
	  	  	}

	    	if (numero==0)
		    {
		    	valorBinario = "0"; //es un string
		   	}
		   	else
		   	{
		   		int num = numero;
				while (num > 0)
				{
						int residuo = num%2;
						cociente = num/2;
						valorBinario = residuo + valorBinario; 
						num = cociente;
				}
			}
			System.out.printf ("El número %d en binario es %s%n", numero, valorBinario);
			System.out.printf ("\n¿Quieres convertir otro númrero?(S/s para convertir o presiona cualquier tecla para salir): ", numero, valorBinario);
			respuesta = entrada.next().charAt(0);
		}
		while (respuesta == 'S' || respuesta == 's');
		System.out.println("\nHasta luegooo.");
		entrada.close();
	}	
}
