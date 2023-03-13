public class Main {

   public static void main(String []args) {

      Company c = new Company();
      c.create("Rafael");
      c.create("Pepe");
      c.create("Auxi");
      System.out.println(c.toString());

      String elem = "Rafael";
      System.out.println(c.idxOf(elem) + "/" + c.read(elem));
      
      c.update("Rafael", "Rafa");
      c.delete("Auxi");
      System.out.println(c.toString());

   }
}
