import java.util.ArrayList;

public class Clinica {

    //  lista de empleados
    private ArrayList<Animal> l = new ArrayList<Animal>();
    
    public boolean isEmpty() {
        return l.isEmpty();
    }

    public int idxOf(String name) {
        for (Animal aux: l) {
            if (aux.getName().equals(name))    
                return l.indexOf(aux);
        }
        return (-1);
    }

    // insertaAnimal() - Create (CRUD)
    public void insertaAnimal(String name) {
        Animal aux = null;
        do {
            aux = new Animal(name);
        } while (l.contains(aux));  // inderectamente usa Animal.equals()
        l.add(aux);                 // ArrayList
    }

    // buscaAnimal() - Read (CRUD)
    public int buscaAnimal(String name) {
        int idx = this.idxOf(name);
        if (idx >= 0) {
            Animal aux = l.get(idx);
            return aux.hashCode();
        }        
        return (-1);
    }

    @Override
    public String toString() {
        return l.toString();
    }

    //////////////////////////////////////

    public int delete(String name) {
        int idx = this.idxOf(name);
        if (idx >= 0) {
            l.remove(idx); // ArrayList
        }
        return idx;
    }

    public int update(String name, String newName) {
        int idx = this.idxOf(name);
        if (idx >= 0) {
            Animal aux = l.get(idx); // ArrayList
            aux.setName(newName);
        }
        return idx;
    }
}