public class Cotizador 
{
public static void main(String[] args)
{
double plazoAños = 1.75; //%f
int precioLaptop = 12899; //%d
double interes = precioLaptop*(15.0/100)*plazoAños; //%f
String nombre = "Robbie Valentino"; //%s
double pagoTotal = precioLaptop + interes; //%f
double pagoMes = pagoTotal/(plazoAños*12); //%f
//Clasificación de clientes
String P = "Preferente"; //%s
String E = "Estándar"; //%s
String R = "Riesgoso"; //%s
System.out.printf("--Cotizador de laptops Sr.Pines--%n Cliente: %s%n Clasificación: %s%n Adeudo:"+
"%.2f%n Ganancia de intereses: %.2f%n Ganancia por mes: %.2f%n", nombre, E, pagoTotal, interes, pagoMes);
}
}