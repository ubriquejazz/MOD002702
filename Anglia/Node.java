public class Node {

    Node north = null;
    Node south = null;
    Node east = null;
    Node west = null;

    private String name;
    private int finish = 0;

    public Node (String newName, int inFinish) {
        this.name = newName;
        this.finish = inFinish; 
    }
    
    public String getName() {
        return this.name;
    }

    public int getFinish() {
        return this.finish;
    }

/*      buildDoor(dir: string, target:Node): bool +getDoors(): string
 *      displayOptions()
 *      go(dir: string): Node
 */


/*      Save(textOut: stream)
 *      Save(file: string): bool
 *      Load(textIn: stream): Node +Load(file: string): Node
 */

}
