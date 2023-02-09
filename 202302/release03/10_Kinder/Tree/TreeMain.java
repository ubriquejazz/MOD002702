public class TreeMain {

  public static void main(String[] args) {
    System.out.print("Binary tree");
    BinaryTree bt = new BinaryTree();
    bt.add(6);
    bt.add(4);
    bt.add(8);
    bt.add(3);
    bt.add(5);
    bt.add(7);
    bt.add(9);

    System.out.println("\nEn anchura");
    bt.traverseLevelOrder();
    System.out.println("\nSize: " + bt.getSize());
    
    int element = 15;
    if (bt.containsNode(element)) 
      System.out.println("Found element " + element);

    System.out.println("In-orden");
    bt.traverseInOrder();

    System.out.println("\nPre-orden");
    bt.traversePreOrder();

    System.out.println("\nPost-orden");
    bt.traversePostOrder();        
  }
}