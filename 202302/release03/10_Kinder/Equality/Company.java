import java.util.ArrayList;

public class Company {

    //  lista de empleados
    private ArrayList<Employee> l = new ArrayList<Employee>();
    
    public boolean isEmpty() {
        return l.isEmpty();
    }

    public int idxOf(String name) {
        for (Employee aux: l) {
            if (aux.getName().equals(name))    
                return l.indexOf(aux);
        }
        return (-1);
    }

    // CRUD Employee - Create
    public void create(String name) {
        Employee aux = null;
        do {
            aux = new Employee(name);
        } while (l.contains(aux));  // inderectamente usa Employee.equals()
        l.add(aux);                 // ArrayList
    }

    // CRUD Employee - Delete
    public int delete(String name) {
        int idx = this.idxOf(name);
        if (idx >= 0) {
            l.remove(idx); // ArrayList
        }
        return idx;
    }

    // CRUD Employee - Update
    public int update(String name, String newName) {
        int idx = this.idxOf(name);
        if (idx >= 0) {
            Employee aux = l.get(idx); // ArrayList
            aux.setName(newName);
        }
        return idx;
    }

    // CRUD Employee - Read
    public int read(String name) {
        int idx = this.idxOf(name);
        if (idx >= 0) {
            Employee aux = l.get(idx);
            return aux.hashCode();
        }        
        return (-1);
    }

    @Override
    public String toString() {
        return l.toString();
    }

}