import java.util.*;

public class CListaTfnos 
{
	private ArrayList<CPersona> lista;
	int nElementos;
	
	public CListaTfnos() {
		lista = new ArrayList<CPersona>();
		nElementos = 0;
	}
	
	public void ListaTfnos_anadir (CPersona nuevo) {
		lista.add(nuevo);
		nElementos = lista.size();
	}
	
	public int ListaTfnos_buscar(String nom, int posInicio) {
		int retVal = -1;
		if (posInicio >= nElementos)
			return -1;
		
		for (int i=posInicio; i<nElementos && retVal == -1; i++) {
			CPersona p = lista.get(i);
			// C: strcmp(cad1, cad2) == 0
			// Java: 0 si cad1=cad2, 1 si cad1>cad2
			if (p.getNombre().compareTo(nom) == 0) {
				retVal = i;
			}
		}
		return retVal;
	}
	
}
