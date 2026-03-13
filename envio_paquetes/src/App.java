import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class App {

    static Scanner sc = new Scanner(System.in);
    static int peso;
    static int distancia;
    static double precioXpeso;
    static double precioXdistancia;
    static double impuesto;
    static double total;
    static boolean repetir = true;

    public static void main(String[] args) throws Exception {

        //Mensaje de bienvenida
        bienvenida();

        //Ciclo Do - While, para poder hacer la consulta un numeor indefinido de veces
        do{

            peso = peso_producto(peso);
            distancia = distancia_producto(distancia);

            //Verifica si el peso y la distancia que el usuario ingreso es mayor a 0, para ejecutar el programa
            if (peso >= 0 && distancia >= 0){
                precioXpeso = calculo_precioXpeso(precioXpeso);
                precioXdistancia = calculo_precioXdistancia(precioXdistancia);
                impuesto = calculo_impuesto(impuesto);
                total = calculo_total(total);
                resumen();

            //Mensaje de error, si el peso o la distancia es menor a 0
            }else {
                System.out.println("\nError, el peso y la distancia deben ser mayor a 0.");
            }

            //Verifica si el usuario quiere repetir el programa
            repetir = opcion_repetir(repetir);

        }while(repetir == true);

    }

    public static void bienvenida() {
        
        //Mensaje de bienvenida
        System.out.println("============================================");
        System.out.println("BIENVENIDO AL SISTEMA DE ENVIO DE PAQUETES");
        System.out.println("============================================");

    }

    public static int peso_producto(int peso_producto) {

        //Solicita al usuario la distancia del envio 
        System.out.print("\nDigite el peso en KG de su envio: ");
        int peso = sc.nextInt();
        sc.nextLine();
        return peso;
        
    }

    public static int distancia_producto(int distancia_producto) {

        //Solicita al usuario la distancia del envio 
        System.out.print("Digite la distancia en KM de su envio: ");
        int distancia = sc.nextInt();
        sc.nextLine();
        return distancia;
        
    }

    public static double calculo_precioXpeso (double precioXpeso) {

        //Calculo del precio por peso, segun la condición
        if(peso == 0 && peso == 1){
            precioXpeso = 5000;

        }else if(peso > 1 && peso <= 5){
            precioXpeso = 10000;

        }else {
            precioXpeso = 15000;

        }
        return precioXpeso;
        
    }

    public static double calculo_precioXdistancia (double precioXdistancia) {

        //Calculo del precio por distancia, segun la condición
        if(distancia >= 0 && distancia <= 50){
            precioXdistancia = 3000;

        }else if(distancia > 50 && distancia <= 200){
            precioXdistancia = 7000;

        }else {
            precioXdistancia = 12000;

        }
        return precioXdistancia;
        
    }
        
    public static double calculo_impuesto(double calculo_impuesto) {

        //Calculo del impuesto
        double costo_base = precioXdistancia + precioXpeso;
        double impuesto = costo_base * 0.19;

        return impuesto;
        
    }

    public static double calculo_total(double calculo_total){

        //Calculo del precio total
        total = precioXpeso + precioXdistancia + impuesto;

        return total;

    }

    public static void resumen() {

        //Configuración del formato para que use puntos en los miles, y variable de espera
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.ITALY);
        DecimalFormat df = new DecimalFormat("#,###", simbolos);

        String espera;

        //Imprimir el resumen
        System.out.println("\n============================================");
        System.out.println("            RESUMEN DEL ENVIO\n");
        System.out.println("El peso del envio es: " + peso + "Kg");
        System.out.println("La distancia del envio es: " + distancia+ "Km");
        System.out.println("El precio por peso del envio es: $" + df.format(precioXpeso));
        System.out.println("El precio por distancia del envio es: $" + df.format(precioXdistancia));
        System.out.println("El precio del impuesto (19%) del envio es: $" + df.format(impuesto));
        System.out.println("El precio total del envio es: $" + df.format(total));
        System.out.println("============================================");

        //Mensaje de espera, para mejor lectura
        System.out.println("\nPrecione enter para continuar");
        espera = sc.nextLine();

    }

    public static boolean opcion_repetir(boolean opcion_repetir) {

        //Declara variable para ciclo de opcion invalida
        boolean opcion_invalida = false;

        //Ciclo indefinido en caso de que el usuario digite una opcion invalida
        do{

            System.out.println("\n============================================");
            System.out.println("¿Deseas hacer otra consulta de envio?");
            System.out.println("1.Si");
            System.out.println("2.No\n");
            System.out.print("Digite su respuesta: ");
            int opcion = sc.nextInt();
            System.out.println("============================================");

            //Verifica la opcion dada por el usuario
            if (opcion == 1){
                
            }else if (opcion == 2){
                System.out.println("\nGracias por usar la app");
                repetir = false;

            }else{
                System.out.println("Opcion invalida, dijite 1 o 2.");
                opcion_invalida = true;
            }

        }while (opcion_invalida == true);
        
        return repetir;

    }

}
