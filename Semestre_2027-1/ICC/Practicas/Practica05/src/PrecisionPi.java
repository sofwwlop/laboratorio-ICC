public class PrecisionPi
{
	public static void main (String[] args)
	{
		int dardosDentro = 0;
		int dardosTotales = 0;
		double estimacionPi = 0.0;
		double tolerancia = 0.001;
		while (Math.abs(estimacionPi-Math.PI)>=tolerancia)
		{
			//coordenadas
			double x = Math.random();
			double y = Math.random();
			dardosTotales++;
				if ((x * x + y * y )<=1.0)
				{
					dardosDentro++;
				}
		estimacionPi = 4.0*dardosDentro/dardosTotales;
		}
		System.out.printf(" Dardos necesitados: %d%nAproximación de PI: %.6f%n",
		dardosTotales,estimacionPi);
	}
}