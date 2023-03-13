public class Main {

   public static void main(String []args) {

      Clinica c = new Clinica();
      c.insertaAnimal("Rafael");
      c.insertaAnimal("Pepe");
      c.insertaAnimal("Auxi");
      System.out.println(c.toString());

      String elem = "Rafael";
      System.out.println(c.idxOf(elem) + "/" + c.buscaAnimal(elem));
      
      c.update("Rafael", "Rafa");
      c.delete("Auxi");
      System.out.println(c.toString());

   }
}
