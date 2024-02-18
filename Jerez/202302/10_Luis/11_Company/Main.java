public class Main {

   public static void main(String []args) {

      Company c = new Company("datos.csv");
      c.create("Luis", 1199);
      c.create("Juan", 1200);
      c.create("Paco", 999);
      System.out.println(c);
      c.update("Rafael", "Rafa");
      System.out.println(c.read("Rafa"));
      c.delete("Auxi");
      System.out.println(c);
      c.save("datos_procesados.csv");
   }
}
