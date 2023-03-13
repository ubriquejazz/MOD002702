import java.util.Scanner;

public class AplicacionCuentaBancaria {
    
    static Scanner sc = new Scanner(System.in);
    static CuentaBancaria cuenta;

    public static void main(String[] args) {
        String cc = "20385778983000760236";
        String aux, dc;

        cuenta=new CuentaBancaria(cc);
        System.out.println(cuenta);
        dc = CuentaBancaria.obtenerDigitosControl(cuenta.getEntidad(),  cuenta.getOficina(),  cuenta.getNumCuenta());
        int opcion = 0;
        do {
            pintarMenu();
            opcion=sc.nextInt();
            switch (opcion){
                case 0:
                    break;
                case 1:
                    aux = cuenta.getEntidad() + cuenta.getOficina() + dc + cuenta.getNumCuenta();
                    System.out.println("Nº de cuenta: " + aux);
                    break;
                case 2: System.out.println("Titular: " + cuenta.getTitular());
                    break;
                case 3: System.out.println("Entidad: " + cuenta.getEntidad());
                    break;
                case 4: System.out.println("Sucursal: " + cuenta.getOficina());
                    break;
                case 5: System.out.println("Cuenta: " + cuenta.getNumCuenta());
                    break;
                case 6: System.out.println("Digitos de control: " + dc);
                    break;
                case 7: ingreso();
                    break;
                case 8: retirada();
                    break;
                case 9: System.out.println("Saldo: " + cuenta.getSaldo() + "€");
                    break;
                default:
                    System.out.println("Introduzca un valor entre 0 y 9");
            }
        }while(opcion != 0);
    }
    
    /*
     * Método que solicita la cantidad a ingresar y comprueba que se han introducido
     * valores numéricos positivos
     */
    public static void ingreso() {
        double dinero;
        System.out.println("¿Qué cantidad desea ingresar?");
        dinero=sc.nextDouble();
        if(dinero<0) 
            System.out.println("Sólo números positivos");
        else
            cuenta.ingresar(dinero);
    }
        
    public static void retirada() {
        double dinero;
        System.out.println("¿Qué cantidad desea retirar?");
        dinero=sc.nextDouble();
        if(dinero<0) 
            System.out.println("Sólo números positivos");
        else
            cuenta.retirar(dinero);
    }

    public static void pintarMenu() {
        System.out.println("--------------------");
        System.out.println("1 - Ver el número de cuenta completo");
        System.out.println("2 - Ver el titular de la cuenta");
        System.out.println("3 - Ver el código de la entidad");
        System.out.println("4 - Ver el código de la oficina");
        System.out.println("5 - Ver el número de la cuenta");
        System.out.println("6 - Ver los dígitos de control de la cuenta");
        System.out.println("7 - Realizar un ingreso");
        System.out.println("8 - Retirar efectivo");
        System.out.println("9 - Consultar saldo");
        System.out.println("0 - Salir de la aplicación");
        System.out.println("--------------------");
    }
}
