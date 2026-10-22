public class CotizadorPines
{
public static void main(String[] args)
{
double plazoAños = 1.75; 
int precioLaptop = 12899; 
//Clasificación de clientes
String nombre = "Robbie Valentino";
char preferente = 'P';
char estandar = 'E';
char riesgoso = 'R';
char tipoCliente = 'E';
int tasaBase = 15;

String clasificacion = "";
int tasaAplicada = 0;

	if (precioLaptop <= 0)
    {
        System.out.println("Error: El monto del préstamo debe ser mayor a 0.");
        return;
    }
	if (plazoAños <= 0)
    {
        System.out.println("Error: El plazo debe ser mayor a 0.");
        return;
    }
	if (tasaBase <= 0)
    {
        System.out.println("Error: La tasa base debe ser mayor a 0.");
        return;
    }
    if (tipoCliente != preferente && tipoCliente != estandar && tipoCliente != riesgoso)
    {
        System.out.println("Error: El tipo de cliente debe ser P, E o R.");
        return;
    }


	if (tipoCliente == preferente)
	{
		clasificacion = "Preferente";
	    tasaAplicada = tasaBase - 2;
	}
	else if (tipoCliente == estandar)
	{
		clasificacion = "Estandar";
	    tasaAplicada = tasaBase;
	}
	else
	{
		clasificacion = "Riesgoso";
	    tasaAplicada = tasaBase + 3;
	}
	int plazoMeses = (int) Math.round(plazoAños * 12);
    double interesSimple = precioLaptop * (tasaAplicada / 100.0) * plazoAños;
    double pagoTotal = precioLaptop + interesSimple;
	double pagoMes = pagoTotal / plazoMeses;
    System.out.printf("--Cotizador de laptops Sr. Pines--%nCliente: %s%nClasificación: %s%nTasa aplicada: %d%%%n"
    + "Préstamo: $%.2f%nMeses de pago: %d%n Interés simple: $%.2f%nTotal con interés simple: $%.2f%nPago por mes: $%.2f%n",
    nombre, clasificacion, tasaAplicada,(double) precioLaptop, plazoMeses, interesSimple, pagoTotal, pagoMes);

    double tasaMensual = tasaAplicada / 100.0 / 12;
    double deudaActual = precioLaptop;

    System.out.printf("%nInterés compuesto:%n");
    for (int mes = 1; mes <= plazoMeses; mes++)
    {
        deudaActual = deudaActual * (1 + tasaMensual);
        System.out.printf("En el mes %d se tiene una deuda de %.2f%n", mes, deudaActual);
    }
    double saldoFinal = precioLaptop * Math.pow(1 + tasaMensual, plazoMeses);
    double interesCompuesto = deudaActual - precioLaptop;

    System.out.printf("%nTotal con interés compuesto: $%.2f%n Total con interés compuesto: $%.2f%n"+
    "Interés compuesto: $%.2f%n", deudaActual, saldoFinal, interesCompuesto);
}
}