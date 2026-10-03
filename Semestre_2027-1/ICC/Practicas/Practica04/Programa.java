public class Programa{	
	public static void main(String[] args) {
	//Establezco la variable para una cadena de texto
	String producto = "Laptop para la carrera";
	//Establezco una variable entera
	int precio = 15000;
	// Establezco una variable entera
	int descuento = 3000;
	//Establezco una variable con decimal
	double meses = 18.0;
	//Imprime el texto entre comilllas
	System.out.println("=== Ficha de compra ===");
	//Imprime el texto y el contenido de la variable producto
	System.out.println("- Producto : " + producto);	
	//Imprime el texto y el contenido de la variable precio menos descuento
	System.out.println("- Precio con descuento : " + (precio - descuento));
	//Imprime el texto y el contenido de la variable meses entre 12.0
	System.out.println("- Plazo de pago en anios : " + (meses / 12.0));
	//Imprime el texto y el contenido de la variable precio menos descuento y eso entre meses
	System.out.println("- Pago mensual : " + ((precio - descuento) / meses));
	//Imprime el texto entre comillas
	System.out.println("=== Fin de la ficha ===");

	}
}