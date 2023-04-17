import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private float salary;

    public Employee(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.salary = 10;
    }

    public Employee(String name, float salary) {
        this.id = (int)(Math.random()*1000);
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "{"+id+"} " + name + ", " + salary + "$";
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

}
