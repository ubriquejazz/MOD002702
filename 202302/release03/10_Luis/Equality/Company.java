import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Company {

    //  lista de empleados
    private ArrayList<Employee> l = new ArrayList<Employee>();
    
    public Company(String fichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] fila = linea.split(",");
                int id = Integer.parseInt(fila[0]);
                float salary = Float.parseFloat(fila[2]);
                Employee employee = new Employee(id, fila[1],salary);
                l.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    public void create(String name, float salary) {
        Employee aux = null;
        do {
            aux = new Employee(name, salary);
        } while (l.contains(aux));
        l.add(aux);                
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
    public Employee read(String name) {
        int idx = this.idxOf(name);
        if (idx >= 0) {
            return l.get(idx);
        }        
        return null;
    }

    @Override
    public String toString() {
        return l.toString();
    }

    public void save(String fichero){
        try (FileWriter fw = new FileWriter(fichero)) {
            for (Employee employee : l) {
                String linea = employee.getId() + "," + employee.getName() + "," + employee.getSalary();
                fw.write(linea + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}