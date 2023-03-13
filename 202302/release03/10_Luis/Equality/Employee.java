import java.util.Objects;

public class Employee {
    private int id;
    private String name;

    public Employee(String name) {
        this.id = (int)(Math.random()*1000);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "{id="+id+", name="+name+"} ";
    }

    @Override
    public boolean equals(Object o) {
        // now check the referenc of both object
        if(this == o) return true;

        // check the type of class
        if(o == null || o.getClass() != this.getClass()) return false;

        // now compare the value
        Employee employee = (Employee)o;
        if(employee.id == this.id) {
            return true; 
        } else return false;
    }

    public int hashCode() {
         // here we are using id. We can also use other logic such as prime number addition or memory address.
        return id;
    }

}
