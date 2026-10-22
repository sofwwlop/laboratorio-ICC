public class EstimacionPi
{
	public static void main (String[] args)
	{
		int dardosTotales = 1000000;
		int dardosDentro = 0;
		int contadorDardos = 0;
		while (dardosTotales>contadorDardos)
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
		double estimacionPi = 4.0*dardosDentro/dardosTotales;
		System.out.printf(" Dardos totales: %d%nDardos dentro del circulo: %d%nAproximación de PI: %.6f%n",
		dardosTotales,dardosDentro,estimacionPi);
	}
}