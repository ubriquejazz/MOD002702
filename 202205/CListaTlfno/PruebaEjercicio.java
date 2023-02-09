import java.io.*;

public class PruebaEjercicio {
	
	public static void main (String [] argv) {
		
			CPersona p1 = new CPersona ("Mila", "Calle Alama", 11111111);
			CPersona p2 = new CPersona ("Paco", "C/ Huercal", 22222222);
			CPersona p3 = new CPersona ("Juan", "C/ Ubrique", 33333333);
			CPersona p4 = new CPersona ("Bea", "Calle Alama", 44444444);
			
			CListaTfnos agenda = new CListaTfnos();

			agenda.ListaTfnos_anadir(p1);
			int pos = agenda.ListaTfnos_buscar("Juan", 0);
			System.out.println("Esta en la posicion " + pos);
			
			agenda.ListaTfnos_anadir(p2);
			pos = agenda.ListaTfnos_buscar("Juan", 0);
			System.out.println("Esta en la posicion " + pos);
			
			agenda.ListaTfnos_anadir(p3);
			pos = agenda.ListaTfnos_buscar("Juan", 0);
			System.out.println("Esta en la posicion " + pos);
	}
}
