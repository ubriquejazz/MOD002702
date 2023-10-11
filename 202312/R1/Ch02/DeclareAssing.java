public class DeclareAssign {

    public static void main(String[] args) {
        String message;      // declaration
        message = "Hello!";  // give message the value "Hello!"
        int hour = 11;           // assign the value 11 to hour
        int minute = 59;         // set minute to 59
 
        System.out.print("Number of minutes since midnight: ");
        System.out.println(hour * 60 + minute);
    }

}