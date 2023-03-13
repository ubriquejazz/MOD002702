import java.util.Objects;

public class Animal {
    private int id;
    private String name;

    public Animal(String name) {
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
        Animal Animal = (Animal)o;
        if(Animal.id == this.id) {
            return true; 
        } else return false;
    }

    public int hashCode() {
         // here we are using id. We can also use other logic such as prime number addition or memory address.
        return id;
    }

}
