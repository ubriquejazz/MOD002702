import java.util.Random;
import java.util.Scanner;

public class Restaurante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] mesas = new int[10];
        
        // Carga inicial de mesas con valores aleatorios entre 0 y 4
        for(int i=0; i<mesas.length; i++){
            mesas[i] = rand.nextInt(5);
        }
        
        // Bucle principal para colocar a los clientes en las mesas
        while(true){
            System.out.print("¿Cuántos son en el grupo? (máximo 4 personas): ");
            int grupo = sc.nextInt();
            
            if(grupo <= 0){
                System.out.println("Debe ingresar un número mayor a cero.");
            } else if(grupo > 4){
                System.out.println("Lo siento, no admitimos grupos de " + grupo + " personas, haga grupos de 4 personas como máximo e intente de nuevo.");
            } else {
                // Busca la primera mesa libre
                int mesaLibre = -1;
                for(int i=0; i<mesas.length; i++){
                    if(mesas[i] == 0){
                        mesaLibre = i;
                        break;
                    }
                }
                
                // Si no hay mesas libres, busca una mesa con espacio suficiente
                if(mesaLibre == -1){
                    for(int i=0; i<mesas.length; i++){
                        if(mesas[i] + grupo <= 4){
                            mesaLibre = i;
                            break;
                        }
                    }
                }
                
                // Si se encontró una mesa disponible, coloca al grupo en ella
                if(mesaLibre != -1){
                    mesas[mesaLibre] += grupo;
                    System.out.println("Grupo de " + grupo + " personas sentado en la mesa " + (mesaLibre+1));
                } else {
                    System.out.println("Lo siento, no hay mesas disponibles en este momento.");
                }
            }
            
            // Muestra el estado de las mesas después de colocar al grupo
            System.out.println("Estado de las mesas:");
            for(int i=0; i<mesas.length; i++){
                System.out.println("Mesa " + (i+1) + ": " + mesas[i] + " personas");
            }
            System.out.println();
        }
    }
}
