import java.util.Scanner;

public class Main {

        public static void Menu() {
            String answer = "";
            int counter = 0;
            Scanner sc = new Scanner(System.in);

            do {
                counter++;
                String filename = "simple.txt";
                Maze loadMaze = Maze.Load(filename); 
                loadMaze.reLoadDoors(filename);

                Node current;
                current = loadMaze.findNode("A1"); 
                boolean keepPlaying = true;
                do {
                    current.displayOptions();
                    answer = sc.nextLine().toUpperCase();
                    current = current.go(answer);
                    try {
                        keepPlaying = (current.getFinish() == 0); 
                    }
                    catch (Exception) {
                        System.out.println("Node not found");
                    }

                } while (keepPlaying && !answer.equals("Q"));
                System.out.println("Do you want to play again (Y/N)?");
                answer = sc.nextLine().toUpperCase();
                
            } while (answer.equals("Y"));
            System.out.println("You have played " + counter + " games");
        }

        public static void main(String[] args) {
            Menu();
        }
    }