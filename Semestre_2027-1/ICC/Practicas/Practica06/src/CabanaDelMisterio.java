import java.util.Scanner;

public class CabanaDelMisterio
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner (System.in);

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
        int plazoMeses = 0;

        int operacionesEfectivas = 0;
        int erroresMenu = 0;
        boolean continuar = true;
        String motivoSalida = "";

        System.out.print("Ingresa el nombre completo del cliente: ");
        nombre = entrada.nextLine();

//condiciones de datos
        boolean tipoNoValido = true;
        while (tipoNoValido)
        {
            System.out.print("\n Ingresa el tipo de cliente (P, E, R): ");
            char cliente = entrada.next().charAt(0);
            entrada.nextLine();
            if (cliente == 'P' || cliente == 'p')
            {
                tipoCliente = preferente;
                tipoNoValido = false;
            }
            else if (cliente == 'E' || cliente == 'e')
            {
                tipoCliente = estandar;
                tipoNoValido = false;
            }
            else if (cliente == 'R' || cliente == 'r')
            {
                tipoCliente = riesgoso;
                tipoNoValido = false;
            }
            else
            {
                System.out.println("Error: El tipo de cliente debe ser P, E o R.");
            }
        }

        boolean capitalNoValido = true;
        while (capitalNoValido) 
        {
            System.out.print("Ingresa el capital de préstamo: ");
            if (entrada.hasNextInt()) 
            {
                precioLaptop = entrada.nextInt();
                entrada.nextLine();
                if (precioLaptop > 0) 
                {
                    capitalNoValido = false;
                }
                else 
                {
                    System.out.println("Error: El capital del préstamo debe ser mayor a 0.");
                }
            }
            else 
            {
                System.out.println("Error: El capital ingresado no es un número entero .");
                entrada.next();
                entrada.nextLine();
            }
        }

        boolean tasaNoValida = true;
        while (tasaNoValida) 
        {
            System.out.print("Ingresa la tasa anual base (%): ");
            if (entrada.hasNextInt()) 
            {
                tasaBase = entrada.nextInt();
                entrada.nextLine();
                if (tasaBase >= 0) 
                {
                    tasaNoValida = false;
                }
                else 
                {
                    System.out.println("Error: La tasa base debe ser mayor a 0 y NO negativa.");
                }
            }
            else 
            {
                System.out.println("Error: El tasa ingresada no es un número entero .");
                entrada.next();
                entrada.nextLine();
            }
        }

        boolean plazoNoValido = true;
        while (plazoNoValido) 
        {
            System.out.print("Ingresa el plazo en meses: ");
            if (entrada.hasNextInt()) 
            {
                plazoMeses = entrada.nextInt();
                entrada.nextLine();
                if (plazoMeses > 0) 
                {
                    plazoAños = plazoMeses / 12.0;
                    plazoNoValido = false;
                }
                else
                {
                    System.out.println("Error: El plazo debe ser mayor a 0.");
                }
            }
            else
            {
                System.out.println("Error: El plazo ingresado no es un número entero.");
                entrada.next();
                entrada.nextLine();
            }
        }

//clasificacion de clientes
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

//menu
        int opcion;

        do
        {
            System.out.println("\n---Sistema de préstamos de la cabaña del misterio---\nLas operaciones disponibles son"+
            "\n1) Cotizar con interes simple.\n2) Cotizar con interes compuesto.\n3) Comparar interes simple y compuesto."+
            "\n4) Cambiar el capital del prestamo.\n0) Salir.\n> Por favor, elige una opción:");

            if (entrada.hasNextInt())
            {
                opcion = entrada.nextInt();
                entrada.nextLine();

                if (opcion == 1)
                {
                    operacionesEfectivas++;  
                    double interesSimple = precioLaptop * (tasaAplicada / 100.0) * plazoAños;
                    double pagoTotal = precioLaptop + interesSimple;
                    System.out.printf ("%n<<<Opción 1: Cotización de interés simple>>> %n-Nombre: %s%n-Tipo de Cliente: %c%n"+
                    "-Capital de préstamo: %d%n-Tasa anual: %d%n-Plazo en meses:%d%n>Interés simple: %.2f%n>Total a pagar: %.2f%n",
                    nombre, tipoCliente, precioLaptop, tasaAplicada, plazoMeses, interesSimple, pagoTotal);
                }
                else if (opcion == 2)
                {
                    operacionesEfectivas++;
                    System.out.printf ("%n<<<Opción 2: Cotización de interés compuesto>>> %n-Nombre: %s%n-Tipo de Cliente: %c%n"+
                    "-Capital de préstamo: %d%n-Tasa anual: %d%n-Plazo en meses:%d%n", nombre, tipoCliente, precioLaptop, tasaAplicada, plazoMeses);
                    double tasaMensual = tasaAplicada / 100.0 / 12;
                    double deudaActual = precioLaptop;
                    for (int mes = 1; mes <= plazoMeses; mes++)
                    {
                        deudaActual = deudaActual * (1 + tasaMensual);
                        System.out.printf("Mes %d= %.2f%n", mes, deudaActual);
                    }
                    double interesCompuesto = deudaActual - precioLaptop;
                    double saldoFinal = deudaActual; 
                    System.out.printf (">Interes compuesto= %.2f%n>Total a pagar= %.2f%n", interesCompuesto, saldoFinal);
                }
                else if (opcion == 3)
                {
                    operacionesEfectivas++;
                    double interesSimple = precioLaptop * (tasaAplicada / 100.0) * plazoAños;
                    double tasaMensual = tasaAplicada / 100.0 / 12;
                    double saldoFinal = precioLaptop * Math.pow(1 + tasaMensual, plazoMeses);
                    double interesCompuesto = saldoFinal - precioLaptop;

                    System.out.printf("%n<<<Opción 3: Comparación de intereses>>>%nInterés simple: $%.2f%n"+
                    "Interés compuesto: $%.2f%n", interesSimple, interesCompuesto);  
                    if (interesCompuesto > interesSimple)
                    {
                        double diferencia = interesCompuesto - interesSimple;
                        System.out.printf("El interés compuesto es mayor por $%.2f%n", diferencia);
                    }  
                    else if (interesSimple > interesCompuesto) 
                    {
                        double diferencia = interesSimple - interesCompuesto;
                        System.out.printf("El interés simple es mayor por $%.2f%n", diferencia);
                    } 
                    else 
                    {
                        System.out.println("Ambos intereses son iguales.");
                    }                  
                }
                else if (opcion == 4)
                { 
                    operacionesEfectivas++;                        
                    boolean nuevoCapitalNoValido = true;
                    while (nuevoCapitalNoValido) 
                    {
                        System.out.print("\nIngresa el nuevo capital del préstamo: ");
                        if (entrada.hasNextInt()) 
                        {
                            int nuevoPrecio = entrada.nextInt();
                            entrada.nextLine();
                            if (nuevoPrecio > 0) 
                            {
                                precioLaptop = nuevoPrecio;
                                nuevoCapitalNoValido = false;
                                System.out.printf("Capital actualizado a: $%d%n", precioLaptop);
                            } 
                            else 
                            {
                                System.out.println("Error: El capital del préstamo debe ser mayor a 0.");
                            }
                        } 
                        else 
                        {
                            System.out.println("Error: El capital ingresado no es un entero.");
                            entrada.next();
                            entrada.nextLine();
                        }
                    }
                }
                else if (opcion == 0)
                {
                    motivoSalida = "El usuario eligió la opción 0 (Salir).";
                    continuar = false;
                }
                else
                {
                    erroresMenu++;
                    System.out.println("Error: Opción no disponible, elige una opcion del 0 al 4.");
                }
            }
            else 
            {
                erroresMenu++;
                System.out.println("Error: Debes ingresar un número entero correspondiente a una opción del menú.");
                entrada.next();
                entrada.nextLine();
            }

//intentos limites
            if (continuar)
            {
                if (operacionesEfectivas >= 5)
                {
                    System.out.println("\nSe alcanzó el límite de 5 operaciones efectivas.");
                    motivoSalida = "Se alcanzó el límite de 5 operaciones efectivas.";
                    continuar = false;
                }
                else if (erroresMenu >= 3)
                {
                    System.out.println("\nSe alcanzó el límite de 3 errores en el menú.");
                    motivoSalida = "Se alcanzó el límite de 3 errores en el menú.";
                    continuar = false;
                }
            }

        } while (continuar); 
            System.out.println("\n¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
            System.out.println("       RESUMEN FINAL DEL PRÉSTAMO        ");
            System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
            System.out.println("Operaciones efectivas realizadas: " + operacionesEfectivas);
            System.out.printf("Nombre del cliente: %s%nOperaciones efectivas realizadas: %d%nErrores cometidos en el menú: %d%n"+
            "Capital final del préstamo: $%.2f%nMotivo de término: %s%n",nombre, operacionesEfectivas, erroresMenu, (double) precioLaptop, motivoSalida);
            System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
            System.out.println("chau chau");

        entrada.close();
    }
}