public class Main {
    
    public static void test01() {
        Profesor juan = new Profesor("Juan Gago", "011223344X", 0);
        System.out.println(juan);
    }

    public static void test02() {
        Tribunal t = new Tribunal("profesores.csv");
        System.out.println(t);
        //System.out.println(t.getTamano());
        t.EligeTribunal();
    }

    public static void main(String[] args) {
        test02();
    }
}