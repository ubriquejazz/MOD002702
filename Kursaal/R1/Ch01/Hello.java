public class Hello {

    int calcula() {
        return 0;
    }
    public static void main(String[] args) {
        // generate some simple output
        System.out.println("Hello, World!");
        System.out.println("How are you?");
        int hour = 20;
        int min = 0;
        int second = 0;

        int secFromMidnight = (hour * 60  /* minutos */ + min) * 60 + second;
        System.out.println("Seconds from midnight: " + secFromMidnight);
    }
}