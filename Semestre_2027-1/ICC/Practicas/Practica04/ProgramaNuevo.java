public class ProgramaNuevo{	
	public static void main(String[] args) {
	
	String producto = "Laptop para la carrera";	//%s
	int precio = 15000;	//%d
	int descuento = 3000;  //%d
	double meses = 18.0;  //%f
	int precioFinal = precio - descuento;  //%d
	double plazoPago = meses / 12.0;  //%f
	double pagoMensual = (precio - descuento) / meses;  //%f
//Pongo el textp y sus % correspondientes, despues pongo las  variables
System.out.printf("=== Ficha de compra ===%n - Producto: %s%n- Precio con descuento: %d%n- Plazo de pago en anios: %.1f%n- Pago mensual: %.2f%n=== Fin de la ficha ===%n", producto, precioFinal, plazoPago, pagoMensual);

	}
}